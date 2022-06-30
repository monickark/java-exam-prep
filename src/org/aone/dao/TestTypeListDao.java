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
public class TestTypeListDao extends BaseDao implements ITestTypeListDao {
	@Autowired
	JdbcTemplate jdbcTemplate;
	// Logging
	Logger logger = Logger.getLogger(TestTypeListDao.class);
	public List<TestTypeList> selectTestTypeList(final TestTypeList testTpe)
			throws NoDataFoundException {
		List<TestTypeList> testTpes = new ArrayList<TestTypeList>();

		StringBuffer sql = new StringBuffer()
	
		.append("select TEST_TYPE,TEST_TYPE_ID,DATE_ADDED from test; ");
		testTpes = (List<TestTypeList>)jdbcTemplate.query(
				sql.toString(),  new TestDataSet());
		
		return testTpes;
	}

	@SuppressWarnings("rawtypes")
	class TestDataSet implements ResultSetExtractor {
		@Override
		public List<TestTypeList> extractData(ResultSet resultSet)
				throws SQLException, DataAccessException {
			List<TestTypeList> testTpes = new ArrayList<TestTypeList>();
			while (resultSet.next()) {
				TestTypeList testTpe =new TestTypeList();
				testTpe.setTestType(resultSet.getString("TEST_TYPE"));
				testTpe.setTestTypeId(resultSet.getString("TEST_TYPE_ID"));
				testTpe.setDateAdded(resultSet.getString("DATE_ADDED"));
                testTpes.add(testTpe);
			}
			return testTpes;
		}

	}
	
}