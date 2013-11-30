package com.kkazmierczyk.goeurotest.importer.impl;

import java.io.FileInputStream;
import java.io.InputStream;

import org.apache.commons.io.IOUtils;
import org.junit.Assert;
import org.junit.Test;

import com.kkazmierczyk.goeurotest.model.Document;

public class WebServiceJSONImporterTest {

	@Test
	public void testParseJSON_null() {
		final String nullString = "null";
		Assert.assertEquals(0, WebServiceJSONImporter.parseJSON(nullString).getResults().size());
	}
	
	@Test
	public void testParseJSON1() throws Exception {
		
		InputStream inputStream = new FileInputStream("test/jsonteststring1.json");
	    final String string = IOUtils.toString(inputStream);
		
		Assert.assertEquals(2, WebServiceJSONImporter.parseJSON(string).getResults().size());
	}

	@Test
	//* Test with slightly modified input */ 
	public void testParseJSON2() throws Exception {
		
		InputStream inputStream = new FileInputStream("test/jsonteststring2.json");
	    final String string = IOUtils.toString(inputStream);
		
		Document document = WebServiceJSONImporter.parseJSON(string);
		Assert.assertEquals(2, document.getResults().size());
		Assert.assertNull(document.getResults().get(1).get_id());
	}
	
}
