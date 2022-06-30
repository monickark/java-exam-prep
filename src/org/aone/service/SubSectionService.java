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
import org.aone.controller.SubSectionListVO;
import org.aone.controller.SubSectionVO;
import org.aone.controller.TestTypeVO;
import org.aone.dao.ISubSectionDao;
import org.aone.dao.ISubSectionListDao;
import org.aone.dao.SubSection;
import org.aone.dao.SubSectionList;
import org.aone.dao.TestType;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;





@Service
public class SubSectionService implements ISubSectionService {

	// Logging
	Logger logger = Logger.getLogger(SubSectionService.class);
	@Autowired
	private ISubSectionDao subSectionSignUpDao;
	@Autowired
	private ISubSectionListDao subSectionListDao;
	
	@Autowired
	private CommonBusiness commonBusiness;
	
	
	public List<SubSectionListVO> selectSubSectionList(SubSectionListVO subSectionListVO) throws NoDataFoundException
	{

       List<SubSectionListVO> subSectionListVOs = new ArrayList<SubSectionListVO>();
       SubSectionList subSectionList=new SubSectionList();
       commonBusiness.changeObject(subSectionList,subSectionListVO );

        List<SubSectionList> subSectionLists = subSectionListDao.selectSubSectionList(subSectionList);

        for (SubSectionList sectionList : subSectionLists) {
        	SubSectionListVO subSectionListVO2 = new SubSectionListVO();
        	commonBusiness.changeObject(subSectionListVO2, sectionList);
	      subSectionListVOs.add(subSectionListVO2);
         }

     return subSectionListVOs;
    }
	
	
	
	
	public Map<String, SubSectionListVO> listToMap(List<SubSectionListVO> subSectionVOs) {
    
		 Map<String, SubSectionListVO> map = new HashMap<String, SubSectionListVO>();
	     for (int i = 0; i < subSectionVOs.size(); i++) {
	    	 SubSectionListVO subSectionVO = subSectionVOs.get(i);
			 String testDataValues=String.valueOf(subSectionVO.getSubSectionId());
			 map.put(testDataValues, subSectionVO);
		 }	
		
		return map;
	}
	
	
	@Override
	public void deleteSubSection(SubSectionVO subSectionVO) {
		// TODO Auto-generated method stub
		SubSection subSection = new SubSection();

		commonBusiness.changeObject(subSection, subSectionVO);
		subSectionSignUpDao.deleteSubSection(subSection);
	
	}




	
	public void editSubSection(SubSectionVO subSectionVO)throws UpdateFailedException {
		// TODO Auto-generated method stub
		SubSection subSection = new SubSection();

		commonBusiness.changeObject(subSection, subSectionVO);
	    
		String db_ts=getDbTs();
	    subSection.setDbTs(db_ts);
	 
	    DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Calendar cal = Calendar.getInstance();
		String modTime=dateFormat.format(cal.getTime());
		subSection.setrModTime(modTime);
	  
	   subSectionSignUpDao.editSubSection(subSection);
	
	}
	
	public String getDbTs() {
		return subSectionSignUpDao.getDbTs();

	}
	
	
	public Map<String, String> getSectionName()
			throws NoDataFoundException {
		// TODO Auto-generated method stub
		Map<String, String> transportMap = subSectionSignUpDao.mapSectionId();
		return transportMap;

	}
	

    public void insertSubSection(SubSectionVO  testTypeVO) throws UpdateFailedException, DuplicateEntryException {
    	// TODO Auto-generated method stub
    
    	//get Sectorid
    	String name=getNextSubSection();
      	
        //split a string and number
    	String splStr = name.substring(3, 6);
    	
    	//convert string into int
        int i = Integer.parseInt(splStr);
        i=i+1;
        
        
        String inttost = Integer.toString(i);
        String sectorId=null;
	      if (0 < i && i <= 9) {
	    	  	 sectorId = "SUB00".concat(inttost);
	       }
	      else if(10 <= i && i <= 99){
	    	      sectorId = "SUB0".concat(inttost);

	      }
	      else  {
	    	  	sectorId = "SUB".concat(inttost);
	      }
    	
	     testTypeVO.setSubSectionId(sectorId);
    	 
	     SubSection testTpe=new  SubSection();
    	 commonBusiness.changeObject(testTpe, testTypeVO);
	     
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
	     
	     subSectionSignUpDao.insertSubSection(testTpe);
	
	}
    
    public String getNextSubSection() {
      return subSectionSignUpDao.getNextSubSectionId();

	}
    
    
   

}
