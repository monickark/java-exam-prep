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
import org.aone.controller.SectorListVO;
import org.aone.controller.SectorVO;
import org.aone.controller.TestTypeVO;
import org.aone.dao.ISectorDao;
import org.aone.dao.ISectorListDao;
import org.aone.dao.Sector;
import org.aone.dao.SectorList;
import org.aone.dao.TestType;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;





@Service
public class SectorService implements ISectorService {

	// Logging
	Logger logger = Logger.getLogger(SectorService.class);
	@Autowired
	private ISectorDao sectorDao;
	@Autowired
	private ISectorListDao sectorListDao;
	@Autowired
	private CommonBusiness commonBusiness;
	
	
	public Map<String, String> getName()
			throws NoDataFoundException {
		// TODO Auto-generated method stub
		Map<String, String> map = sectorDao.getTestType();
		return map;

	}
	

    @Override
	public void insertSector(SectorVO sectorVO) throws UpdateFailedException, DuplicateEntryException {
    	// TODO Auto-generated method stub
    
    	//get Sectorid
    	String name=getNextSectorId();
      	
        //split a string and number
    	String splStr = name.substring(2, 5);
    	
    	//convert string into int
        int i = Integer.parseInt(splStr);
        i=i+1;
        
        
        String inttost = Integer.toString(i);
        String sectorId=null;
	      if (0 < i && i <= 9) {
	    	  	 sectorId = "ST00".concat(inttost);
	       }
	      else if(10 <= i && i <= 99){
	    	      sectorId = "ST0".concat(inttost);

	      }
	      else  {
	    	  	sectorId = "ST".concat(inttost);
	      }
    	
	     sectorVO.setSectorTypeId(sectorId);
    	 
	     Sector sector=new  Sector();
    	 commonBusiness.changeObject(sector, sectorVO);
	     
    	 sector.setDbTs("1");
	     sector.setDelFlg("N");

	     DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		 Calendar cal = Calendar.getInstance();
		 
	     
	     String creTime=dateFormat.format(cal.getTime());
	     sector.setrCreTime(creTime);

		 String modTime=dateFormat.format(cal.getTime());
	     sector.setrModTime(modTime);

		 String dateAdded=dateFormat.format(cal.getTime());
	     sector.setDateAdded(dateAdded);
	     sectorDao.insertSector(sector);
	
	}
    
    public String getNextSectorId() {
      return sectorDao.getNextSectorId();

	}
    
    
    
    
    
    public void editSector(SectorVO sectorVO)throws UpdateFailedException {
		// TODO Auto-generated method stub
		Sector sector = new Sector();
        commonBusiness.changeObject(sector, sectorVO);
         
	   DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
	   Calendar cal = Calendar.getInstance();
	   String modTime=dateFormat.format(cal.getTime());
	   sector.setrModTime(modTime);

	   String db_ts=getDbTs();
	   sector.setDbTs(db_ts);
	   sectorDao.updateSector(sector);
	
	}
	
	public String getDbTs() {
		return sectorDao.getDbTs();

	}
    
    @Override
	public void deleteSector(SectorVO sectorVO) {
		// TODO Auto-generated method stub
		Sector sector = new Sector();

		commonBusiness.changeObject(sector, sectorVO);

		sectorDao.deleteSector(sector);
	
	}
    
    
   
	
	
	
	
	public Map<String, SectorListVO> listToMap(List<SectorListVO> sectorVOs) {
    
		 Map<String, SectorListVO> map = new HashMap<String, SectorListVO>();
	     for (int i = 0; i < sectorVOs.size(); i++) {
	    	 SectorListVO sectorVO = sectorVOs.get(i);
			 String testDataValues=String.valueOf(sectorVO.getSectorTypeId());
			 map.put(testDataValues, sectorVO);
		 }	
		
		return map;
	}

	
	
	 
    public List<SectorListVO> selectSectorList(SectorListVO sectorListVO) throws NoDataFoundException
	{

       List<SectorListVO> sectorListVOs = new ArrayList<SectorListVO>();
       SectorList testTpe=new SectorList();
       commonBusiness.changeObject(testTpe,sectorListVO );

        List<SectorList> sectorLists = sectorListDao.selectSectorList(testTpe);

        for (SectorList sectorList : sectorLists) {
        	SectorListVO sectorListVO2 = new SectorListVO();
        	commonBusiness.changeObject(sectorListVO2, sectorList);
	      sectorListVOs.add(sectorListVO2);
         }

     return sectorListVOs;
    }


}
