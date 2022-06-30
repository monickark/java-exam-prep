package org.aone.dao;

import java.util.List;
import java.util.Map;

import org.aone.common.exception.DuplicateEntryException;
import org.aone.common.exception.NoDataFoundException;
import org.aone.common.exception.UpdateFailedException;


public interface IQuestionDao {

	Map<String, String> getSubSectionId() throws NoDataFoundException;

	void insertQuestion(Question section) throws UpdateFailedException,
			DuplicateEntryException;
	
	String getNextSectord();
	public String getDbTs() ;
	public void editQuestion(Question sector) throws UpdateFailedException ;
	public void deleteQuestion(Question question);



	
}
