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
public class SubSectionListDao extends BaseDao implements ISubSectionListDao {
	@Autowired
	JdbcTemplate jdbcTemplate;
	// Logging
	Logger logger = Logger.getLogger(SubSectionListDao.class);
	
	

	public List<SubSectionList> selectSubSectionList(final SubSectionList subSection)
			throws NoDataFoundException {
		List<SubSectionList> subSections = new ArrayList<SubSectionList>();

		StringBuffer sql = new StringBuffer()
	
		.append("select SECTION,SUB_SECTION,DATE_ADDED,SUB_SECTION_ID from sub_section; ");
		subSections = (List<SubSectionList>)jdbcTemplate.query(
				sql.toString(),  new TestDataSet());
		
		return subSections;
	}

	@SuppressWarnings("rawtypes")
	class TestDataSet implements ResultSetExtractor {
		@Override
		public List<SubSectionList> extractData(ResultSet resultSet)
				throws SQLException, DataAccessException {
			List<SubSectionList> subSections = new ArrayList<SubSectionList>();
			while (resultSet.next()) {
				SubSectionList subSection =new SubSectionList();
				subSection.setSection(resultSet.getString("SECTION"));
				subSection.setSubSection(resultSet.getString("SUB_SECTION"));
				subSection.setDateAdded(resultSet.getString("DATE_ADDED"));
				subSection.setSubSectionId(resultSet.getString("SUB_SECTION_ID"));

                subSections.add(subSection);
			}
			return subSections;
		}

	}

	
}