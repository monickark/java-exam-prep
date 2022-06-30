package org.aone.dao;

import java.util.List;
import java.util.Map;

import org.aone.common.exception.DuplicateEntryException;
import org.aone.common.exception.NoDataFoundException;
import org.aone.common.exception.UpdateFailedException;


public interface ISubSectionDao {

	Map<String, String> mapSectionId() throws NoDataFoundException;

	void insertSubSection(SubSection section) throws UpdateFailedException,
			DuplicateEntryException;

	String getNextSubSectionId();

	String getDbTs();

	void editSubSection(SubSection subSection) throws UpdateFailedException;

	public void deleteSubSection(SubSection subSection) ;

	
}
