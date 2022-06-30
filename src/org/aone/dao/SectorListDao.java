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
public class SectorListDao extends BaseDao implements ISectorListDao {
	@Autowired
	JdbcTemplate jdbcTemplate;
	// Logging
	Logger logger = Logger.getLogger(SectorListDao.class);
	public List<SectorList> selectSectorList(final SectorList testTpe)
			throws NoDataFoundException {
		List<SectorList> testTpes = new ArrayList<SectorList>();

		StringBuffer sql = new StringBuffer()
	
		.append("select TEST_TYPE,SECTOR,DATE_ADDED,SECTOR_ID from sector; ");
		testTpes = (List<SectorList>)jdbcTemplate.query(
				sql.toString(),  new TestDataSet());
		
		return testTpes;
	}

	@SuppressWarnings("rawtypes")
	class TestDataSet implements ResultSetExtractor {
		@Override
		public List<SectorList> extractData(ResultSet resultSet)
				throws SQLException, DataAccessException {
			List<SectorList> testTpes = new ArrayList<SectorList>();
			while (resultSet.next()) {
				SectorList testTpe =new SectorList();
				testTpe.setTestType(resultSet.getString("TEST_TYPE"));
				testTpe.setSector(resultSet.getString("SECTOR"));
				testTpe.setDateAdded(resultSet.getString("DATE_ADDED"));
				testTpe.setSectorTypeId(resultSet.getString("SECTOR_ID"));

                testTpes.add(testTpe);
			}
			return testTpes;
		}

	}
	
	
	
	

	
}