package org.aone.dao;



import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.aone.common.exception.NoDataFoundException;
import org.apache.log4j.Logger;
import org.dao.BaseDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;

import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Repository;



@Repository
public class SectionListDao extends BaseDao implements ISectionListDao {
	@Autowired
	JdbcTemplate jdbcTemplate;
	// Logging
	Logger logger = Logger.getLogger(SectionListDao.class);
	public List<SectionList> getTestListfromDb(final SectionList sectionList)
			throws NoDataFoundException {
		List<SectionList> sectionLists = new ArrayList<SectionList>();

		StringBuffer sql = new StringBuffer()
	
		.append("select SECTION,SECTOR,DATE_ADDED,SECTION_ID from section; ");
		sectionLists = (List<SectionList>)jdbcTemplate.query(
				sql.toString(),  new TestDataSet());
		
		return sectionLists;
	}

	@SuppressWarnings("rawtypes")
	class TestDataSet implements ResultSetExtractor {
		@Override
		public List<SectionList> extractData(ResultSet resultSet)
				throws SQLException, DataAccessException {
			List<SectionList> sectionLists = new ArrayList<SectionList>();
			while (resultSet.next()) {
				SectionList sectionList =new SectionList();
				sectionList.setSection(resultSet.getString("SECTION"));
				sectionList.setSector(resultSet.getString("SECTOR"));
				sectionList.setDateAdded(resultSet.getString("DATE_ADDED"));
				sectionList.setSectionId(resultSet.getString("SECTION_ID"));

                sectionLists.add(sectionList);
			}
			return sectionLists;
		}

	}
	
	

	



	
}