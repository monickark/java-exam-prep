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
public class TestDao extends BaseDao implements ITestDao{
	@Autowired
	JdbcTemplate jdbcTemplate;
	// Logging
	Logger logger = Logger.getLogger(TestDao.class);
	
	
	@Override
	public Map<String, String> getSectorName(final String testType) throws NoDataFoundException{
	
		
		StringBuffer query = new StringBuffer()
		.append("select SECTOR_ID,SECTOR ").append("from sector ")
		.append("where TEST_TYPE_ID=? and del_flg=?;");
		logger.debug("Query:"+query.toString());
		Map<String, String> transportNameMap = null;
		
		transportNameMap = getJdbcTemplate().query(query.toString(),
				new PreparedStatementSetter() {

			@Override
			public void setValues(PreparedStatement pss)
					throws SQLException {
				pss.setString(1, testType);
				pss.setString(2, "N");

			}

		},new TransNameRowMapper());

		if (transportNameMap == null) {
			throw new NoDataFoundException();
		}
		return transportNameMap;
	}

	
	class TransNameRowMapper implements ResultSetExtractor<Map<String, String>> {

		@Override
		public Map<String, String> extractData(ResultSet rs)
				throws SQLException, DataAccessException {
			Map<String, String> transNameMap = new LinkedHashMap<String, String>();
			while (rs.next()) {
				String key = (rs.getString("SECTOR_ID"));
				String value = (rs.getString("SECTOR"));
				transNameMap.put(key, value);
			}
			return transNameMap;
		}
	}
	

	
	@Override
	public Map<String, String> getTestTypeName() throws NoDataFoundException{

		
		StringBuffer query = new StringBuffer()
		.append("select TEST_TYPE_ID,TEST_TYPE ").append("from test ")
		.append("where del_flg='N';");
		logger.debug("Query:"+query.toString());
		Map<String, String> transportNameMap = null;
		
		transportNameMap = getJdbcTemplate().query(query.toString(),new TransNameRowMapper1());

		if (transportNameMap == null) {
			throw new NoDataFoundException();
		}
		return transportNameMap;
	}

	
	class TransNameRowMapper1 implements ResultSetExtractor<Map<String, String>> {

		@Override
		public Map<String, String> extractData(ResultSet rs)
				throws SQLException, DataAccessException {
			Map<String, String> transNameMap = new LinkedHashMap<String, String>();
			while (rs.next()) {
				String key = (rs.getString("TEST_TYPE_ID"));
				String value = (rs.getString("TEST_TYPE"));
				transNameMap.put(key, value);
			}
			return transNameMap;
		}
	}
	
	
	

	@Override
	public Map<String, String> getSection(final String testType, final String sectorName) throws NoDataFoundException{

		

		StringBuffer query = new StringBuffer()
		.append("select s.SECTION_ID,s.SECTION from section s INNER JOIN sector sec INNER JOIN  test t  ")
		.append("ON sec.TEST_TYPE_ID=t.TEST_TYPE_ID where t.TEST_TYPE_ID=? ")
		.append(" and s.SECTOR_ID=? and s.del_flg=?;");
		
		logger.debug("Query:"+query.toString());
		Map<String, String> transportNameMap = null;
		
		transportNameMap = getJdbcTemplate().query(query.toString(),
				new PreparedStatementSetter() {

			@Override
			public void setValues(PreparedStatement pss)
					throws SQLException {
				pss.setString(1, testType);
				pss.setString(2, sectorName);
                pss.setString(3, "N");

			}

		},new TransNameRowMapper3());

		if (transportNameMap == null) {
			throw new NoDataFoundException();
		}
		return transportNameMap;
	}

	
	class TransNameRowMapper3 implements ResultSetExtractor<Map<String, String>> {

		@Override
		public Map<String, String> extractData(ResultSet rs)
				throws SQLException, DataAccessException {
			Map<String, String> sectionNameMap = new LinkedHashMap<String, String>();
			while (rs.next()) {
				String key = (rs.getString("SECTION_ID"));
				String value = (rs.getString("SECTION"));
				sectionNameMap.put(key, value);
				System.out.println("section"+sectionNameMap);
			}
			return sectionNameMap;
		}
	}
	
	
	@Override
	public Map<String, String> getSubSectionName() throws NoDataFoundException{

		
		StringBuffer query = new StringBuffer()
		.append("select SUB_SECTION_ID,SUB_SECTION ").append("from sub_section ")
		.append("where del_flg='N';");
		logger.debug("Query:"+query.toString());
		Map<String, String> subSectionMap = null;
		
		subSectionMap = getJdbcTemplate().query(query.toString(),new TransNameRowMapper4());

		if (subSectionMap == null) {
			throw new NoDataFoundException();
		}
		return subSectionMap;
	}

	
	class TransNameRowMapper4 implements ResultSetExtractor<Map<String, String>> {

		@Override
		public Map<String, String> extractData(ResultSet rs)
				throws SQLException, DataAccessException {
			Map<String, String> transNameMap = new LinkedHashMap<String, String>();
			while (rs.next()) {
				String key = (rs.getString("SUB_SECTION_ID"));
				String value = (rs.getString("SUB_SECTION"));
				transNameMap.put(key, value);
			}
			return transNameMap;
		}
	}
	



}
