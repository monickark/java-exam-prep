package org.aone.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.aone.common.exception.DuplicateEntryException;
import org.aone.common.exception.NoDataFoundException;
import org.aone.common.exception.UpdateFailedException;
import org.aone.controller.SectorVO;
import org.aone.service.ISubSectionService;
import org.aone.service.ITestTypeService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;



@Controller
public class InsertSubSectionController{
	
	final  Logger logger = Logger.getLogger(InsertSubSectionController.class.getName());
	@Autowired
    private ISubSectionService subSectionService;
    
	@RequestMapping(value = "/subSectionSignUp", method = RequestMethod.GET)
    public String insertSubSectionGet(@ModelAttribute("subSectionSignUp") SubSectionMasterVO subSectionMasterVO,HttpSession session,HttpServletRequest request) throws NoDataFoundException {


		
		

    return "subSectionSignUp";
    }


 	@RequestMapping(value = "/subSectionSignUp", method = RequestMethod.POST)
    public String  insertSubSectionPost(@ModelAttribute("subSectionSignUp") SubSectionMasterVO subSectionMasterVO,ModelMap map,HttpSession session,HttpServletRequest request) throws UpdateFailedException, DuplicateEntryException  
 	{
 	               try {
                	  SubSectionVO subSectionVO=new SubSectionVO();
                      String section=request.getParameter("subSectionListVO.section");
                      subSectionVO.setSectionId(section);
                      
			   		     System.out.println("test"+section);

                      String subSection=request.getParameter("subSectionListVO.subSection");
                      subSectionVO.setSubSection(subSection);
			   		     System.out.println("subSection"+subSection);

                      subSectionMasterVO.setSubSectionVO(subSectionVO);
				      Map<String, String> map2=subSectionService.getSectionName();
				
				       for (Entry<String, String> entry : map2.entrySet()) {
			            if (entry.getKey().equals(subSectionMasterVO.getSubSectionVO().getSectionId())) {
			            	subSectionMasterVO.getSubSectionVO().setSection(entry.getValue());
			   		     System.out.println("test"+subSectionMasterVO.getSubSectionVO().getSubSectionId());

			            }
			        }
		     System.out.println("test"+subSectionVO);
			 subSectionService.insertSubSection(subSectionMasterVO.getSubSectionVO());

			} catch (NoDataFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

;
 			
	       
 			
	return "subSectionSignUp";
    }

 
 	@RequestMapping(value = "/subSectionSignUp", method = RequestMethod.POST, params = "section")
	public @ResponseBody Map<String, String> getTransport(
			HttpServletRequest request, HttpServletResponse response,
			ModelMap model, HttpSession session) throws NoDataFoundException {
		Map<String, String> sectionName = null;
		try {
			System.out.println("post in params");    

			sectionName=subSectionService.getSectionName();
			System.out.println("transportgetName"+sectionName);
			} catch (NoDataFoundException e) {
			e.printStackTrace();
		}	

		logger.debug("Transport in Section Map :" + sectionName);
		return sectionName;
	}
	   
	
 	      
 
       
}
