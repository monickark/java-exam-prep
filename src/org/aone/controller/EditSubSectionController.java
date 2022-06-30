package org.aone.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.aone.common.bussiness.CommonBusiness;
import org.aone.common.exception.UpdateFailedException;
import org.aone.controller.SectorVO;
import org.aone.service.ISubSectionService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;



@Controller
public class EditSubSectionController{
	
	final  Logger logger = Logger.getLogger(EditSubSectionController.class.getName());
	@Autowired
    private ISubSectionService subSectionService;
	@Autowired
	private CommonBusiness commonBussiness;
    @RequestMapping(value = "updateSubSection", method = RequestMethod.GET)
    public String editSubSectionGet(@ModelAttribute("updateSubSection")SubSectionMasterVO subSectionMasterVO,HttpSession session,ModelMap map,HttpServletRequest request) {

    	
     Map<String, SubSectionListVO> profileMap = (Map<String, SubSectionListVO>) session
				.getAttribute("subSectionProfileMap");
     String subSectionId=request.getParameter("subSectionId"); 
     System.out.println("sectionid"+subSectionId);
     System.out.println("profileMap"+profileMap);
     SubSectionListVO subSectionListVO=new SubSectionListVO();
     subSectionListVO.setSubSectionId(subSectionId);

     SubSectionListVO sectionListVO = profileMap.get(subSectionId);
     subSectionListVO.setSubSection(sectionListVO.getSubSection());
     subSectionListVO.setSection(sectionListVO.getSection());
     SubSectionVO subSectionVO2=new SubSectionVO();
     
     commonBussiness.changeObject(subSectionVO2, subSectionListVO);
    
     subSectionMasterVO.setSubSectionVO(subSectionVO2);
     map.addAttribute("subSection",subSectionMasterVO.getSubSectionVO().getSection());
     session.setAttribute("subSectionId",subSectionMasterVO.getSubSectionVO().getSubSectionId());

     return "updateSubSection";
    }


 	@RequestMapping(value = "/updateSubSection", method = RequestMethod.POST)
    public String  editSubSectionPost(@ModelAttribute("updateSubSection") SubSectionMasterVO subSectionMasterVO,HttpSession sess,ModelMap map,HttpServletRequest request)  
 	{
 		
 		try {
	 	   
 			
 			SubSectionVO subSectionVO=new SubSectionVO();
            String subSectionId=(String) sess.getAttribute("subSectionId");	
            subSectionVO.setSubSectionId(subSectionId);

            String section=request.getParameter("subSectionVO.section");	
            subSectionVO.setSection(section);
 			
	 	    String subSection=request.getParameter("subSectionVO.subSection");
	 	    subSectionVO.setSubSection(subSection);
	 	   subSectionMasterVO.setSubSectionVO(subSectionVO);
 			map.addAttribute("message","success");
	 	    map.addAttribute("subSection",subSectionMasterVO.getSubSectionVO().getSection());
		 	   System.out.println("section"+subSectionMasterVO.getSubSectionVO().getSubSectionId());

	 	   subSectionService.editSubSection(subSectionMasterVO.getSubSectionVO());
		} catch (UpdateFailedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
	 		map.addAttribute("message","Failed");

		}
	       
			
			return "updateSubSection";
    }


	

	
 	      
 
       
}
