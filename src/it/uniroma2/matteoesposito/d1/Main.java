package it.uniroma2.matteoesposito.d1;
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

import it.uniroma2.matteoesposito.d1.entities.CSVData;
import it.uniroma2.matteoesposito.d1.entities.Element;
import it.uniroma2.matteoesposito.d1.utils.RetrieveTicketsID;
import it.uniroma2.matteoesposito.d1.utils.Utilities;

/**
 * @author Matteo
 *
 */

public class Main {

	/**
	 * @param args
	 * @throws JSONException 
	 * @throws IOException 
	 * @throws ParseException 
	 */
	public static void main(String[] args) throws IOException, JSONException, ParseException  {
		Utilities.start();
		System.exit(0);

	
	}

}

