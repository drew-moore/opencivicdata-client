package org.opencivicdata.classes;

import org.opencivicdata.api.ArgMap;
import org.opencivicdata.api.MethodMap;
import org.opencivicdata.api.OpenCivicDataAPI;
import org.opencivicdata.api.OpenCivicDataException;
import org.opencivicdata.data.Event;
import org.opencivicdata.data.Events;

/**
 * Accesses the <a href="http://sunlightlabs.github.io/openstates-api/events.html">Events</a> methods.
 * 
 * <pre>
 * Events are not available in all states, to ensure that events are available check the feature_flags list in a states' metadata.
 * 
 * There are two methods available for event data:
 * Method        Description
 * Event Search  Search events by state and type.
 * Event Detail  Get full detail for event.
 * </pre>
 * 
 */
public class EventsClass extends ClassesBase {

	/**
	 * Constructor for testing purposes.
	 * 
	 * @param api
	 */
	public EventsClass(OpenCivicDataAPI api) {
		super(api);
	}

	/**
	 * Default constructor
	 */
	public EventsClass()  throws OpenCivicDataException {
		super();
	}

	/**
	 * Event Search
	 * This method allows searching by state:
	 * 
	 * @param state
	 * @return {@link Events}
	 */
	public Events search(
			String jurisdiction_id, 
			String participants_id, 
			String agenda_related_entities_id, 
			String when, 
			String updated_at, 
			String created_at, 
			String fields, 
			String sort, 
			String page, 
			String per_page
			
	) throws OpenCivicDataException {
		return api.query(
			new MethodMap("events"), 
			new ArgMap(
				"jurisdiction_id", jurisdiction_id, 
				"participants.id", participants_id, 
				"agenda.related_entities.id", agenda_related_entities_id, 
				"when", when,  
				"updated_at", updated_at, 
				"created_at", created_at, 
				"fields", fields, 
				"sort", sort, 
				"page", page, 
				"per_page", per_page
			), 
			Events.class
		);
	}
	
	/**
	 * 
	 * @param id
	 * @return {@link Event}
	 */
	public Event detail(String eventId) throws OpenCivicDataException {
		return api.query(new MethodMap(eventId), null, Event.class);
	}
}
