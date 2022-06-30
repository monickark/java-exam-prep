package org.aone.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.aone.common.exception.NoDataFoundException;
import org.aone.service.ISectorService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;



@Controller
public class ManageSectorController{
	
	final  Logger logger = Logger.getLogger(ManageSectorController.class.getName());
	@Autowired
    private ISectorService sectorService;
    @RequestMapping(value = "/viewSector", method = RequestMethod.GET)
     public String manageSectorGet(@ModelAttribute("viewSector") SectorMasterVO sectorMasterVO,HttpSession session) throws NoDataFoundException {
   
    	SectorListVO  sectorVO=new SectorListVO();
    	sectorMasterVO.setSectorListVO(sectorVO);
         List<SectorListVO> sectorVOs1 =sectorService.selectSectorList(sectorMasterVO.getSectorListVO());
     	session.setAttribute("sectorVOs", sectorVOs1);
     	 
         Map<String, SectorListVO> sectorProfileMap = sectorService
		      	.listToMap(sectorVOs1);
 	     session.setAttribute("sectorProfileMap", sectorProfileMap);
     return "viewSector";
     }
    
    
    @RequestMapping(value = "/deleteSector", method = RequestMethod.GET)
    public String deleteSectorGet(@ModelAttribute("deleteSector") SectorMasterVO sectorMasterVO,HttpSession session,HttpServletRequest request) throws NoDataFoundException  {

    	SectorVO sectorVO2=new SectorVO();
    	
     String sectorTypeId=request.getParameter("sectorTypeId"); 
     sectorVO2.setSectorTypeId(sectorTypeId);
     sectorMasterVO.setSectorVO(sectorVO2);
     sectorService.deleteSector(sectorMasterVO.getSectorVO());
     return "deleteSector";
    }



	

	
 	      
 
       
}
