package com.kkazmierczyk.goeurotest.model;

/**
 * 
 * One position read from API endpoint. There are stored only properties which
 * are necessary for further analyzis. Another ones are ignored.
 * 
 * @author kkazmierczyk
 * 
 */
public class Record {

	final String _type;
	final Long _id;
	final String name;
	final String type;
	final Position geo_position;

	public Record(String _type, Long _id, String name, String type,
			Position geo_position) {
		this._type = _type;
		this._id = _id;
		this.name = name;
		this.type = type;
		this.geo_position = geo_position;
	}

	public String get_type() {
		return _type;
	}

	public Long get_id() {
		return _id;
	}

	public String getName() {
		return name;
	}

	public String getType() {
		return type;
	}

	public Position getGeo_position() {
		return geo_position;
	}

	public double getLattitude() {
		return geo_position.latitude;
	}

	public double getLongintude() {
		return geo_position.longitude;
	}
}
