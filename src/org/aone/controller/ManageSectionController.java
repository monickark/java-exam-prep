package org.aone.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.aone.common.exception.DuplicateEntryException;
import org.aone.common.exception.NoDataFoundException;
import org.aone.common.exception.UpdateFailedException;
import org.aone.controller.SectorListVO;
import org.aone.service.ISectionService;
import org.aone.service.ITestTypeService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;



@Controller
public class ManageSectionController{
	
	final  Logger logger = Logger.getLogger(ManageSectionController.class.getName());
	@Autowired
    private ISectionService sectionService;
    @RequestMapping(value = "/viewSection", method = RequestMethod.GET)
     public String manageSectionGet(@ModelAttribute("viewSection") SectionMasterVO sectionMasterVO,HttpSession session) throws NoDataFoundException {
    	SectionListVO  sectionListVO=new SectionListVO();
    	sectionMasterVO.setSectionListVO(sectionListVO);
         List<SectionListVO> sectionVOs =sectionService.selectSectionList(sectionMasterVO.getSectionListVO());
      	session.setAttribute("sectionVo", sectionVOs);
     	 
         Map<String, SectionListVO> sectionProfileMap = sectionService
		      	.listToMap(sectionVOs);
 	     session.setAttribute("sectionProfileMap", sectionProfileMap);
         System.out.println("sectioncv"+sectionProfileMap);

    	
      return "viewSection";
     }



    @RequestMapping(value = "/deleteSection", method = RequestMethod.GET)
    public String deleteSectionGet(@ModelAttribute("deleteSection") SectionMasterVO sectionMasterVO,HttpSession session,HttpServletRequest request) throws NoDataFoundException  {

     String sectorTypeId=request.getParameter("sectionId"); 
     SectionVO sectionVO=new SectionVO();
     sectionVO.setSectionId(sectorTypeId);
     sectionMasterVO.setSectionVO(sectionVO);

     sectionService.deleteSection(sectionMasterVO.getSectionVO());
     return "deleteSection";
    }

	
 	      
 
       
}
