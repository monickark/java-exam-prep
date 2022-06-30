package org.aone.dao;


import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.aone.common.exception.DuplicateEntryException;
import org.aone.common.exception.NoDataFoundException;
import org.aone.common.exception.UpdateFailedException;
import org.apache.log4j.Logger;
import org.dao.BaseDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Repository;



@Repository
public class QuestionListDao extends BaseDao implements IQuestionListDao {
	@Autowired
	JdbcTemplate jdbcTemplate;
	// Logging
	Logger logger = Logger.getLogger(QuestionListDao.class);
	public List<QuestionList> selectQuestionList(final QuestionList questionList)
			throws NoDataFoundException {
		List<QuestionList> questionLists = new ArrayList<QuestionList>();

		StringBuffer sql = new StringBuffer()
	
		.append("select SUB_SECTION,QUESTION,DATE_ADDED,QUESTION_ID,OPTION1,OPTION2,OPTION3,OPTION4,ANSWER from question; ");
		questionLists = (List<QuestionList>)jdbcTemplate.query(
				sql.toString(),  new TestDataSet());
		
		return questionLists;
	}

	@SuppressWarnings("rawtypes")
	class TestDataSet implements ResultSetExtractor {
		@Override
		public List<QuestionList> extractData(ResultSet resultSet)
				throws SQLException, DataAccessException {
			List<QuestionList> questionLists = new ArrayList<QuestionList>();
			while (resultSet.next()) {
				QuestionList questionList =new QuestionList();
				questionList.setSubSection(resultSet.getString("SUB_SECTION"));
				questionList.setQuestion(resultSet.getString("QUESTION"));

				questionList.setDateAdded(resultSet.getString("DATE_ADDED"));
				questionList.setQuestionId(resultSet.getString("QUESTION_ID"));
				questionList.setOption1(resultSet.getString("OPTION1"));
				questionList.setOption2(resultSet.getString("OPTION2"));
				questionList.setOption3(resultSet.getString("OPTION3"));
				questionList.setOption4(resultSet.getString("OPTION4"));

				questionList.setAnswer(resultSet.getString("ANSWER"));

                questionLists.add(questionList);
			}
			return questionLists;
		}

	}

	
	
	
}