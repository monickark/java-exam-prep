package org.aone.service;

import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.aone.common.bussiness.CommonBusiness;
import org.aone.common.exception.DuplicateEntryException;
import org.aone.common.exception.NoDataFoundException;
import org.aone.common.exception.UpdateFailedException;
import org.aone.controller.SectionListVO;
import org.aone.controller.SectionVO;
import org.aone.controller.SectorListVO;
import org.aone.controller.TestTypeVO;
import org.aone.dao.ISectionDao;
import org.aone.dao.ISectionListDao;
import org.aone.dao.ITestDao;
import org.aone.dao.Section;
import org.aone.dao.SectionList;
import org.aone.dao.TestType;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;





@Service
public class TestService implements ITestService {

	// Logging
	Logger logger = Logger.getLogger(TestService.class);
	@Autowired
	private ITestDao sectionSignUpDao;
	@Autowired
	private ISectionListDao sectionListDao;
	@Autowired
	private CommonBusiness commonBusiness;
	
	public Map<String, String> getSectionName(String testType, String sectorName)
			throws NoDataFoundException {
		// TODO Auto-generated method stub
		Map<String, String> sectionMap = sectionSignUpDao.getSection(testType,sectorName);
		
		return sectionMap;

	}
	public Map<String, String> getSectorName(String testType)
			throws NoDataFoundException {
		// TODO Auto-generated method stub
		Map<String, String> sectorMap = sectionSignUpDao.getSectorName(testType);
		
		return sectorMap;

	}
	public Map<String, String> getTestTypeName()
			throws NoDataFoundException {
		// TODO Auto-generated method stub
		Map<String, String> sectorMap = sectionSignUpDao.getTestTypeName();
		
		return sectorMap;

	}
	
	public Map<String, String> getSubSectionName()
			throws NoDataFoundException {
		// TODO Auto-generated method stub
		Map<String, String> sectorMap = sectionSignUpDao.getSubSectionName();
		
		return sectorMap;

	}

    

	


}
