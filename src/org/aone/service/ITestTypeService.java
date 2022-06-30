package org.aone.service;

import java.util.List;
import java.util.Map;

import org.aone.common.exception.DuplicateEntryException;
import org.aone.common.exception.NoDataFoundException;
import org.aone.common.exception.UpdateFailedException;
import org.aone.controller.TestTypeListVO;
import org.aone.controller.TestTypeVO;



public interface ITestTypeService {

	void insertTestType(TestTypeVO TestTpe) throws UpdateFailedException,
			DuplicateEntryException;

	String getNextTestTypeId();

	void deleteTestType(TestTypeVO testTypeVO)
			throws  NoDataFoundException;

	void editTestType(TestTypeVO testTypeVO)
			throws UpdateFailedException, NoDataFoundException;
	public List<TestTypeListVO> selectTestType(TestTypeListVO testTypeVO) throws NoDataFoundException;



	
	public Map<String, TestTypeListVO> testTypeListToMap(List<TestTypeListVO> testTypeVOs);

}
