package org.opencivicdata.api;

/**
 * Interface for the query method. Used by testing.  
 */
public interface OpenCivicDataAPI {
	public <T> T query(MethodMap methodMap, ArgMap argMap, Class<T> responseType) throws OpenCivicDataException;
}
