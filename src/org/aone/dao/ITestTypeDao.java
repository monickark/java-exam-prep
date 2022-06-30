package org.aone.dao;

import java.util.List;

import org.aone.common.exception.DuplicateEntryException;
import org.aone.common.exception.NoDataFoundException;
import org.aone.common.exception.UpdateFailedException;


public interface ITestTypeDao {

	public void insertTestType(TestType testTpe) throws UpdateFailedException, DuplicateEntryException;


	String getNextTestTypeId();
	
	
	void deleteTestType(TestType testType);
	
	void editTestTpe(TestType testType)
			throws UpdateFailedException;

	String getDbTs();

	public TestType selectTestType(TestType testTpe)
			throws NoDataFoundException;

}
