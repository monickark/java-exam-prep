package org.aone.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.aone.common.exception.NoDataFoundException;
import org.aone.controller.SectorListVO;
import org.aone.service.ISubSectionService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;



@Controller
public class ManageSubSectionController{
	
	final  Logger logger = Logger.getLogger(ManageSubSectionController.class.getName());
	@Autowired
    private ISubSectionService subSectionService;
    @RequestMapping(value = "/viewSubSection", method = RequestMethod.GET)
     public String manageSubSectionGet(@ModelAttribute("viewSubSection") SubSectionMasterVO subSectionMasterVO,HttpSession session) throws NoDataFoundException {
   
    	
    	SubSectionListVO  subSectionListVO=new SubSectionListVO();
    	subSectionMasterVO.setSubSectionListVO(subSectionListVO);
         List<SubSectionListVO> subSectionListVOs =subSectionService.selectSubSectionList(subSectionMasterVO.getSubSectionListVO());
     	session.setAttribute("subSectionListVOs", subSectionListVOs);
     	 
         Map<String, SubSectionListVO> sectorProfileMap = subSectionService
		      	.listToMap(subSectionListVOs);
 	     session.setAttribute("subSectionProfileMap", sectorProfileMap);
    	
        
     return "viewSubSection";
     }



	
    @RequestMapping(value = "/deleteSubSection", method = RequestMethod.GET)
    public String deleteSubSectionGet(@ModelAttribute("deleteSubSection") SubSectionMasterVO subSectionMasterVO,HttpSession session,HttpServletRequest request) throws NoDataFoundException  {

     String subSectionId=request.getParameter("subSectionId"); 
     SubSectionVO subSectionVO=new SubSectionVO();
     subSectionVO.setSubSectionId(subSectionId);
     subSectionMasterVO.setSubSectionVO(subSectionVO);
     subSectionService.deleteSubSection(subSectionMasterVO.getSubSectionVO());
     return "deleteSubSection";
    }
	
 	      
 
       
}
