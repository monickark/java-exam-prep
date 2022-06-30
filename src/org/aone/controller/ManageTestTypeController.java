package org.aone.controller;

import java.util.List;
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
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;



@Controller
public class ManageTestTypeController{
	
	final  Logger logger = Logger.getLogger(ManageTestTypeController.class.getName());
	@Autowired
    private ITestTypeService viewTestService;
	@Autowired
	private CommonBusiness commonBussiness;

    @RequestMapping(value = "/viewTest", method = RequestMethod.GET)
     public String manageTestTypeGet(@ModelAttribute("viewTest") TestTypeListVO testTypeVO,HttpSession session) throws NoDataFoundException {
     
         List<TestTypeListVO> testTypeVOs =viewTestService.selectTestType(testTypeVO);
     	session.setAttribute("viewTest", testTypeVOs);
    
     	Map<String, TestTypeListVO> viewTestTypeMap = viewTestService
		      	.testTypeListToMap(testTypeVOs);
 	     session.setAttribute("testProfileMap", viewTestTypeMap);

     return "viewTest";
     }



    @RequestMapping(value = "/deleteTest", method = RequestMethod.GET)
    public String deleteTestType(@ModelAttribute("deleteTest") TestTypeVO testTypeVO,HttpSession session,HttpServletRequest request) throws NoDataFoundException  {

     String testTypeId=request.getParameter("testTypeId"); 
     testTypeVO.setTestTypeId(testTypeId);

     viewTestService.deleteTestType(testTypeVO);
     return "deleteTest";
    }

	
 	      
 
       
}
