package org.aone.service;

import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.aone.common.bussiness.CommonBusiness;
import org.aone.common.exception.DuplicateEntryException;
import org.aone.common.exception.NoDataFoundException;
import org.aone.common.exception.UpdateFailedException;
import org.aone.controller.QuestionListVO;
import org.aone.controller.QuestionVO;
import org.aone.controller.TestTypeVO;
import org.aone.dao.IQuestionListDao;
import org.aone.dao.IQuestionDao;
import org.aone.dao.Question;
import org.aone.dao.QuestionList;
import org.aone.dao.TestType;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;





@Service
public class QuestionService implements IQuestionService {

	// Logging
	Logger logger = Logger.getLogger(QuestionService.class);
	@Autowired
	private IQuestionDao questionDao;
	@Autowired
	private IQuestionListDao questionListDao;
	@Autowired
	private CommonBusiness commonBusiness;
	
	public Map<String, String> getSubSectionName()
			throws NoDataFoundException {
		// TODO Auto-generated method stub
		Map<String, String> subSectionMap = questionDao.getSubSectionId();
		return subSectionMap;

	}
	

    public void insertQuestion(QuestionVO  questionVO) throws UpdateFailedException, DuplicateEntryException {
    	// TODO Auto-generated method stub
    
    	//get Sectorid
    	String name=getNextTestTypeId();
      	
        //split a string and number
    	String splStr = name.substring(3, 6);
    	
    	//convert string into int
        int i = Integer.parseInt(splStr);
        i=i+1;
        
        
        String inttost = Integer.toString(i);
        String sectorId=null;
	      if (0 < i && i <= 9) {
	    	  	 sectorId = "QST00".concat(inttost);
	       }
	      else if(10 <= i && i <= 99){
	    	      sectorId = "QST0".concat(inttost);

	      }
	      else  {
	    	  	sectorId = "QST".concat(inttost);
	      }
    	
	     questionVO.setQuestionId(sectorId);
    	 
	     Question testTpe=new  Question();
    	 commonBusiness.changeObject(testTpe, questionVO);
	     
    	 testTpe.setDbTs("1");
	     testTpe.setDelFlg("N");

	     
	     
	     DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		 Calendar cal = Calendar.getInstance();
		 
	     
	     String creTime=dateFormat.format(cal.getTime());
	     testTpe.setrCreTime(creTime);

		 String modTime=dateFormat.format(cal.getTime());
	     testTpe.setrModTime(modTime);
	     

		 String dateAdded=dateFormat.format(cal.getTime());
	     testTpe.setDateAdded(dateAdded);

	     questionDao.insertQuestion(testTpe);
	
	}
    
    public String getNextTestTypeId() {
       return questionDao.getNextSectord();

	}
    

    
    
    
	public void editQuestion(QuestionVO questionVO)throws UpdateFailedException {
		// TODO Auto-generated method stub
		Question question = new Question();

		commonBusiness.changeObject(question, questionVO);
         
	   String db_ts=getDbTs();
	   question.setDbTs(db_ts);
	     
	     DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		 Calendar cal = Calendar.getInstance();
		 
	     String modTime=dateFormat.format(cal.getTime());
		 question.setrModTime(modTime);
	     
      questionDao.editQuestion(question);
	
	}
	
	public String getDbTs() {
		return questionDao.getDbTs();

	}
	
	public List<QuestionListVO> selectQuestionList(QuestionListVO questionListVO) throws NoDataFoundException
	{

       List<QuestionListVO> questionListVOs = new ArrayList<QuestionListVO>();
       QuestionList question=new QuestionList();
       commonBusiness.changeObject(question,questionListVO );

        List<QuestionList> questionLists = questionListDao.selectQuestionList(question);

        for (QuestionList questionList : questionLists) {
        	QuestionListVO questionListVO2 = new QuestionListVO();
        	commonBusiness.changeObject(questionListVO2, questionList);
	      questionListVOs.add(questionListVO2);
         }

     return questionListVOs;
    }
	
	
	
	
	public Map<String, QuestionListVO> listToMap(List<QuestionListVO> questionVOs) {
    
		 Map<String, QuestionListVO> map = new HashMap<String, QuestionListVO>();
	     for (int i = 0; i < questionVOs.size(); i++) {
	    	 QuestionListVO questionVO = questionVOs.get(i);
			 String questDataValues=String.valueOf(questionVO.getQuestionId());
			 map.put(questDataValues, questionVO);
			 System.out.println("test"+map);
		 }	
		
		return map;
	}



	public void deleteQuestion(QuestionVO questionVO) {
		// TODO Auto-generated method stub
		Question question = new Question();

		commonBusiness.changeObject(question, questionVO);
		questionDao.deleteQuestion(question);
	
	}







}
