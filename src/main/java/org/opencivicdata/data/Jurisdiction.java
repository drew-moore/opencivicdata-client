package org.opencivicdata.data;

import java.util.List;

/**
 * Holds Jurisdiction specific details. Implements Comparable.
 * 
 * <pre>
 * </pre>
 */
public class Jurisdiction extends CommonData  implements Comparable<Division> {
	public String id;
	public String name;
	public String legislature_name;
	public String legislature_url;
	public List<FeatureFlag> feature_flags;
	public String latest_update;
	public List<String> provides;
	public List<Party> parties;
	
	public static class FeatureFlag extends BaseData {
	}

	public static class Party extends BaseData {
	}

	@Override
	public int compareTo(Division o) {
		return id.compareTo(o.id);
	}

}
