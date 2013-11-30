package com.kkazmierczyk.goeurotest.importer.impl;

import java.io.IOException;

import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import com.google.gson.Gson;
import com.kkazmierczyk.goeurotest.importer.ImportException;
import com.kkazmierczyk.goeurotest.importer.Importer;
import com.kkazmierczyk.goeurotest.model.Document;

public class WebServiceJSONImporter implements Importer {

	public WebServiceJSONImporter(String webRequestAddress) {
		this.webRequestAddress = webRequestAddress;
	}

	private final String webRequestAddress;

	@Override
	public Document importData() throws ImportException {
		CloseableHttpClient httpclient = HttpClients.createDefault();
		try {
			HttpGet httpget = new HttpGet(webRequestAddress);

			//System.out.println("executing request " + httpget.getURI());
			// Create a response handler
			ResponseHandler<String> responseHandler = new BasicResponseHandler();
			// Body contains json string
			String responseBody = httpclient.execute(httpget, responseHandler);

			return parseJSON(responseBody);

		} catch (Exception e) {
			throw new ImportException(e);
		} finally {
			// When HttpClient instance is no longer needed,
			// shut down the connection manager to ensure
			// immediate deallocation of all system resources
			try {
				httpclient.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	/* package */static Document parseJSON(String string) {
		if ("null".equals(string))
			return new Document();

		Gson gson = new Gson();
		Document doc = gson.fromJson(string, Document.class);

		return doc;
	}
}
