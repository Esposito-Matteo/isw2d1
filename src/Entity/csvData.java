package Entity;

import java.util.Date;
import java.util.Map;

public class csvData {
	private  Map<String,Date> Ticket;
	private  Map<String,Integer> Aggregated;
	/**
	 * @return the ticket
	 */
	public Map<String,Date> getTicket() {
		return Ticket;
	}
	/**
	 * @param ticket the ticket to set
	 */
	public void setTicket(Map<String,Date> ticket) {
		Ticket = ticket;
	}
	/**
	 * @return the aggregated
	 */
	public Map<String,Integer> getAggregated() {
		return Aggregated;
	}
	/**
	 * @param aggregated the aggregated to set
	 */
	public void setAggregated(Map<String,Integer> aggregated) {
		Aggregated = aggregated;
	}

	public csvData(Map<String, Date> result, Map<String, Integer> agg) {
		super();
		Ticket = result;
		Aggregated = agg;
		}

	

}
