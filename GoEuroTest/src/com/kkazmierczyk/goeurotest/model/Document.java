package com.kkazmierczyk.goeurotest.model;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * One Document (list of records) 
 * 
 * @author kkazmierczyk
 *
 */
public class Document {

	List<Record> results = new ArrayList<>();
	
	public void addResult(Record record) {
		results.add(record);
	}
	
	public List<Record> getResults() {
		return results;
	}
}
