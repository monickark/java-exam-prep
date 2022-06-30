package org.aone.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.aone.common.bussiness.CommonBusiness;
import org.aone.common.exception.UpdateFailedException;
import org.aone.controller.SectorListVO;
import org.aone.controller.SectorVO;
import org.aone.service.ISectionService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;



@Controller
public class EditSectionController{
	
	final  Logger logger = Logger.getLogger(EditSectionController.class.getName());
	@Autowired
    private ISectionService sectionService;
	@Autowired
	private CommonBusiness commonBussiness;
    @RequestMapping(value = "updateSection", method = RequestMethod.GET)
    public String editSectionGet(@ModelAttribute("updateSection") SectionMasterVO sectionMasterVO,HttpSession session,ModelMap map,HttpServletRequest request) {

    
        Map<String, SectionListVO> profileMap = (Map<String, SectionListVO>) session
   				.getAttribute("sectionProfileMap");
        String sectionId=request.getParameter("sectionId");  
        System.out.println("sectionid"+sectionId);
        System.out.println("profileMap"+profileMap);

        SectionListVO sectionListVO=new SectionListVO();
        sectionListVO.setSectionId(sectionId);
     
        SectionListVO listVO = profileMap.get(sectionId);
        SectionVO sectionVO=new SectionVO();
        sectionListVO.setSection(listVO.getSection());
        sectionListVO.setSector(listVO.getSector());

        commonBussiness.changeObject(sectionVO, sectionListVO);
        sectionMasterVO.setSectionVO(sectionVO);
        session.setAttribute("sectionId",sectionVO.getSectionId());
 
         map.addAttribute("sector",sectionMasterVO.getSectionVO().getSector());

    return "updateSection";
    }


 	@RequestMapping(value = "/updateSection", method = RequestMethod.POST)
    public String  editSectionPost(@ModelAttribute("updateSection") SectionMasterVO sectorMasterVO,HttpSession sess,ModelMap map,HttpServletRequest request)  
 	{
 		
 		try {
 			SectionVO sectionVO=new SectionVO();
            String sectionId=(String) sess.getAttribute("sectionId");	
            sectionVO.setSectionId(sectionId);
	 	     String section=request.getParameter("sectionVO.section");
	         sectionVO.setSection(section);
System.out.println("section"+section);
	 	     String sector=request.getParameter("sectionVO.sector");
	 	     sectionVO.setSector(sector);
	 	    sectorMasterVO.setSectionVO(sectionVO);
	        System.out.println("sectioncv"+sectionVO);

	 	     map.addAttribute("sector",sectorMasterVO.getSectionVO().getSection());

 			sectionService.updateSection(sectorMasterVO.getSectionVO());
		} catch (UpdateFailedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
	 		map.addAttribute("message","Failed");

		}
	       
			
			return "updateSection";
    }


	

	
 	      
 
       
}
