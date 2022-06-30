package org.aone.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.aone.common.exception.DuplicateEntryException;
import org.aone.common.exception.NoDataFoundException;
import org.aone.common.exception.UpdateFailedException;
import org.aone.service.ITestService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;



@Controller
public class InsertTestController{
	
	final  Logger logger = Logger.getLogger(InsertTestController.class.getName());
	@Autowired
    private ITestService iTestService;
    
	@RequestMapping(value = "/insertTest", method = RequestMethod.GET)
    public String insertSubSectionGet(@ModelAttribute("insertTest") TestVO subSectionMasterVO,HttpSession session,HttpServletRequest request) throws NoDataFoundException {
        /*session.setAttribute("sectionName", null);*/


		
		

    return "insertTest";
    }


 	@RequestMapping(value = "/insertTest", method = RequestMethod.POST)
    public String  insertSubSectionPost(@ModelAttribute("insertTest") TestVO subSectionMasterVO,ModelMap map,HttpSession session,HttpServletRequest request) throws UpdateFailedException, DuplicateEntryException  
 	{ 			
	       
 			
	return "insertTest";
    }

	@RequestMapping(value = "/insertTest", method = RequestMethod.POST, params = {"testType", "!sector"})
	public @ResponseBody Map<String, String> testNamePost(
			HttpServletRequest request,HttpSession session) throws NoDataFoundException {
		Map<String, String> testTypeName = null;
		try {

			testTypeName=iTestService.getTestTypeName();
			session.setAttribute("testTypeName",testTypeName);
			
			} catch (NoDataFoundException e) {
			e.printStackTrace();
		}	
         
		logger.debug("testTypeName :" + testTypeName);
		return testTypeName;
	}
 	@RequestMapping(value = "/insertTest", method = RequestMethod.POST, params = {"sector","!section"})
	public @ResponseBody Map<String, String> sectorNamePost(
			HttpServletRequest request,HttpSession session) throws NoDataFoundException {
		
		String testType = (String) request.getParameter("testType");

		Map<String, String> sectorName = null;
		sectorName = iTestService.getSectorName(testType);
		session.setAttribute("sectorName",sectorName);

		
		logger.debug("SectorName :" + sectorName);


		return sectorName;
	}
	   
	

 	@RequestMapping(value = "/insertTest", method = RequestMethod.POST, params 
 	  = {"section"})
	public @ResponseBody Map<String, String> sectionNamePost(
			HttpServletRequest request, HttpServletResponse response,
			ModelMap model, HttpSession session) throws NoDataFoundException {
		
		String testType = (String) request.getParameter("testType");
		String sectorName = (String) request.getParameter("sector");

 		
 		Map<String, String> sectionName = null;
		try {
			System.out.println("post in params sec");    
			
			
			
			sectionName=iTestService.getSectionName(testType,sectorName);
			System.out.println("test"+sectionName);
			
			
			
			} catch (NoDataFoundException e) {
			e.printStackTrace();
		}	
          session.setAttribute("sectionName", sectionName);
		return sectionName;
	}
	   
	
 
 	
/*	@RequestMapping(value = "/insertTest", method = RequestMethod.POST, params = "subSection")
	public @ResponseBody Map<String, String> subSectionNamePost(
			HttpServletRequest request, HttpServletResponse response,
			ModelMap model, HttpSession session) throws NoDataFoundException {
		Map<String, String> sectionName = null;
		try {
			System.out.println("post in params");    

			sectionName=iTestService.getSubSectionName();
			System.out.println("test"+sectionName);
			} catch (NoDataFoundException e) {
			e.printStackTrace();
		}	

		logger.debug("Transport in Section Map :" + sectionName);
		return sectionName;
	}*/
       
}
