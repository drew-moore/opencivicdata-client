package org.opencivicdata.classes;

import org.opencivicdata.api.MethodMap;
import org.opencivicdata.api.OpenCivicDataAPI;
import org.opencivicdata.api.OpenCivicDataException;
import org.opencivicdata.data.Jurisdiction;
import org.opencivicdata.data.Jurisdictions;

/**
 * Accesses the <a href="http://sunlightlabs.github.io/openstates-api/jurisdictions.html">Jurisdictions</a> methods of the OpenCivicData.api
 *  
 *  <pre>
 *  Open States makes it possible to get a listing of all jurisdictions or retrieve the boundary of a given jurisdiction.
 *  There are two methods available for jurisdiction data:
 *  Method                      Description
 *  Jurisdiction Search             List jurisdictions for state (and optionally filtered by chamber).
 *  Jurisdiction Boundary Lookup    Get geographic boundary for a jurisdiction.
 *  </pre>
 *
 */
public class JurisdictionsClass extends ClassesBase {

	/**
	 * Constructor for testing purposes.
	 * 
	 * @param api
	 */
	public JurisdictionsClass(OpenCivicDataAPI api) {
		super(api);
	}

	/**
	 * Default constructor
	 */
	public JurisdictionsClass() throws OpenCivicDataException {
		super();
	}

	/**
	 * List jurisdictions for state.
	 * 
	 * @return {@link Jurisdictions}
	 */
	public Jurisdictions search() throws OpenCivicDataException {
		return api.query(new MethodMap("jurisdictions"), null, Jurisdictions.class);
	}

	/**
	 * List jurisdiction detail.
	 * 
	 * @return {@link Jurisdiction}
	 */
	public Jurisdiction detail(String jurisdictionId) throws OpenCivicDataException {
		return api.query(new MethodMap(jurisdictionId), null, Jurisdiction.class);
	}
}
