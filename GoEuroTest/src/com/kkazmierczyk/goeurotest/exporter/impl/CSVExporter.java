package com.kkazmierczyk.goeurotest.exporter.impl;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import com.kkazmierczyk.goeurotest.exporter.Exporter;
import com.kkazmierczyk.goeurotest.model.Document;
import com.kkazmierczyk.goeurotest.model.Record;

/**
 * 
 * There is no specification how exported CSV file should look like (e.g. what
 * is the separator, should be the header available etc.) I have decided to use
 * no header and separator set to ";". We can later parametrize it if necessary
 * 
 * @author kkazmierczyk
 */
public class CSVExporter implements Exporter {

	/** CSV delimiter */
	public static final String DELIM = ";";

	/** End of line */
	public static final String EOLN = System.getProperty("line.separator");

	private File file;

	public CSVExporter(File file) {
		this.file = file;
	}

	@Override
	public void exportData(Document document) throws IOException {
		// TODO There are couple of Java libraries to export to CSV. Anyway CSV
		// format is simple so for current use we can avoid using any library

		PrintWriter writer = null;
		
		try {

		writer = new PrintWriter(file, "UTF-8");
		List<Record> records = document.getResults();

		for (Record record : records) {
			final String line = 
					record.get_type() + DELIM 
					+ record.get_id() + DELIM 
					+ record.getName()+ DELIM
					+ record.getType() + DELIM
					+ record.getLongintude() + DELIM 
					+ record.getLattitude() + EOLN;
			writer.append(line);
		}
		} finally {
			if (writer != null) {
				writer.close();
			}
		}
		
	}

}
