package org.opencivicdata.classes;

import org.opencivicdata.api.ArgMap;
import org.opencivicdata.api.MethodMap;
import org.opencivicdata.api.OpenCivicDataAPI;
import org.opencivicdata.api.OpenCivicDataException;
import org.opencivicdata.data.Bill;
import org.opencivicdata.data.Bills;

/**
 * The BillClass accesses the <a href="http://sunlightlabs.github.io/openstates-api/bills.html">Bills</a> methods.
 * 
 * <pre>
 * There are two methods available for bill data:
 * Method	 Description
 * Bill Search	 Search bills by (almost) any of their attributes, or full text.
 * Bill Detail	 Get full detail for bill, including any actions, votes, etc. 
 * </pre>
 *
 */
public class BillsClass extends ClassesBase {

	/**
	 * Constructor for testing purposes.
	 * 
	 * @param api
	 */
	public BillsClass(OpenCivicDataAPI api) {
		super(api);
	}

	/**
	 * Default constructor
	 */
	public BillsClass()  throws OpenCivicDataException {
		super();
	}
	
	public Bills search(
		String name,
		String chamber,
		String session,
		String jurisdiction_id,
		String type,
		String subject,
		String sponsors_id, 
		String updated_at, 
		String created_at, 
		String fields, 
		String sort, 
		String page, 
		String per_page
	) throws OpenCivicDataException {
		return api.query(
			new MethodMap("bills"), 
			new ArgMap(
				"name", name, 
				"chamber", chamber,
				"session", session,
				"jurisdiction_id", jurisdiction_id,
				"type", type,
				"subject", subject,
				"sponsors.id", sponsors_id, 
				"updated_at", updated_at, 
				"created_at", created_at, 
				"fields", fields, 
				"sort", sort, 
				"page", page, 
				"per_page", per_page
			), 
			Bills.class
		);
	}

	public Bills searchByJurisdiction(
		String jurisdiction_id
	) throws OpenCivicDataException {
		return api.query(
			new MethodMap("bills"), 
			new ArgMap(
				"jurisdiction_id", jurisdiction_id
			), 
			Bills.class
		);
	}

	public Bills search() throws OpenCivicDataException {
		return api.query(
			new MethodMap("bills"), 
			null, 
			Bills.class
		);
	}

	public Bill detail(String billId) throws OpenCivicDataException {
		return api.query(new MethodMap(billId), null, Bill.class);
	}
}
