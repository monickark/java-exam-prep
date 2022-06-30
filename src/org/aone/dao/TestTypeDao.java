package org.aone.dao;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.aone.common.exception.DuplicateEntryException;
import org.aone.common.exception.NoDataFoundException;
import org.aone.common.exception.UpdateFailedException;
import org.aone.dao.TestTypeListDao.TestDataSet;
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
public class TestTypeDao extends BaseDao implements ITestTypeDao {
	@Autowired
	JdbcTemplate jdbcTemplate;
	// Logging
	Logger logger = Logger.getLogger(TestTypeDao.class);

	@Override
	public void insertTestType(final TestType testType) throws UpdateFailedException, DuplicateEntryException {
		// TODO Auto-generated method stub
		StringBuffer query=new StringBuffer();
		 
		query=query.append("insert into test(TEST_TYPE,TEST_TYPE_ID,DB_TS,DEL_FLG,DATE_ADDED,R_CRE_TIME,R_MOD_TIME)values(?,?,?,?,?,?,?)");
	
       try
       {
		jdbcTemplate.update(query.toString(), new PreparedStatementSetter() {

			@Override
			public void setValues(PreparedStatement preparedStatement)
					throws SQLException {
				// TODO Auto-generated method stub
				
				preparedStatement.setString(1,testType.getTestType());
            	preparedStatement.setString(2,testType.getTestTypeId());
            	preparedStatement.setString(3,testType.getDbTs());
            	preparedStatement.setString(4,testType.getDelFlg());
            	preparedStatement.setString(5,testType.getDateAdded());
            	preparedStatement.setString(6,testType.getrCreTime());
            	preparedStatement.setString(7, testType.getrModTime());
            }
        	});
            }
            catch (DuplicateKeyException duplicateKeyException) {
	         throw new DuplicateEntryException();
             }
       
       
       
		
	}

	@Override
	public String getNextTestTypeId() {
		// TODO Auto-generated method stub

   		String sql = "select TEST_TYPE_ID+1 from test order by TEST_TYPE_ID  desc limit 1";

   		String Test_Type_Id = getJdbcTemplate().queryForObject(sql.toString(),
   				String.class);
	
		return Test_Type_Id;
	}
	
	
	
	
	
	
	


	@Override
	public void editTestTpe(final TestType testType) throws UpdateFailedException {
		// TODO Auto-generated method stub
		StringBuffer query=new StringBuffer();
		query=query.append("update test set TEST_TYPE=?,R_MOD_TIME=?,DB_TS=? where TEST_TYPE_ID=?");
		int changerow=jdbcTemplate.update(query.toString(), new PreparedStatementSetter() {  
	            @Override 
	        public void setValues(PreparedStatement pss) throws SQLException{
	            	pss.setString(1,testType.getTestType());
	            	pss.setString(2, testType.getrModTime());

	            	pss.setString(3,testType.getDbTs());

	            	pss.setString(4,testType.getTestTypeId());

	            
	            }
		});
		
	}

	

	@Override
	public String getDbTs() {
		// TODO Auto-generated method stub

   		String sql = "select DB_TS+1 from test order by DB_TS  desc limit 1";

   		String db_Ts = getJdbcTemplate().queryForObject(sql.toString(),
   				String.class);
	
		return db_Ts;
	}


	@Override
	public void deleteTestType(final TestType testType) {
		// TODO Auto-generated method stub
		StringBuffer query=new StringBuffer();
		query=query.append("delete from test where TEST_TYPE_ID=? and DEL_FLG=? ");

		int changerow=jdbcTemplate.update(query.toString(), new PreparedStatementSetter() {  
	            @Override 
	        public void setValues(PreparedStatement pss) throws SQLException{
	            	pss.setString(1,testType.getTestTypeId());
	            	pss.setString(2,"N");
                   System.out.println("pss"+pss);
	            
	            }
		});
		
	}
	public TestType selectTestType(final TestType testType)
			throws NoDataFoundException {
		TestType testTpe1=null;
		StringBuffer sql = new StringBuffer()
	
	
		.append("select TEST_TYPE from test where TEST_TYPE_ID=?; ");
		testTpe1 = (TestType)jdbcTemplate.query(
				sql.toString(),  new PreparedStatementSetter(){
					@Override
			        public void setValues(PreparedStatement ps) throws SQLException {
					ps.setString(1,testType.getTestTypeId());
					System.out.println("if"+ps);
			       }
				
		   },new TestDataSet());
		System.out.println("uuu"+testTpe1);
		return testTpe1;
	}

	@SuppressWarnings("rawtypes")
	class TestDataSet implements ResultSetExtractor {
		@Override
		public TestType extractData(ResultSet resultSet) throws SQLException,
		DataAccessException {
			TestType testTpe =new TestType();

	if(resultSet.next()){
		testTpe.setTestType(resultSet.getString("TEST_TYPE"));
		System.out.println("if"+testTpe);

	}
	
	return testTpe;
       } 
		

	}

	
}