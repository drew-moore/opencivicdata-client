package org.opencivicdata.data;

import java.util.List;

/**
 * Holds District details. Implements Comparable.
 * 
 * <pre>
 * 
 * </pre>
 * 
 */
public class Division extends CommonData implements Comparable<Division> {
	public String country;
	public String display_name;
	public String id;
	public List<Geometry> geometries;
	public List<Child> children;

	public static class Boundary extends BaseData {
		public String name;
		public Related related;
		public String boundary_set_name;
		public Centroid centroid;
		public List<Double> extent;
		public String external_id;
		public Metadata metadata;

		public static class Centroid extends BaseData {
			public String type;
			public List<Double> coordinates;
		}

	}

	public static class Child extends BaseData {
		public String display_name;
		public String id;
	}

	public static class Geometry extends BaseData {
		public String start;
		public Boundary boundary;
		public String end;
	}

	public static class Metadata extends BaseData {
		public String NAME10;
		public String METDIVFP10;
		public String CLASSFP10;
		public String COUNTYNS10;
		public Integer AWATER10;
		public Integer ALAND10;
		public String STATEFP10;
		public String LSAD10;
		public String FUNCSTAT10;
		public String NAMELSAD10;
		public String CSAFP10;
		public String COUNTYFP10;
		public String CBSAFP10;
		public String INTPTLAT10;
		public String MTFCC10;
		public String GEOID10;
		public String INTPTLON10;
	}

	public static class Related extends BaseData {
		public String boundary_set_url;
		public String simple_shape_url;
		public String boundaries_url;
		public String shape_url;
		public String centroid_url;
	}

	@Override
	public int compareTo(Division o) {
		return id.compareTo(o.id);
	}
}
