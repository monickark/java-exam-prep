package org.aone.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.servlet.http.HttpSession;

import org.aone.common.exception.DuplicateEntryException;
import org.aone.common.exception.UpdateFailedException;
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
public class InsertTestTypeController{
	
	final  Logger logger = Logger.getLogger(InsertTestTypeController.class.getName());
	@Autowired
    private ITestTypeService testTypeService;
    
	@RequestMapping(value = "/testSignup", method = RequestMethod.GET)
    public String insertTestTypeGet(@ModelAttribute("testSignup") TestTypeVO testTypeVO,HttpSession session) {
	

    return "testSignup";
    }


 	@RequestMapping(value = "/testSignup", method = RequestMethod.POST)
    public String  insertTestTypePost(@ModelAttribute("testSignup") TestTypeVO testTypeVO,ModelMap map,HttpSession session)  
 	{
 		
 		try {
 			String testTypeId = testTypeService.getNextTestTypeId();
 			testTypeVO.setTestTypeId(testTypeId);
 			testTypeService.insertTestType(testTypeVO);
 			map.addAttribute("message","success");
		} catch (UpdateFailedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
	 		map.addAttribute("message","Failed");

		} catch (DuplicateEntryException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
	 		map.addAttribute("message","Failed");

		}
	       
 			
	 return "testSignup";
    }

 
 	

	
 	      
 
       
}
