package com.example.handsoncentralohio;

public class EventData {

	/**
	 * Private fields for a volunteer opportunity.
	 */
	private int id; // Unique identifier for an opportunity
	private String name;
	private String description;
	private String startDate;

	public void setID(int i) {
		this.id = i;
	}
	public int getID(){
		return this.id;
	}
	public void setName(String n) {
		this.name = n;
	}
	public String getName(){
		return this.name;
	}
	public void setDescr(String d) {
		this.description = d;
	}
	public String getDescr() {
		return this.description;
	}
	public void setStartDate(String d) {
		this.description = d;
	}
	public String getStartDate() {
		return this.startDate;
	}
}
