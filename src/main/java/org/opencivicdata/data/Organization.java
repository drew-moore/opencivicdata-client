package org.opencivicdata.data;

import java.util.List;

public class Organization extends CommonData implements Comparable<Organization> {
	public String dissolution_date;
	public List<Membership> memberships;
	public String founding_date;
	public List<Contact_detail> contact_details;
	public String classification;
	public List<Source> sources;
	public List<String> other_names;
	public String created_at;
	public List<String> identifiers;
	public List<String> posts;
	public String updated_at;
	public String jurisdiction_id;
	public List<String> links;
	public String parent_id;
	public Extras extras;
	public String id;
	public String name;

	public static class Contact_detail extends BaseData {

		public String note;
		public String type;
		public String value;
	}

	public static class Extras extends BaseData {
	}

	public static class Membership extends BaseData {

		public String person;
		public List<String> contact_details;
		public String end_date;
		public String post_id;
		public String created_at;
		public String updated_at;
		public String jurisdiction_id;
		public String organization_id;
		public List<Organization.Source> sources;
		public Unmatched_legislator unmatched_legislator;
		public Extras extras;
		public String role;
		public String person_id;
		public String start_date;
	}

	public static class Unmatched_legislator extends BaseData {
		public String name;
	}

	@Override
	public int compareTo(Organization o) {
		return id.compareTo(o.id);
	}

}