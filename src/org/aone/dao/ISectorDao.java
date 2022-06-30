package org.aone.dao;

import java.util.List;
import java.util.Map;

import org.aone.common.exception.DuplicateEntryException;
import org.aone.common.exception.NoDataFoundException;
import org.aone.common.exception.UpdateFailedException;


public interface ISectorDao {

	Map<String, String> getTestType() throws NoDataFoundException, NoDataFoundException;

	void insertSector(Sector testBean) throws UpdateFailedException,
			DuplicateEntryException;

	String getNextSectorId();


	void updateSector(Sector sector) throws UpdateFailedException;

	String getDbTs();

	void deleteSector(Sector sector);

	
}
