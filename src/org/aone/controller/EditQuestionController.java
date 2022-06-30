package org.aone.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.aone.common.bussiness.CommonBusiness;
import org.aone.common.exception.UpdateFailedException;
import org.aone.controller.SectorListVO;
import org.aone.controller.SectorVO;
import org.aone.service.IQuestionService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;



@Controller
public class EditQuestionController{
	
	final  Logger logger = Logger.getLogger(EditQuestionController.class.getName());
	@Autowired
    private IQuestionService updateSectorService;
	@Autowired
	private CommonBusiness commonBussiness;
    @RequestMapping(value = "updateQuestion", method = RequestMethod.GET)
    public String editQuestionGet(@ModelAttribute("updateQuestion") QuestionMasterVO questionMasterVO,HttpSession session,ModelMap map,HttpServletRequest request) {

      Map<String, QuestionListVO> profileMap = (Map<String, QuestionListVO>) session
				.getAttribute("questionProfileMap");
       String questionId=request.getParameter("questionId");
       System.out.println("profi;e"+profileMap);
       System.out.println("profi;e"+questionId);

       QuestionListVO questionListVO=new QuestionListVO();
       questionListVO.setQuestionId(questionId);
     
      QuestionListVO listVO = profileMap.get(questionId);
     
      questionListVO.setSubSection(listVO.getSubSection());
      questionListVO.setQuestion(listVO.getQuestion());
      questionListVO.setOption1(listVO.getOption1());

      questionListVO.setOption2(listVO.getOption2());
      questionListVO.setOption3(listVO.getOption3());
      questionListVO.setOption4(listVO.getOption4());
      questionListVO.setAnswer(listVO.getAnswer());

      QuestionVO questionVO2=new QuestionVO();
      
      commonBussiness.changeObject(questionVO2, questionListVO);
      System.out.println("s"+questionListVO);

      questionMasterVO.setQuestionVO(questionVO2);
      
      session.setAttribute("questionId",questionMasterVO.getQuestionVO().getQuestionId());
      map.addAttribute("subSection",questionMasterVO.getQuestionVO().getSubSection());
System.out.println("s"+questionMasterVO.getQuestionVO());
     
   
    return "updateQuestion";
    }


 	@RequestMapping(value = "/updateQuestion", method = RequestMethod.POST)
    public String  editQuestionPost(@ModelAttribute("updateQuestion") QuestionMasterVO questionMasterVO,HttpSession sess,ModelMap map,HttpServletRequest request)  
 	{
 		
 		try {
 			 QuestionVO questionVO=new QuestionVO();
             
 			 String questionId=(String) sess.getAttribute("questionId");	
             questionVO.setQuestionId(questionId);
	 	     
             String question=request.getParameter("questionVO.question");
	 	     questionVO.setQuestion(question);
	 	     
	 	     String subSection=request.getParameter("questionVO.subSection");
	 	     questionVO.setSubSection(subSection);
 	 	     
	 	     String option1=request.getParameter("questionVO.option1");
	 	    questionVO.setOption1(option1);
	 	     String option2=request.getParameter("questionVO.option2");
	 	    questionVO.setOption2(option2);
	 	     String option3=request.getParameter("questionVO.option3");
	 	    questionVO.setOption3(option3);
	 	     String option4=request.getParameter("questionVO.option4");
	 	    questionVO.setOption4(option4);
	 	     String answer=request.getParameter("questionVO.answer");
		 	    questionVO.setAnswer(answer);

	 	     questionMasterVO.setQuestionVO(questionVO);
	         map.addAttribute("subSection",questionMasterVO.getQuestionVO().getSubSection());

 			
 		
	 		map.addAttribute("message","success");

	 		updateSectorService.editQuestion(questionMasterVO.getQuestionVO());
		} catch (UpdateFailedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
	 		map.addAttribute("message","Failed");

		}
	       
			
			return "updateQuestion";
    }


	

	
 	      
 
       
}
