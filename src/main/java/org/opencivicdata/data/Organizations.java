package org.opencivicdata.data;

import java.util.List;

/**
 * Holds a list of {@link Division} details.
 *
 */
public class Organizations {
	public Meta meta;
	public List<Organization> results;

	public static class Organization extends CommonData {
		public List<Link> links;
		public String classification;
		public String created_at;
		public List<Identifier> identifiers;
		public List<OtherName> other_names;
		public String updated_at;
		public String jurisdiction_id;
		public Parent parent_id;
		public Extras extras;
		public String id;
		public String name;
		
		public static class Link extends BaseData {
		}
		public static class Identifier extends BaseData {
		}
		public static class OtherName extends BaseData {
		}
		public static class Parent extends BaseData {
		}
		
		public static class Extras extends BaseData {
		}
	}	
}
