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
import org.aone.service.IQuestionService;
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
public class InsertQuestionController{
	
	final  Logger logger = Logger.getLogger(InsertQuestionController.class.getName());
	@Autowired
    private IQuestionService questionService;
    
	@RequestMapping(value = "/questionSignUp", method = RequestMethod.GET)
    public String insertQuestionGet(@ModelAttribute("questionSignUp") QuestionMasterVO questionMasterVO,HttpSession session,HttpServletRequest request,ModelMap map) throws NoDataFoundException {
		
		
		

    return "questionSignUp";
    }


 	@RequestMapping(value = "/questionSignUp", method = RequestMethod.POST)
    public String  insertQuestionPost(@ModelAttribute("questionSignUp") QuestionMasterVO questionMasterVO,ModelMap map,HttpSession session,HttpServletRequest request) throws UpdateFailedException, DuplicateEntryException  
 	{
 		
                    try {
                	    System.out.println("sw");
                     QuestionVO questionVO=new QuestionVO();
                     String subSection=request.getParameter("questionListVO.subSection");
                     questionVO.setSubSectionId(subSection);
 	            	System.out.println("subSection"+subSection);


                     String question=request.getParameter("questionListVO.question");
                     questionVO.setQuestion(question);
                     questionMasterVO.setQuestionVO(questionVO);
                     String option1=request.getParameter("questionListVO.option1");
                     questionVO.setOption1(option1);

                     String option2=request.getParameter("questionListVO.option2");
                     questionVO.setOption2(option2);

                     String option3=request.getParameter("questionListVO.option3");
                     questionVO.setOption3(option3);

                     String option4=request.getParameter("questionListVO.option4");
                     questionVO.setOption4(option4);

                     String answer=request.getParameter("questionListVO.answer");
                     questionVO.setAnswer(answer);
                     questionMasterVO.setQuestionVO(questionVO);
				      Map<String, String> subsectionid=questionService.getSubSectionName();
				
				 for (Entry<String, String> entry : subsectionid.entrySet()) {
			            if (entry.getKey().equals(questionMasterVO.getQuestionVO().getSubSectionId())) {
			            	questionMasterVO.getQuestionVO().setSubSection(entry.getValue());
			            }
			        }
	            	System.out.println(""+answer);

			 questionService.insertQuestion(questionMasterVO.getQuestionVO());

			} catch (NoDataFoundException e1) {
				// TODO Auto-generated catch block
			}

;
 			
	       
 			
	return "questionSignUp";
    }

 
@RequestMapping(value = "/questionSignUp", method = RequestMethod.POST, params = "subSection")
	public @ResponseBody Map<String, String> getTransport(
			HttpServletRequest request, HttpServletResponse response,
			ModelMap model, HttpSession session) throws NoDataFoundException {
		Map<String, String> subSection = null;
		try {
			System.out.println("post in params");    

			subSection=questionService.getSubSectionName();
			System.out.println("tra"+subSection);
			} catch (NoDataFoundException e) {
			e.printStackTrace();
		}	

		logger.debug("Transport in Section Map :" + subSection);
		return subSection;
	}
	
 	      
 
       
}
