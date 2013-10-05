package com.example.handsoncentralohio;

public class Event {

	private int id;
	private String name;
	private String description;
	
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
}
