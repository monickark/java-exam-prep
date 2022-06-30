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
import org.aone.controller.TestTypeListVO;
import org.aone.controller.TestTypeVO;
import org.aone.dao.ITestTypeDao;
import org.aone.dao.ITestTypeListDao;
import org.aone.dao.TestType;
import org.aone.dao.TestTypeList;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;





@Service
public class TestTypeService implements ITestTypeService {

	// Logging
	Logger logger = Logger.getLogger(TestTypeService.class);
    @Autowired
    private ITestTypeDao signUpTestDao;
    @Autowired
	private CommonBusiness commonBussiness;
    @Autowired
     private ITestTypeListDao viewTestDao;
    @Override
	public void insertTestType(TestTypeVO testTypeVO) throws UpdateFailedException, DuplicateEntryException {
		// TODO Auto-generated method stub
    	TestType testTpe=new  TestType();
		commonBussiness.changeObject(testTpe, testTypeVO);
	     testTpe.setDbTs("1");
	     testTpe.setDelFlg("N");
	     
	     DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		 Calendar cal = Calendar.getInstance();
		 
		 String creTime=dateFormat.format(cal.getTime());
	     testTpe.setrCreTime(creTime);

		 String modTime=dateFormat.format(cal.getTime());
	     testTpe.setrModTime(modTime);

		 String dateAdded=dateFormat.format(cal.getTime());
	     testTpe.setDateAdded(dateAdded);

		signUpTestDao.insertTestType(testTpe);
	
	}

	// Get Next Admission number
	@Override
	public String getNextTestTypeId() {
		return signUpTestDao.getNextTestTypeId();

	}
	
	

	@Override
	public void editTestType(TestTypeVO testTypeVO)throws UpdateFailedException, NoDataFoundException {
		// TODO Auto-generated method stub
		TestType testType = new TestType();

		commonBussiness.changeObject(testType, testTypeVO);
         
		
	   DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
	   Calendar cal = Calendar.getInstance();
		
       String modTime=dateFormat.format(cal.getTime());

	   String db_ts=getDbTs();
	   testType.setDbTs(db_ts);
	   testType.setrModTime(modTime);

	   signUpTestDao.editTestTpe(testType);
	   
	   testType=signUpTestDao.selectTestType(testType);
	   commonBussiness.changeObject(testTypeVO, testType);
    }
	

	public String getDbTs() {
		return signUpTestDao.getDbTs();

	}
	

	public void deleteTestType(TestTypeVO testTypeVO) {
		// TODO Auto-generated method stub
		TestType testType = new TestType();

		commonBussiness.changeObject(testType, testTypeVO);

		signUpTestDao.deleteTestType(testType);
	
	}
	
	
	
	public List<TestTypeListVO> selectTestType(TestTypeListVO testTypeVO) throws NoDataFoundException
	{

       List<TestTypeListVO> testTypeVOs = new ArrayList<TestTypeListVO>();
       TestTypeList testType=new TestTypeList();
       commonBussiness.changeObject(testType,testTypeVO );

        List<TestTypeList> testTypes = viewTestDao.selectTestTypeList(testType);
        for (TestTypeList testType2 : testTypes) {
        	TestTypeListVO testTypeVO2 = new TestTypeListVO();
	      commonBussiness.changeObject(testTypeVO2, testType2);
	      testTypeVOs.add(testTypeVO2);
         }

     return testTypeVOs;
    }
	
	
	
	
	public Map<String, TestTypeListVO> testTypeListToMap(List<TestTypeListVO> testTypeVOs) {
    
		 Map<String, TestTypeListVO> map = new HashMap<String, TestTypeListVO>();
	     for (int i = 0; i < testTypeVOs.size(); i++) {
	    	 TestTypeListVO testTypeVO = testTypeVOs.get(i);
			 String testDataValues=String.valueOf(testTypeVO.getTestTypeId());
			 map.put(testDataValues, testTypeVO);
		 }	
		
		return map;
	}


}

