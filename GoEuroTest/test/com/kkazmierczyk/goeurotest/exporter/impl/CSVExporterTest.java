package com.kkazmierczyk.goeurotest.exporter.impl;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.commons.io.IOUtils;
import org.junit.Assert;
import org.junit.Test;

import com.kkazmierczyk.goeurotest.exporter.Exporter;
import com.kkazmierczyk.goeurotest.model.Document;
import com.kkazmierczyk.goeurotest.model.Position;
import com.kkazmierczyk.goeurotest.model.Record;

public class CSVExporterTest {

	@Test
	public void testExportData() {

		FileInputStream inputStream = null;
		File file = null;
		
		try {
			Document d = new Document();
			d.addResult(new Record("Position", (long) 410978, "Potsdam, USA", "location", new Position(44.66978, -74.98131)));
			d.addResult(new Record("Position", (long) 377078, "Potsdam, Deutschland", "location", new Position(52.39886, 13.06566)));
			
			file = new File("exporterTest.csv");
			Exporter e = new CSVExporter(file);
			e.exportData(d);

			/** End of line */
			final String EOLN = System.getProperty("line.separator");
			
			final String expected = 
					"Position;410978;Potsdam, USA;location;-74.98131;44.66978" + EOLN + 
					"Position;377078;Potsdam, Deutschland;location;13.06566;52.39886" + EOLN;
			
			inputStream = new FileInputStream(file);
		    final String actual = IOUtils.toString(inputStream);
			
			Assert.assertEquals(expected, actual);
		} catch (IOException e1) {
			Assert.fail("IO message when processing data. See stack trace");
			e1.printStackTrace();
		} finally {
			if (inputStream != null) {
				try {
					inputStream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (file != null && file.exists()) {
				file.delete();
			}
		}
	}

	
	@Test
	public void testExportDataNullValues() {

		FileInputStream inputStream = null;
		File file = null;
		
		try {
			Document d = new Document();
			d.addResult(new Record(null, null, "Potsdam, USA", "location", new Position(44.66978, -74.98131)));
			d.addResult(new Record("Position", (long) 377078, "Potsdam, Deutschland", "location", new Position(52.39886, 13.06566)));
			
			file = new File("exporterTest.csv");
			Exporter e = new CSVExporter(file);
			e.exportData(d);

			/** End of line */
			final String EOLN = System.getProperty("line.separator");
			
			final String expected = 
					"null;null;Potsdam, USA;location;-74.98131;44.66978" + EOLN + 
					"Position;377078;Potsdam, Deutschland;location;13.06566;52.39886" + EOLN;
			
			inputStream = new FileInputStream(file);
		    final String actual = IOUtils.toString(inputStream);
			
			Assert.assertEquals(expected, actual);
		} catch (IOException e1) {
			Assert.fail("IO message when processing data. See stack trace");
			e1.printStackTrace();
		} finally {
			if (inputStream != null) {
				try {
					inputStream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (file != null && file.exists()) {
				file.delete();
			}
		}
	}
}
