package org.aone.dao;

import java.util.List;

import org.aone.common.exception.DuplicateEntryException;
import org.aone.common.exception.NoDataFoundException;
import org.aone.common.exception.UpdateFailedException;


public interface ITestTypeListDao {

	public List<TestTypeList> selectTestTypeList(final TestTypeList testType)
			throws NoDataFoundException ;

}
