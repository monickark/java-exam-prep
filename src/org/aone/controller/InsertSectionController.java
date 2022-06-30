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
import org.aone.controller.SectorListVO;
import org.aone.controller.SectorVO;
import org.aone.service.ISectionService;
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
public class InsertSectionController{
	
	final  Logger logger = Logger.getLogger(InsertSectionController.class.getName());
	@Autowired
    private ISectionService sectionService;
    
	@RequestMapping(value = "/sectionSignUp", method = RequestMethod.GET)
    public String insertSectionGet(@ModelAttribute("sectionSignUp") SectionMasterVO sectionMasterVO,HttpSession session,HttpServletRequest request) throws NoDataFoundException {
		
		
		
	 return "sectionSignUp";
    }


 	@RequestMapping(value = "/sectionSignUp", method = RequestMethod.POST)
    public String  insertSectionPost(@ModelAttribute("sectionSignUp") SectionMasterVO sectionMasterVO,ModelMap map,HttpSession session,HttpServletRequest request) throws UpdateFailedException, DuplicateEntryException  
 	{
 	             try {
                     SectionVO sectionVO=new SectionVO();

                     String sector=request.getParameter("sectionListVO.sector");
                     sectionVO.setSectorTypeId(sector);

                     String section=request.getParameter("sectionListVO.section");
                     sectionVO.setSection(section);
                     System.out.println("section"+section);

                     sectionMasterVO.setSectionVO(sectionVO);
				 Map<String, String> transportName=sectionService.getName();
				
				 for (Entry<String, String> entry : transportName.entrySet()) {
			            if (entry.getKey().equals(sectionMasterVO.getSectionVO().getSectorTypeId())) {
			            	sectionMasterVO.getSectionVO().setSector(entry.getValue());
			            }
			        }
		     System.out.println("test"+sectionVO);
			 sectionService.insertSection(sectionMasterVO.getSectionVO());

			} catch (NoDataFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

;
 			
	       
 			
	return "sectionSignUp";
    }

 
 	@RequestMapping(value = "/sectionSignUp", method = RequestMethod.POST, params = "sector")
	public @ResponseBody Map<String, String> getTransport(
			HttpServletRequest request, HttpServletResponse response,
			ModelMap model, HttpSession session) throws NoDataFoundException {
		Map<String, String> transportName = null;
		try {
			System.out.println("post in params");    

			transportName=sectionService.getName();
			System.out.println("transportgetName"+transportName);
			} catch (NoDataFoundException e) {
			e.printStackTrace();
		}	

		logger.debug("Transport in Section Map :" + transportName);
		return transportName;
	}
	   
	
 	      
 
       
}
