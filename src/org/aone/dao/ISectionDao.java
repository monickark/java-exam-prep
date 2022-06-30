package org.aone.dao;

import java.util.List;
import java.util.Map;

import org.aone.common.exception.DuplicateEntryException;
import org.aone.common.exception.NoDataFoundException;
import org.aone.common.exception.UpdateFailedException;


public interface ISectionDao {

	Map<String, String> getTransportName() throws NoDataFoundException, NoDataFoundException;

	void insertSection(Section testBean) throws UpdateFailedException,
			DuplicateEntryException;

	String getNextSectionId();



	String getDbTs();

	void updateTestDao(Section section) throws UpdateFailedException;

	void deleteSectorData(Section sector);

	
}
