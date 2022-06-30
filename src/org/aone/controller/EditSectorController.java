package org.aone.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.aone.common.bussiness.CommonBusiness;
import org.aone.common.exception.DuplicateEntryException;
import org.aone.common.exception.UpdateFailedException;
import org.aone.service.ISectorService;
import org.aone.service.ITestTypeService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;



@Controller
public class EditSectorController{
	
	final  Logger logger = Logger.getLogger(EditSectorController.class.getName());
	@Autowired
    private ISectorService updateSectorService;
	@Autowired
	private CommonBusiness commonBussiness;
    @RequestMapping(value = "updateSectors", method = RequestMethod.GET)
    public String editSectorGet(@ModelAttribute("updateSectors") SectorMasterVO sectorMasterVO,HttpSession session,ModelMap map,HttpServletRequest request) {

    	
     Map<String, SectorListVO> profileMap = (Map<String, SectorListVO>) session
				.getAttribute("sectorProfileMap");
     String sectorTypeId=request.getParameter("sectorTypeId");  
     SectorListVO sectorListVO=new SectorListVO();
     sectorListVO.setSectorTypeId(sectorTypeId);
     
     SectorListVO listVO = profileMap.get(sectorTypeId);
     sectorListVO.setTestType(listVO.getTestType());
     
     sectorListVO.setSector(listVO.getSector());
     SectorVO sectorVO=new SectorVO();

     commonBussiness.changeObject(sectorVO, sectorListVO);
     sectorMasterVO.setSectorVO(sectorVO);
     session.setAttribute("sectorId",sectorListVO.getSectorTypeId());
     map.addAttribute("testType",sectorMasterVO.getSectorVO().getTestType());
    return "updateSectors";
    }


 	@RequestMapping(value = "/updateSectors", method = RequestMethod.POST)
    public String  editSectorPost(@ModelAttribute("updateSectors") SectorMasterVO sectorMasterVO,HttpSession sess,ModelMap map,HttpServletRequest request)  
 	{
 		
 		try {
 			SectorVO sectorVO=new SectorVO();
            String sectorId=(String) sess.getAttribute("sectorId");	
            sectorVO.setSectorTypeId(sectorId);
	 	     String testtype=request.getParameter("sectorVO.testType");
	         sectorVO.setTestType(testtype);

	 	     String sector=request.getParameter("sectorVO.sector");
	 	     sectorVO.setSector(sector);

	         sectorMasterVO.setSectorVO(sectorVO);
	         map.addAttribute("testType",sectorMasterVO.getSectorVO().getTestType());


	 		updateSectorService.editSector(sectorMasterVO.getSectorVO());
	 		map.addAttribute("message","success");

	 		
		} catch (UpdateFailedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
	 		map.addAttribute("message","Failed");

		}
	       
			
			return "updateSectors";
    }


	

	
 	      
 
       
}
