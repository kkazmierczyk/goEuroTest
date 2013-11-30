/**
 * 
 */
package com.kkazmierczyk.goeurotest.exporter;

import java.io.IOException;

import com.kkazmierczyk.goeurotest.model.Document;

/**
 * @author kkazmierczyk
 *
 */
public interface Exporter {
	
	public void exportData(Document document) throws IOException;
}
