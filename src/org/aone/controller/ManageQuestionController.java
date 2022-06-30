package org.aone.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.aone.common.exception.DuplicateEntryException;
import org.aone.common.exception.NoDataFoundException;
import org.aone.common.exception.UpdateFailedException;
import org.aone.controller.SectorListVO;
import org.aone.service.IQuestionService;
import org.aone.service.ITestTypeService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;



@Controller
public class ManageQuestionController{
	
	final  Logger logger = Logger.getLogger(ManageQuestionController.class.getName());
	@Autowired
    private IQuestionService questionService;
    @RequestMapping(value = "/viewQuestion", method = RequestMethod.GET)
     public String manageQuestion(@ModelAttribute("viewQuestion") QuestionMasterVO questionMasterVO,HttpSession session) throws NoDataFoundException {
   
    	QuestionListVO  questionListVO=new QuestionListVO();
    	questionMasterVO.setQuestionListVO(questionListVO);
    	
        List<QuestionListVO> questionVOs =questionService.selectQuestionList(questionMasterVO.getQuestionListVO());
      	session.setAttribute("questionVO", questionVOs);
     	 
        Map<String, QuestionListVO> questProfileMap = questionService
		      	.listToMap(questionVOs);
 	     session.setAttribute("questionProfileMap", questProfileMap);
    	
     return "viewQuestion";
     }



   @ RequestMapping(value = "/deleteQuestion", method = RequestMethod.GET)
    public String deleteQuestion(@ModelAttribute("deleteQuestion") QuestionMasterVO questionMasterVO,HttpSession session,HttpServletRequest request) throws NoDataFoundException  {

     String sectorTypeId=request.getParameter("questionId"); 
     QuestionVO questionVO=new QuestionVO();
     questionVO.setQuestionId(sectorTypeId);
     questionMasterVO.setQuestionVO(questionVO);
    
     questionService.deleteQuestion(questionVO);
     return "deleteQuestion";
    }

	
 	      
 
       
}
