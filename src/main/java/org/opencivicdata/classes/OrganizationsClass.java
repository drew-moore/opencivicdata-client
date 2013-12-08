package org.opencivicdata.classes;

import org.opencivicdata.api.ArgMap;
import org.opencivicdata.api.MethodMap;
import org.opencivicdata.api.OpenCivicDataAPI;
import org.opencivicdata.api.OpenCivicDataException;
import org.opencivicdata.data.Organization;
import org.opencivicdata.data.Organizations;

/**
 * This class accesses the <a href="http://sunlightlabs.github.io/openstates-api/organizations.html">Organizations</a> 
 * methods of the OpenCivicData API.
 * 
 *  <pre>
 *  There are two methods available for organization data:
 *  Method	              Description
 *  Organization Search      Search organizations by any of their attributes.
 *  Organization Detail      Get full detail for organization, including all members.
 * </pre>
 */
public class OrganizationsClass extends ClassesBase {

	/**
	 * Constructor for testing purposes.
	 * 
	 * @param api
	 */
	public OrganizationsClass(OpenCivicDataAPI api) {
		super(api);
	}

	/**
	 * Default constructor
	 */
	public OrganizationsClass() throws OpenCivicDataException {
		super();
	}

	public Organizations search(
		String classification,
		String founding_date,
		String dissolution_date,
		String jurisdiction_id,
		String parent_id,
		String division_id,
		String chamber,
		String name,
		String updated_at,
		String created_at,
		String fields, 
		String sort, 
		String page, 
		String per_page
	) throws OpenCivicDataException {
		return api.query(
			new MethodMap("organizations"), 
			new ArgMap(
				"classification", classification, 
				"founding_date", founding_date, 
				"dissolution_date", dissolution_date, 
				"jurisdiction_id", jurisdiction_id, 
				"parent_id", parent_id, 
				"division_id", division_id, 
				"chamber", chamber,
				"name", name, 
				"updated_at", updated_at, 
				"created_at", created_at, 
				"fields", fields, 
				"sort", sort, 
				"page", page, 
				"per_page", per_page
			), 
			Organizations.class
		);
	}

	public Organizations searchByJurisdiction(
		String jurisdiction_id
	) throws OpenCivicDataException {
		return api.query(
			new MethodMap("organizations"), 
			new ArgMap(
				"jurisdiction_id", jurisdiction_id 
			), 
			Organizations.class
		);
	}


	public Organizations searchByDivision(String division_id) throws OpenCivicDataException {
			return api.query(
				new MethodMap("organizations"), 
				new ArgMap(
					"division_id", division_id 
				), 
				Organizations.class
			);
		}

	public Organization detail(String organizationId) throws OpenCivicDataException {
		return api.query(new MethodMap(organizationId), null, Organization.class);
	}
}
