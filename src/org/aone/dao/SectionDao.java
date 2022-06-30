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
public class SectionDao extends BaseDao implements ISectionDao{
	@Autowired
	JdbcTemplate jdbcTemplate;
	// Logging
	Logger logger = Logger.getLogger(SectionDao.class);
	
	
	@Override
	public Map<String, String> getTransportName() throws NoDataFoundException{

		
		StringBuffer query = new StringBuffer()
		.append("select SECTOR_ID,SECTOR ").append("from sector ")
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
	public void updateTestDao(final Section section) throws UpdateFailedException {
		// TODO Auto-generated method stub
		StringBuffer query=new StringBuffer();
		query=query.append("update section set SECTION=?,R_MOD_TIME=now(),DB_TS=? where SECTION_ID=? and SECTOR=?;");
		int changerow=jdbcTemplate.update(query.toString(), new PreparedStatementSetter() {  
	            @Override 
	        public void setValues(PreparedStatement pss) throws SQLException{
	            	pss.setString(1,section.getSection());
	            	pss.setString(2,section.getDbTs());

	            	pss.setString(3,section.getSectionId());

	            	pss.setString(4,section.getSector());
	            	System.out.println("sysu:"+pss);
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
	public void insertSection(final Section section) throws UpdateFailedException, DuplicateEntryException {
		// TODO Auto-generated method stub
		StringBuffer query=new StringBuffer();
		 
		query=query.append("insert into section(SECTOR,SECTOR_ID,DB_TS,DEL_FLG,R_CRE_TIME,R_MOD_TIME,DATE_ADDED,SECTION_ID,SECTION)values(?,?,?,?,?,?,?,?,?)");
       try
       {
		jdbcTemplate.update(query.toString(), new PreparedStatementSetter() {

			@Override
			public void setValues(PreparedStatement pss)
					throws SQLException {
				// TODO Auto-generated method stub
				
				pss.setString(1,section.getSector());
            	pss.setString(2,section.getSectorTypeId());
            	pss.setString(3,section.getDbTs());
            	pss.setString(4,section.getDelFlg());
            	pss.setString(5, section.getrCreTime());
            	pss.setString(6, section.getrModTime());
            	pss.setString(7,section.getDateAdded());
            	pss.setString(8,section.getSectionId());
            	pss.setString(9,section.getSection());
        
            
            }
        	});
            }
            catch (DuplicateKeyException duplicateKeyException) {
	         throw new DuplicateEntryException();
             }
       
       
      }
	
	

	@Override
	public String getNextSectionId() {
		// TODO Auto-generated method stub

   		String sql = "select SECTION_ID from section order by SECTION_ID  desc limit 1";
        String sectionId = getJdbcTemplate().queryForObject(sql.toString(),
   				String.class);
   		return sectionId;
	}

	
	@Override
	public void deleteSectorData(final Section section) {
		// TODO Auto-generated method stub
		StringBuffer query=new StringBuffer();
		query=query.append("delete from section where SECTION_ID=? and DEL_FLG=? ");
		int changerow=jdbcTemplate.update(query.toString(), new PreparedStatementSetter() {  
	            @Override 
	        public void setValues(PreparedStatement pss) throws SQLException{
	            	pss.setString(1,section.getSectionId());
	            	pss.setString(2,"N");
                   System.out.println("pss"+pss);
	            
	            }
		});
		
	}



}
