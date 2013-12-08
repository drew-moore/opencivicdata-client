package org.opencivicdata.data;

import java.util.List;

public class Bill extends CommonData implements Comparable<Bill> {
	public List<String> other_titles;
	public List<String> documents;
	public String name;
	public String title;
	public String openstates_id;
	public List<String> other_names;
	public List<Sponsor> sponsors;
	public List<Action> actions;
	public String id;
	public String chamber;
	public String session;
	public String jurisdiction_id;
	public List<String> related_bills;
	public List<Vote> votes;
	public List<Version> versions;
	public List<String> type;
	public List<String> summaries;
	public List<String> subject;
	
	public static class Action extends BaseData {
		public String date;
		public List<String> type;
		public String description;
		public String actor;
		public List<String> related_entities;
	}

	public static class Link extends BaseData {
		public String url;
		public String mimetype;
	}

	public static class Person extends BaseData {
		public String name;
		public String id;
	}

	public static class Roll_call extends BaseData {
		public Person person;
		public String vote_type;
	}

	public static class Sponsor extends BaseData {
		public String name;
		public String sponsorship_type;
		public Boolean primary;
		public String chamber;
		public String id;
	}

	public static class Version extends BaseData {

		public String date;
		public String type;
		public String name;
		public List<Link> links;
		public String offset;
	}

	public static class Vote extends BaseData {
		public String organization_id;
		public VoteBill bill;
		public List<Bill.Source> sources;
		public String openstates_id;
		public List<Roll_call> roll_call;
		public String jurisdiction_id;
		public String id;
		public List<Vote_count> vote_counts;
		public String chamber;
		public String session;
		public Boolean passed;
		public String date;
		public String organization;
		public List<String> type;
		public String motion;

		public static class VoteBill extends BaseData {
			public String chamber;
			public String id;
			public String name;
		}
	}

	public static class Vote_count extends BaseData {
		public Integer count;
		public String vote_type;
	}

	public int compareTo(Bill o) {
		return id.compareTo(o.id);
	}
}
