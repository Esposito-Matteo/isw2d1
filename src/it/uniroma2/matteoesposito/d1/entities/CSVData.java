package it.uniroma2.matteoesposito.d1.entities;

import java.util.Date;
import java.util.Map;

public class CSVData {
	private  Map<String,Date> ticket;
	private  Map<String,Integer> aggregated;
	/**
	 * @return the ticket
	 */
	public Map<String,Date> getTicket() {
		return ticket;
	}
	/**
	 * @param ticket the ticket to set
	 */
	public void setTicket(Map<String,Date> inTicket) {
		ticket = inTicket;
	}
	/**
	 * @return the aggregated
	 */
	public Map<String,Integer> getAggregated() {
		return aggregated;
	}
	/**
	 * @param aggregated the aggregated to set
	 */
	public void setAggregated(Map<String,Integer> inAggregated) {
		aggregated = inAggregated;
	}

	public CSVData(Map<String, Date> result, Map<String, Integer> agg) {
		super();
		ticket = result;
		aggregated = agg;
		}

	

}
