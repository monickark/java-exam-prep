package org.aone.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.aone.common.bussiness.CommonBusiness;
import org.aone.common.exception.DuplicateEntryException;
import org.aone.common.exception.NoDataFoundException;
import org.aone.common.exception.UpdateFailedException;
import org.aone.service.ITestTypeService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;



@Controller
public class EditTestTypeController{
	
	final  Logger logger = Logger.getLogger(EditTestTypeController.class.getName());
	@Autowired
    private ITestTypeService viewTestService;
	@Autowired
	private CommonBusiness commonBussiness;
    @RequestMapping(value = "/updateTest", method = RequestMethod.GET)
    public String editTestTypeGet(@ModelAttribute("updateTest") TestTypeVO testTypeVO,HttpSession session,HttpServletRequest request) throws NoDataFoundException, UpdateFailedException {

     
     String testTypeId=request.getParameter("testTypeId");  
     testTypeVO.setTestTypeId(testTypeId);

      viewTestService.editTestType(testTypeVO);
     session.setAttribute("testTypeId", testTypeId);
   
    return "updateTest";
    }


 	@RequestMapping(value = "/updateTest", method = RequestMethod.POST)
    public String  editTestTypePost(@ModelAttribute("updateTest") TestTypeVO testTypeVO,HttpSession sess,ModelMap map) throws NoDataFoundException  
 	{
 		
 		try {
            String testTypeId=(String) sess.getAttribute("testTypeId");	
            testTypeVO.setTestTypeId(testTypeId);
	 		map.addAttribute("message","success");


	 		viewTestService.editTestType(testTypeVO);
		} catch (UpdateFailedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
	 		map.addAttribute("message","Failed");

		}
	       
			
			return "updateTest";
    }


	

	
 	      
 
       
}
