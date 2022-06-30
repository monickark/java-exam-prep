package org.aone.service;

import java.util.List;
import java.util.Map;

import org.aone.common.exception.DuplicateEntryException;
import org.aone.common.exception.NoDataFoundException;
import org.aone.common.exception.UpdateFailedException;
import org.aone.controller.SectionListVO;
import org.aone.controller.SectionVO;
import org.aone.controller.SectorListVO;
import org.aone.controller.TestTypeVO;




public interface ITestService {
	public Map<String, String> getSectionName(String testType, String sectorName)
			throws NoDataFoundException;
	public Map<String, String> getSectorName(String testType)
			throws NoDataFoundException;
	public Map<String, String> getTestTypeName()
			throws NoDataFoundException;
	public Map<String, String> getSubSectionName()
			throws NoDataFoundException ;


}
