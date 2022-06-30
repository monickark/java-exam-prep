package org.aone.service;

import java.util.List;
import java.util.Map;

import org.aone.common.exception.DuplicateEntryException;
import org.aone.common.exception.NoDataFoundException;
import org.aone.common.exception.UpdateFailedException;
import org.aone.controller.QuestionListVO;
import org.aone.controller.QuestionVO;
import org.aone.controller.TestTypeVO;



public interface IQuestionService {
	public Map<String, String> getSubSectionName()
			throws NoDataFoundException;

	void insertQuestion(QuestionVO testTypeVO) throws UpdateFailedException,
			DuplicateEntryException;
	   public String getNextTestTypeId();


	
	public void deleteQuestion(QuestionVO questionVO) ;
	
	public List<QuestionListVO> selectQuestionList(QuestionListVO questionListVO) throws NoDataFoundException;
	
	public Map<String, QuestionListVO> listToMap(List<QuestionListVO> questionVOs);
	
	public void editQuestion(QuestionVO questionVO)throws UpdateFailedException;
}
