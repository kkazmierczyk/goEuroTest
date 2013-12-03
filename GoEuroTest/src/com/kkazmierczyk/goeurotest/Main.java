package com.kkazmierczyk.goeurotest;

import java.io.File;
import java.io.IOException;

import com.kkazmierczyk.goeurotest.exporter.impl.CSVExporter;
import com.kkazmierczyk.goeurotest.importer.ImportException;
import com.kkazmierczyk.goeurotest.importer.impl.WebServiceJSONImporter;
import com.kkazmierczyk.goeurotest.model.Document;

public class Main {

	//TODO move constants to external properties file later. 
	public static final String csvFilename = "exported.csv";
	public static final String webServiceAddress = "https://api.goeuro.de/api/v1/suggest/position/en/name/Ber";
	
	/* I assume that we do not need to cathc exceptions in any way (no human readeable error message necessary) */
	public static void main(String[] args) throws ImportException, IOException {
		final Document document = new WebServiceJSONImporter(webServiceAddress + args[0]).importData();
		new CSVExporter(new File(csvFilename)).exportData(document);
	}

}
