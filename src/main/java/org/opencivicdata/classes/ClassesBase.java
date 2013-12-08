package org.opencivicdata.classes;

import java.util.ResourceBundle;

import org.opencivicdata.api.OpenCivicData;
import org.opencivicdata.api.OpenCivicDataAPI;
import org.opencivicdata.api.OpenCivicDataException;

/**
 * Base class for all other classes.
 * 
 * <pre>
 * Base class for all other classes. 
 * 
 * The user has no reason to use this class directly. It
 * is used as the base class for all of the other 
 * 'Classes' classes.
 * </pre>
 */
public class ClassesBase {
	
	public static final String OpenCivicDataResource = "opencivicdata";
	protected static OpenCivicDataAPI api = null;
	
	/**
	 * This class is supports the other interface classes. 
	 * Default constructor
	 */
	public ClassesBase() throws OpenCivicDataException {
		if ( ClassesBase.api == null ) ClassesBase.api = new OpenCivicData(ResourceBundle.getBundle(OpenCivicDataResource));
	}
	
	/**
	 * Constructor for testing purposes
	 * 
	 * @param testApi
	 */
	public ClassesBase(OpenCivicDataAPI testApi) {
		if ( ClassesBase.api == null ) ClassesBase.api = testApi;
	}
}
