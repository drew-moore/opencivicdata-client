package org.opencivicdata.data;

import java.util.List;

public class Vote extends CommonData implements Comparable<Vote> {
	public Object organization_id;
	public Bill bill;
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

	public static class Bill {
		public Object chamber;
		public String id;
		public String name;
	}

	public static class Person {
		public String name;
		public String id;
	}

	public static class Roll_call {
		public Person person;
		public String vote_type;
	}

	public static class Vote_count {
		public Integer count;
		public String vote_type;
	}

	public int compareTo(Vote o) {
		return id.compareTo(o.id);
	}
}
