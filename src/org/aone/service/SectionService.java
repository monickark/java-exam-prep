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
import org.aone.dao.Section;
import org.aone.dao.SectionList;
import org.aone.dao.TestType;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;





@Service
public class SectionService implements ISectionService {

	// Logging
	Logger logger = Logger.getLogger(SectionService.class);
	@Autowired
	private ISectionDao sectionSignUpDao;
	@Autowired
	private ISectionListDao sectionListDao;
	@Autowired
	private CommonBusiness commonBusiness;
	
	public Map<String, String> getName()
			throws NoDataFoundException {
		// TODO Auto-generated method stub
		Map<String, String> transportMap = sectionSignUpDao.getTransportName();
		return transportMap;

	}
	

    @Override
	public void insertSection(SectionVO sectionVO) throws UpdateFailedException, DuplicateEntryException {
    	// TODO Auto-generated method stub
     //get Sectorid
    	String name=getNextSectionId();
      	
        //split a string and number
    	String splStr = name.substring(3, 6);
    	
    	//convert string into int
        int i = Integer.parseInt(splStr);
        i=i+1;
        
        
        String inttost = Integer.toString(i);
        String sectorId=null;
	      if (0 < i && i <= 9) {
	    	  	 sectorId = "SEC00".concat(inttost);
	       }
	      else if(10 <= i && i <= 99){
	    	      sectorId = "SEC0".concat(inttost);

	      }
	      else  {
	    	  	sectorId = "SEC".concat(inttost);
	      }
    	
	     sectionVO.setSectionId(sectorId);
    	 
	     Section section=new  Section();
    	 commonBusiness.changeObject(section, sectionVO);
	     
    	 section.setDbTs("1");
	     section.setDelFlg("N");
	     
	     

	     DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		 Calendar cal = Calendar.getInstance();
		 
	     
	     String creTime=dateFormat.format(cal.getTime());
	     section.setrCreTime(creTime);

		 String modTime=dateFormat.format(cal.getTime());
		 section.setrModTime(modTime);

		 String dateAdded=dateFormat.format(cal.getTime());
		 section.setDateAdded(dateAdded);

	     sectionSignUpDao.insertSection(section);
	
	}
    
    public String getNextSectionId() {
      return sectionSignUpDao.getNextSectionId();

	}
    


	public void updateSection(SectionVO sectionVO)throws UpdateFailedException {
		// TODO Auto-generated method stub
		Section section = new Section();

		commonBusiness.changeObject(section, sectionVO);
		   
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Calendar cal = Calendar.getInstance();
		String modTime=dateFormat.format(cal.getTime());
	    section.setrModTime(modTime);
	   String db_ts=getDbTs();
	   section.setDbTs(db_ts);
	   sectionSignUpDao.updateTestDao(section);
	
	}
	
	public String getDbTs() {
		return sectionSignUpDao.getDbTs();

	}
	
	public List<SectionListVO> selectSectionList(SectionListVO sectionListVOs) throws NoDataFoundException
	{

       List<SectionListVO> listVOs = new ArrayList<SectionListVO>();
       SectionList sectionList=new SectionList();
       commonBusiness.changeObject(sectionList,sectionListVOs );

        List<SectionList> sectionLists = sectionListDao.getTestListfromDb(sectionList);

        for (SectionList sectionList2 : sectionLists) {
        	SectionListVO sectionListVO = new SectionListVO();
	      commonBusiness.changeObject(sectionListVO, sectionList2);
	      listVOs.add(sectionListVO);
         }

     return listVOs;
    }
	
	

	@Override
	public void deleteSection(SectionVO sectionVO) {
		// TODO Auto-generated method stub
		Section section = new Section();

		commonBusiness.changeObject(section, sectionVO);
		sectionSignUpDao.deleteSectorData(section);
	
	}
	

	public Map<String, SectionListVO> listToMap(List<SectionListVO> sectionListVOs) {
    
		 Map<String, SectionListVO> map = new HashMap<String, SectionListVO>();
	     for (int i = 0; i < sectionListVOs.size(); i++) {
	    	 SectionListVO sectorVO = sectionListVOs.get(i);
			 String testDataValues=String.valueOf(sectorVO.getSectionId());
			 map.put(testDataValues, sectorVO);
		 }	
		System.out.println("map"+map);
		return map;
	}


	


}
