package com.kkazmierczyk.goeurotest.importer;

import com.kkazmierczyk.goeurotest.model.Document;

public interface Importer {

	public Document importData() throws ImportException;
}
