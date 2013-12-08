package org.opencivicdata.classes;

import org.opencivicdata.api.ArgMap;
import org.opencivicdata.api.MethodMap;
import org.opencivicdata.api.OpenCivicDataAPI;
import org.opencivicdata.api.OpenCivicDataException;
import org.opencivicdata.data.Vote;
import org.opencivicdata.data.Votes;

/**
 * The VoteClass accesses the <a href="http://sunlightlabs.github.io/openstates-api/votes.html">Votes</a> methods.
 * 
 * <pre>
 * There are two methods available for vote data:
 * Method	 Description
 * Vote Search	 Search votes by (almost) any of their attributes, or full text.
 * Vote Detail	 Get full detail for vote, including any actions, votes, etc. 
 * </pre>
 *
 */
public class VotesClass extends ClassesBase {

	/**
	 * Constructor for testing purposes.
	 * 
	 * @param api
	 */
	public VotesClass(OpenCivicDataAPI api) {
		super(api);
	}

	/**
	 * Default constructor
	 */
	public VotesClass()  throws OpenCivicDataException {
		super();
	}
	
	public Votes search(
		String jurisdiction_id, 
		String date, 
		String passed, 
		String chamber, 
		String session, 
		String type, 
		String bill_id, 
		String updated_at, 
		String created_at, 
		String fields, 
		String sort, 
		String page, 
		String per_page
	) throws OpenCivicDataException {
		return api.query(
			new MethodMap("votes"), 
			new ArgMap(
				"jurisdiction_id", jurisdiction_id, 
				"date", date, 
				"passed", passed,  
				"chamber", chamber, 
				"session", session, 
				"type", type, 
				"bill.id", bill_id,  
				"updated_at", updated_at, 
				"created_at", created_at, 
				"fields", fields, 
				"sort", sort, 
				"page", page, 
				"per_page", per_page
			), 
			Votes.class
		);
	}

	public Vote detail(String voteId) throws OpenCivicDataException {
		return api.query(new MethodMap(voteId), null, Vote.class);
	}
}
