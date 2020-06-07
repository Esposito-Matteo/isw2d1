import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.net.URLConnection;
import java.util.Base64;
import java.util.Map;
import java.util.Date;
import java.util.HashMap;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.apache.commons.lang3.ArrayUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.google.gson.Gson;

import Entity.Element;
import Entity.csvData;


/**
 * 
 */

/**
 * @author Matteo
 *
 */

public class main {

	/**
	 * 
	 * @return
	 * @throws IOException
	 * @throws JSONException
	 */
	public static Map<String,Date> getTicket()  throws IOException, JSONException {
		// TODO Auto-generated method stub
		Map<String,Date> ids = new HashMap<String,Date>();

		String projName ="EAGLE";
		String type ="New%20Feature";
		Integer j = 0, i = 0, total = 1;
		//Get JSON API for closed bugs w/ AV in the project
		do {
			//Only gets a max of 1000 at a time, so must do this multiple times if bugs >1000
			j = i + 1000;
			String url = "https://issues.apache.org/jira/rest/api/2/search?jql=project=%22"
					+ projName + "%22AND%22issueType%22=%22"+type+"%22AND(%22status%22=%22closed%22OR"
					+ "%22status%22=%22resolved%22)AND%22resolution%22=%22fixed%22&fields=key,resolutiondate,versions,created&startAt="
					+ i.toString() + "&maxResults=" + j.toString();
			JSONObject json = RetrieveTicketsID.readJsonFromUrl(url);
			//System.out.println(json.toString());
			JSONArray issues = json.getJSONArray("issues");
			total = json.getInt("total");
			for (; i < total && i < j; i++) {
				//Iterate through each bug
				ids.put(issues.getJSONObject(i%1000).get("key").toString(),new Date(0));
			}  
		} while (i < total);
		return ids;
	}

	/**
	 * 
	 * @return
	 * @throws IOException
	 * @throws JSONException
	 */
	public static Element[] getGitCommits()  throws IOException, JSONException {
		Element[] elements = null;
		String Json_String;
		int page = 1;
		do {
			String url = "https://api.github.com/repos/apache/eagle/commits?page="+Integer.toString(page)+"&per_page=100";	       
			Json_String=readToString(url);  
			Gson gson = new Gson();
			Element[] temp = gson.fromJson(Json_String, Element[].class);
			elements = ArrayUtils.addAll(elements, temp);
			page +=1;
		}while(!Json_String.equals("[]"));

		return elements;
	}
	/**
	 * 
	 * @param targetURL
	 * @return
	 * @throws IOException
	 */
	public static String readToString(String targetURL) throws IOException
	{

		URL url = new URL(targetURL);
		String b64enctkn ="OThjMzMzYzIyN2U1NGMzMTIwNTk1YWI2Njc1YTA3MTJlMWNmYmRlNQ==";
		String token = new String(Base64.getDecoder().decode(b64enctkn));
		URLConnection conn = url.openConnection();
		conn.setRequestProperty("Authorization", "token " + token);
		BufferedReader bufferedReader = new BufferedReader(
				new InputStreamReader(conn.getInputStream()));

		StringBuilder stringBuilder = new StringBuilder();

		String inputLine;
		while ((inputLine = bufferedReader.readLine()) != null)
		{
			stringBuilder.append(inputLine);
			stringBuilder.append(System.lineSeparator());

		}

		bufferedReader.close();
		return stringBuilder.toString().trim();
	}


	public static HashMap<String,String> aggregate(Map<String,Date>JiraTicket){
		Map<String,String> result = new HashMap<String,String>();



		return null;

	}


	public static Map<String, Integer> createCalendar( Element[] elements) throws ParseException {
		Map<String, Integer> result = new HashMap<String,Integer>();
		int start_y = Integer.parseInt(elements[elements.length -1].getCommit().getAuthor().getDate().substring(0,4));
		int start_m = Integer.parseInt(elements[elements.length -1].getCommit().getAuthor().getDate().substring(5,7));
		int end_y 	= Integer.parseInt(elements[0].getCommit().getAuthor().getDate().substring(0,4));
		int end_m 	= Integer.parseInt(elements[0].getCommit().getAuthor().getDate().substring(5,7));

		int m = start_m;
		while (start_y<=end_y){

			while(m<=12) {
				boolean cond1 = (start_y==end_y)&&(m<=end_m);
				boolean cond2 = start_y<end_y;
				if(cond1||cond2) {

					String month = "";

					if(m<10) {
						month = "0"+ String.valueOf(m);
					}else {
						month = String.valueOf(m);
					}

					String newkey =String.valueOf(start_y)+"-"+month;
					result.put(newkey, 0);
					System.out.println(newkey);		
				}
				m +=1;
			}
			m= 1;
			start_y +=1;
		}


		return result;
	}

	public static void generateCsv(Map<String,Integer>  agg)throws IOException {
		String header = "Date,Value";
		 
		File fout = new File("test.csv");
		FileOutputStream fos = new FileOutputStream(fout);
	 
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fos));
		bw.write(header);
		bw.newLine();
		for(Map.Entry<String, Integer> entry : agg.entrySet()) {
			String key = entry.getKey();
			Integer value = entry.getValue();
			bw.write(key + "," + value.toString());
			bw.newLine();
		}
	 
		bw.close();
	}
	


	public static csvData test2(Map<String,Date>JiraTicket, Element[] elements, Map<String,Integer> agg) 
			throws ParseException 
	{



		Map<String,Date> result = new HashMap<String,Date>(); 

		for(Element e  : elements)
		{
			String message = e.getCommit().getMessage();
			message =  message.replace("[", "");
			message =  message.replace("]", "");
			String[] ids = message.split("EAGLE-");
			String id = ids[0];
			for(String temp  : ids)
			{
				String tempID = "";
				if(isNumeric(temp)) {
					tempID = temp;
				}else {
					String[] tempArray = temp.split(" ");
					tempID = tempArray[0];
				}


				if(JiraTicket.containsKey("EAGLE-"+tempID)) {
					Date dictDate = JiraTicket.get("EAGLE-"+tempID);
					String dateString = e.getCommit().getAuthor().getDate().replace("T", " ").replace("Z", "");
					Date gitHubDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(dateString);

					if(dictDate.before(gitHubDate)) 
					{
						// Update old bucket
						DateFormat dateFormat = new SimpleDateFormat("yyyy-mm");  
						String strDate = dateFormat.format(dictDate);

						if(!dictDate.equals(new Date(0))) {
							int oldValue = agg.get(strDate);
							agg.put(dictDate.toString(), oldValue-1);
						}


						// Update new bucket
						int tempValue = agg.get(e.getCommit().getAuthor().getDate().substring(0,7));
						agg.put(e.getCommit().getAuthor().getDate().substring(0,7),tempValue +1);

						JiraTicket.put("EAGLE-"+tempID, gitHubDate); 
						// in order to ignore commit from JIRA bellogin to previously stage of projects development
						result.put("EAGLE-"+tempID, gitHubDate);
					}
				}
			}

		}
		System.out.println("ok");
		for(Map.Entry<String, Date> entry : result.entrySet()) {
			String key = entry.getKey();
			Date value = entry.getValue();

			System.out.println("KEY:\t" + key + "\t\tDate:\t" + value.toString());
			// do what you have to do here
			// In your case, another loop.
		}

		for(Map.Entry<String, Integer> entry : agg.entrySet()) {
			String key = entry.getKey();
			Integer value = entry.getValue();

			System.out.println("KEY:\t" + key + "\t\tDate:\t" + value.toString());
			// do what you have to do here
			// In your case, another loop.
		}

		csvData returnData = new csvData(result, agg);
		return returnData;
	}

	public static boolean isNumeric(String strNum) {
		if (strNum == null) {
			return false;
		}
		try {
			double d = Double.parseDouble(strNum);
		} catch (NumberFormatException nfe) {
			return false;
		}
		return true;
	}

	/**
	 * @param args
	 * @throws JSONException 
	 * @throws IOException 
	 * @throws ParseException 
	 */
	public static void main(String[] args) throws IOException, JSONException, ParseException  {



		Map<String,Date> JiraTicket = getTicket();
		Element[] elements = getGitCommits();
		Map<String,Integer> cool = createCalendar(elements);
		elements[0].getCommit().getMessage();
		System.out.println("ok");
		csvData elaborated = test2(JiraTicket, elements,cool);
		generateCsv(elaborated.getAggregated());
	}

}

