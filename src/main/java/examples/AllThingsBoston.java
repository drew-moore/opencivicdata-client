package examples;

import java.util.ArrayList;

import org.opencivicdata.classes.BillsClass;
import org.opencivicdata.classes.DivisionsClass;
import org.opencivicdata.classes.EventsClass;
import org.opencivicdata.classes.JurisdictionsClass;
import org.opencivicdata.classes.OrganizationsClass;
import org.opencivicdata.classes.PersonClass;
import org.opencivicdata.classes.VotesClass;
import org.opencivicdata.data.BaseData;
import org.opencivicdata.data.Bill;
import org.opencivicdata.data.Bills;
import org.opencivicdata.data.Division;
import org.opencivicdata.data.Divisions;
import org.opencivicdata.data.Event;
import org.opencivicdata.data.Events;
import org.opencivicdata.data.Jurisdiction;
import org.opencivicdata.data.Jurisdictions;
import org.opencivicdata.data.Organization;
import org.opencivicdata.data.Organizations;
import org.opencivicdata.data.Person;
import org.opencivicdata.data.Persons;
import org.opencivicdata.data.Vote;
import org.opencivicdata.data.Votes;


/**
 * 
 * This program is a demonstrates most of the API.
 * 
 * <pre>
 * This program is a demonstrates most of the API.
 * It requires a ResourceBundle named OpenStates. This means a file
 * named OpenStates.properties must be found in your class path, such
 * as your resources directory. This OpenStates client reads two 
 * keys from the resource bundle, one of which is mandatory.
 * These are in the form of key=value, one on each line.
 * The keys are:
 * 
 * apikey    (Mandatory) get from OpenStates.org
 * cache     (Optional) such as c:/tmp/OpenStatesCache
 * 
 * For Example:
 * apikey=123easyasabcbabyyouandme
 * cache=c:/tmp/openstates
 * 
 * It makes most of the calls available in one form or another.
 * 
 * </pre>
 *
 */
public class AllThingsBoston {

	public static void main(String... args) throws Exception {
		// create a class to query
		JurisdictionsClass jurisdictionsClass = new JurisdictionsClass();
		
		// if you want to turn caching off, uncomment this line
//		OpenCivicData.setCache(false);
		
		// Jurisdictions ... 

		Jurisdictions jurisdictions = jurisdictionsClass.search();
		System.out.println("Retrieved " + jurisdictions.results.size() + " jurisdictions of " + jurisdictions.meta.total_count);
		System.out.println("jurisdictionId is " + jurisdictions.results.get(0).id + " for " + jurisdictions.results.get(0).name );
		Jurisdiction jurisdiction = jurisdictionsClass.detail(jurisdictions.results.get(0).id);
		System.out.println("Detail for jurisdiction " + jurisdiction.name + " includes " + jurisdiction.legislature_name + " legislature_name");
		
		
		// Divisions in Boston
		DivisionsClass divisionsClass = new DivisionsClass();
		Divisions divisions = divisionsClass.search("42.3581", "-71.0636", null, null, null, null, null);
		System.out.println("Retrieved " + divisions.results.size() + " divisions of " + divisions.meta.total_count + " from " + jurisdiction.name);
		System.out.println("divisionId for " + divisions.results.get(1).id + " is " + divisions.results.get(1).display_name );
		Division division = divisionsClass.detail(divisions.results.get(1).id);
		System.out.println("Detail for division " + division.display_name + " includes " + division.children.size() + " children" );
		
		
		OrganizationsClass organizationsClass = new OrganizationsClass();
		
		Organizations organizations = organizationsClass.search(null, null, null, null, null, division.id, null, null, null, null, null, null, null, null);
		System.out.println("Retrieved " + organizations.results.size() + " organizations of " + organizations.meta.total_count + " from jurisdiction " + division.display_name);

		organizations = organizationsClass.search(null, null, null, jurisdiction.id, null, null, null, null, null, null, null, null, null, null);
		System.out.println("Retrieved " + organizations.results.size() + " organizations of " + organizations.meta.total_count + " from jurisdiction " + jurisdiction.name);
		System.out.println("First organization is " + organizations.results.get(0).name );
		
		Organization organization = organizationsClass.detail(organizations.results.get(0).id);
		System.out.println("Organization detail name is " + organization.name);

		PersonClass personsClass = new PersonClass();
		Persons persons = personsClass.search(null, null, null, null, null, null, null, null, null, null, null, null);
		System.out.println("Retrieved " + persons.results.size() + " results of " + persons.meta.total_count);
		System.out.println("First person is " + persons.results.get(0).name );

		persons = personsClass.search(persons.results.get(0).name, null, null, null, null, null, null, null, null, null, null, null);
		System.out.println("Retrieved " + persons.results.size() + " results of " + persons.meta.total_count);
		System.out.println("First person is " + persons.results.get(0).name );
		
		Person person = personsClass.detail(persons.results.get(0).id);
		System.out.println("Detail for person is that " + person.name + " is member of district " + person.district);
		
		EventsClass eventsClass = new EventsClass();
		Events events = eventsClass.search(null, person.id, null, null, null, null, null, null, null, null);
		System.out.println(person.name + " has " + events.results.size() + " events");
		
		events = eventsClass.search(jurisdiction.id, null, null, null, null, null, null, null, null, null);
		System.out.println(jurisdiction.name + " has " + events.results.size() + " events");
		System.out.println("eventId for " + events.results.get(0).id + " is " + events.results.get(0).name );

		Event event = eventsClass.detail(events.results.get(0).id);
		System.out.println("Detail for event " + event.name + " includes when of " + event.when);
		
		BillsClass billsClass = new BillsClass();
		
		Bills bills = billsClass.search(null, null, null, jurisdiction.id, null, null, null, null, null, null, null, null, null);
		System.out.println("Retrieved " + bills.results.size() + " bills of " + bills.meta.total_count + " from jurisdiction " + jurisdiction.name);

		bills = billsClass.search(null, null, null, null, null, null, null, null, null, null, null, null, null);
		System.out.println("Retrieved " + bills.results.size() + " bills of " + bills.meta.total_count);
		System.out.println("billId is " + bills.results.get(0).id );
		
		Bill bill = billsClass.detail(bills.results.get(0).id);
		System.out.println("Bill detail name is " + bill.name );

		VotesClass votesClass = new VotesClass();
		
		Votes votes = votesClass.search(null, null, null, null, null, null, bill.id, null, null, null, null, null, null);
		System.out.println("Retrieved " + votes.results.size() + " votes of " + votes.meta.total_count);
		System.out.println("voteId is " + votes.results.get(0).id );
		
		Vote vote = votesClass.detail(votes.results.get(0).id);
		System.out.println("Vote detail date is " + vote.date);
	}
	
	private static void checkExtras(Object o) {
		if ( o instanceof ArrayList ) {
			@SuppressWarnings("unchecked")
			ArrayList<BaseData> list = (ArrayList<BaseData>)o;
			for ( BaseData base: list ) {
				if ( base.pluses != null ) System.out.println(base.pluses);
				if ( base.additionalFields != null ) System.out.println(base.additionalFields);
			}
		} else if ( o instanceof BaseData ) {
			BaseData base = (BaseData)o;
			if ( base.pluses != null ) System.out.println(base.pluses);
			if ( base.additionalFields != null ) System.out.println(base.additionalFields);
		}
	}

}
