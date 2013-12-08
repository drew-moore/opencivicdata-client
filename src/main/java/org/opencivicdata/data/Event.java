package org.opencivicdata.data;

import java.util.Date;
import java.util.List;

/**
 * Holds Event details. Implements Comparable.
 * 
 * <pre>
 * </pre>
 * 
 */
public class Event extends CommonData {

	public List<Link> links;
	public String updated_at;
	public String session;
	public String id;
	public List<Document> documents;
	public String end;
	public List<Media> media;
	public String when;
	public List<String> participants;
	public Location location;
	public String type;
	public String status;
	public String description;
	public String jurisdiction_id;
	public String name;
	public String created_at;
	public Boolean all_day;
	public Extras extras;
	public List<Agenda> agenda;
	public Coordinates coordinates;

	public static class Document extends BaseData {
		public String url;
		public String mimetype;
		public String name;
	}

	public static class Media {
		public Date date;
		public String type;
		public String name;
		public List<Link> links;

		public static class Link {
			public String mimetype;
			public String url;
		}
	}

	public static class Extras extends BaseData {

	}

	public static class Link extends BaseData {
		public String note;
		public String url;
		public List<Participant> participants;

		public static class Participant extends BaseData {
			public String note;
			public String chamber;
			public String type;
			public String name;
			public String id;
		}
	}

	public static class Location extends BaseData {

		public String note;
		public String name;
		public String coordinates;
	}

	public static class Agenda extends BaseData {

		public List<Entity> related_entities;

		public static class Entity extends BaseData {
			public String note;
			public String type;
			public String id;
			public String name;
		}

		public Media media;
		public String offset;
		public List<Note> notes;

		public static class Note extends BaseData {
			public String description;
		}

		public List<String> subjects;
		public String order;
		public String description;
	}
	public static class Coordinates extends BaseData { 
		double latitude; 
		double longitude; 
	}

}
