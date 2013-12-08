package org.opencivicdata.data;

import java.util.List;

public class Person extends CommonData {
	public String created_at;
	public String district;
	public Object gender;
	public Object image;
	public List<Identifier> identifiers;
	public List<Object> other_names;
	public String updated_at;
	public Object summary;
	public String chamber;
	public String id;
	public Object biography;
	public String name;

	public static class Identifier extends BaseData {
		public String scheme;
		public String identifier;
	}
}
