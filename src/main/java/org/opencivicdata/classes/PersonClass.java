package org.opencivicdata.classes;

import org.opencivicdata.api.ArgMap;
import org.opencivicdata.api.MethodMap;
import org.opencivicdata.api.OpenCivicDataAPI;
import org.opencivicdata.api.OpenCivicDataException;
import org.opencivicdata.data.Person;
import org.opencivicdata.data.Persons;

/**
 * This class accesses the <a href="http://sunlightlabs.github.io/openstates-api/organizations.html">People</a> 
 * methods of the OpenCivicData API.
 * 
 *  <pre>
 *  There are generally two methods available for organization data:
 *  Method	              Description
 *  Person Search      Search organizations by any of their attributes.
 *  Person Detail      Get full detail for organization, including all members.
 * </pre>
 */
public class PersonClass extends ClassesBase {

	/**
	 * Constructor for testing purposes.
	 * 
	 * @param api
	 */
	public PersonClass(OpenCivicDataAPI api) {
		super(api);
	}

	/**
	 * Default constructor
	 */
	public PersonClass() throws OpenCivicDataException {
		super();
	}

	public Persons search(
		String name, 
		String gender, 
		String birth_date, 
		String death_date, 
		String updated_at, 
		String created_at,  
		String member_of, 
		String ever_member_of, 
		String fields, 
		String sort, 
		String page, 
		String per_page
	) throws OpenCivicDataException {
		return api.query(
			new MethodMap("people"), 
			new ArgMap(
				"name", name, 
				"gender", gender, 
				"birth_date", birth_date, 
				"death_date", death_date, 
				"updated_at", updated_at, 
				"created_at", created_at,  
				"member_of", member_of, 
				"ever_member_of", ever_member_of, 
				"fields", fields, 
				"sort", sort, 
				"page", page, 
				"per_page", per_page
			), 
			Persons.class
		);
	}

	public Persons searchByName(
		String name
	) throws OpenCivicDataException {
		return api.query(
			new MethodMap("people"), 
			new ArgMap(
				"name", name
			), 
			Persons.class
		);
	}

	public Persons search() throws OpenCivicDataException {
			return api.query(
				new MethodMap("people"), 
				null, 
				Persons.class
			);
		}

	public Person detail(String personId) throws OpenCivicDataException {
		return api.query(new MethodMap(personId), null, Person.class);
	}
}
