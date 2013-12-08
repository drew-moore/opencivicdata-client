package org.opencivicdata.data;

import java.util.Date;
import java.util.List;

public class CommonData extends BaseData {
	public String updated_at;
	public String created_at;
	public List<Source> sources;
	public static class Source {
		public String url;
		public String note;
	}

}
