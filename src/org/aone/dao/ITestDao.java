package org.aone.dao;
import java.util.Map;

import org.aone.common.exception.NoDataFoundException;


public interface ITestDao {

	Map<String, String> getSection(String testType, String sectorName) throws NoDataFoundException;
	Map<String, String> getSubSectionName() throws NoDataFoundException;
	Map<String, String> getSectorName(String testType)
			throws NoDataFoundException;
	Map<String, String> getTestTypeName() throws NoDataFoundException;

	

}
