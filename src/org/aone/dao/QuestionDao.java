package org.aone.dao;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.aone.common.exception.DuplicateEntryException;
import org.aone.common.exception.NoDataFoundException;
import org.aone.common.exception.UpdateFailedException;
import org.aone.dao.TestType;
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
public class QuestionDao extends BaseDao implements IQuestionDao{
	@Autowired
	JdbcTemplate jdbcTemplate;
	// Logging
	Logger logger = Logger.getLogger(QuestionDao.class);
	
	
	@Override
	public Map<String, String> getSubSectionId() throws NoDataFoundException{

		
		StringBuffer query = new StringBuffer()
		.append("select SUB_SECTION_ID,SUB_SECTION ").append("from sub_section ")
		.append("where del_flg='N'");
		logger.debug("Query:"+query.toString());
		Map<String, String> transportNameMap = null;
		
		transportNameMap = getJdbcTemplate().query(query.toString(),new TransNameRowMapper());

		if (transportNameMap == null) {
			throw new NoDataFoundException();
		}
		return transportNameMap;
	}
   class TransNameRowMapper implements ResultSetExtractor<Map<String, String>> {

		@Override
		public Map<String, String> extractData(ResultSet rs)
				throws SQLException, DataAccessException {
			Map<String, String> tranIdMap = new LinkedHashMap<String, String>();
			while (rs.next()) {
				String key = (rs.getString("SUB_SECTION_ID"));
				String value = (rs.getString("SUB_SECTION"));
				tranIdMap.put(key, value);
			}
			return tranIdMap;
		}
	}
	
   
	
	@Override
	public void insertQuestion(final Question question) throws UpdateFailedException, DuplicateEntryException {
		// TODO Auto-generated method stub
		StringBuffer query=new StringBuffer();
		query=query.append("insert into question(SUB_SECTION,SUB_SECTION_ID,DB_TS,DEL_FLG,DATE_ADDED,QUESTION_ID,QUESTION,OPTION1,OPTION2,OPTION3,OPTION4,ANSWER,R_CRE_TIME,R_MOD_TIME)values(?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
      System.out.println("subsectiondao"+question.getSectionId());
		try
       {
		jdbcTemplate.update(query.toString(), new PreparedStatementSetter() {

			@Override
			public void setValues(PreparedStatement pss)
					throws SQLException {
				// TODO Auto-generated method stub
				
				pss.setString(1,question.getSubSection());
            	pss.setString(2,question.getSubSectionId());
            	pss.setString(3,question.getDbTs());
            	pss.setString(4,question.getDelFlg());
            	pss.setString(5,question.getDateAdded());
            	pss.setString(6,question.getQuestionId());
            	pss.setString(7,question.getQuestion());
            	pss.setString(8,question.getOption1());
            	pss.setString(9,question.getOption2());
            	pss.setString(10,question.getOption3());
            	pss.setString(11,question.getOption4());
            	pss.setString(12,question.getAnswer());
                 pss.setString(13, question.getrCreTime());
    pss.setString(14, question.getrModTime());

            }
        	});
            }
            catch (DuplicateKeyException duplicateKeyException) {
	         throw new DuplicateEntryException();
             }
       
       
      }
	
	

	@Override
	public String getNextSectord() {
		// TODO Auto-generated method stub

   		String sql = "select QUESTION_ID from question order by QUESTION_ID  desc limit 1";
   		String getNextQuestionId = getJdbcTemplate().queryForObject(sql.toString(),
   				String.class);
   		
		return getNextQuestionId;
	}
	
	
	
	@Override
	public void editQuestion(final Question question) throws UpdateFailedException {
		// TODO Auto-generated method stub
		StringBuffer query=new StringBuffer();
		query=query.append("update question set QUESTION=?,R_MOD_TIME=?,DB_TS=?,OPTION1=?,OPTION2=?,OPTION3=?,OPTION4=?,ANSWER=? where QUESTION_ID=? and SUB_SECTION=?;");
		int changerow=jdbcTemplate.update(query.toString(), new PreparedStatementSetter() {  
	            @Override 
	        public void setValues(PreparedStatement pss) throws SQLException{
	            	pss.setString(1,question.getQuestion());
	            	pss.setString(2,question.getrModTime());

	            	pss.setString(3,question.getDbTs());
	            	pss.setString(4,question.getOption1());
	            	pss.setString(5,question.getOption2());
	            	pss.setString(6,question.getOption3());
	            	pss.setString(7,question.getOption4());
	            	pss.setString(8,question.getAnswer());

	            	pss.setString(9,question.getQuestionId());

	            	pss.setString(10,question.getSubSection());
	            	System.out.println("sysu:"+pss);
	            }
		});
		
	}

	

	@Override
	public String getDbTs() {
		// TODO Auto-generated method stub

   		String sql = "select DB_TS+1 from question order by DB_TS  desc limit 1";

   		String db_Ts = getJdbcTemplate().queryForObject(sql.toString(),
   				String.class);
	
		return db_Ts;
	}
	public void deleteQuestion(final Question question) {
		// TODO Auto-generated method stub
		StringBuffer query=new StringBuffer();
		query=query.append("delete from question where QUESTION_ID=? and DEL_FLG=? ");
		int changerow=jdbcTemplate.update(query.toString(), new PreparedStatementSetter() {  
	            @Override 
	        public void setValues(PreparedStatement pss) throws SQLException{
	            	pss.setString(1,question.getQuestionId());
	            	pss.setString(2,"N");
	            
	            }
		});
		
		
	}


}

	
	



