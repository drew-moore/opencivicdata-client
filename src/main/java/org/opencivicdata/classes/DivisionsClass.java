package org.opencivicdata.classes;

import org.opencivicdata.api.ArgMap;
import org.opencivicdata.api.MethodMap;
import org.opencivicdata.api.OpenCivicDataAPI;
import org.opencivicdata.api.OpenCivicDataException;
import org.opencivicdata.data.Division;
import org.opencivicdata.data.Divisions;

/**
 * This class accesses the <a href="http://sunlightlabs.github.io/openstates-api/divisions.html">Divisions</a> 
 * methods of the OpenCivicData API.
 * 
 *  <pre>
 *  There are two methods available for division data:
 *  Method	              Description
 *  Division Search      Search divisions by any of their attributes.
 *  Division Detail      Get full detail for division, including all members.
 * </pre>
 */
public class DivisionsClass extends ClassesBase {

	/**
	 * Constructor for testing purposes.
	 * 
	 * @param api
	 */
	public DivisionsClass(OpenCivicDataAPI api) {
		super(api);
	}

	/**
	 * Default constructor
	 */
	public DivisionsClass() throws OpenCivicDataException {
		super();
	}

	public Divisions searchByLatLon(double lat, double lon) throws OpenCivicDataException {
		return api.query(
			new MethodMap("divisions"), 
			new ArgMap("lat", Double.toString(lat), "lon", Double.toString(lon) ), 
			Divisions.class
		);
	}
	
	public Divisions search(
		String lat, 
		String lon, 
		String date, 
		String fields, 
		String sort, 
		String page, 
		String per_page
	) throws OpenCivicDataException {
		return api.query(
			new MethodMap("divisions"), 
			new ArgMap(
					"lat", lat, 
					"lon", lon, 
					"date", date, 
					"fields", fields, 
					"sort", sort, 
					"page", page, 
					"per_page", per_page
				), 
			Divisions.class
		);
	}

	public Division detail(String divisionId) throws OpenCivicDataException {
		return api.query(new MethodMap(divisionId), null, Division.class);
	}
}
