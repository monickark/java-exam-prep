package org.aone.dao;

import java.util.List;

import org.aone.common.exception.NoDataFoundException;




public interface IQuestionListDao {

	public List<QuestionList> selectQuestionList(final QuestionList testTpe)
			throws NoDataFoundException ;


}
