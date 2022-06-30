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
public class SectorDao extends BaseDao implements ISectorDao {
	@Autowired
	JdbcTemplate jdbcTemplate;
	// Logging
	Logger logger = Logger.getLogger(SectorDao.class);
	@Override
	public Map<String, String> getTestType() throws NoDataFoundException{

		
		StringBuffer query = new StringBuffer()
		.append("select TEST_TYPE_ID,TEST_TYPE ").append("from test ")
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
				String key = (rs.getString("TEST_TYPE_ID"));
				String value = (rs.getString("TEST_TYPE"));
				transNameMap.put(key, value);
				System.out.println("tra"+transNameMap);
			}
			return transNameMap;
		}
	}
	
	
	
	
	
	@Override
	public void insertSector(final Sector sector) throws UpdateFailedException, DuplicateEntryException {
		// TODO Auto-generated method stub
		StringBuffer query=new StringBuffer();
		 
		query=query.append("insert into sector(TEST_TYPE,TEST_TYPE_ID,DB_TS,DEL_FLG,R_CRE_TIME,R_MOD_TIME,DATE_ADDED,SECTOR_ID,SECTOR)values(?,?,?,?,?,?,?,?,?)");
       try
       {
		jdbcTemplate.update(query.toString(), new PreparedStatementSetter() {

			@Override
			public void setValues(PreparedStatement pss)
					throws SQLException {
				// TODO Auto-generated method stub
				
				pss.setString(1,sector.getTestType());
            	pss.setString(2,sector.getTestTypeId());
            	pss.setString(3,sector.getDbTs());
            	pss.setString(4,sector.getDelFlg());
            	pss.setString(5, sector.getrCreTime());
            	pss.setString(6,sector.getrModTime());
            	pss.setString(7,sector.getDateAdded());
            	pss.setString(8,sector.getSectorTypeId());
            	pss.setString(9,sector.getSector());
            }
        	});
            }
            catch (DuplicateKeyException duplicateKeyException) {
	         throw new DuplicateEntryException();
             }
       
       
      }
	
	

	@Override
	public String getNextSectorId() {
		// TODO Auto-generated method stub

   		String sql = "select SECTOR_ID from sector order by SECTOR_ID  desc limit 1";
        

   		String sectorId = getJdbcTemplate().queryForObject(sql.toString(),
   				String.class);
   	
		return sectorId;
	}

	@Override
	public void updateSector(final Sector sector) throws UpdateFailedException {
		// TODO Auto-generated method stub
		StringBuffer query=new StringBuffer();
		query=query.append("update sector set SECTOR=?,R_MOD_TIME=?,DB_TS=? where SECTOR_ID=? and TEST_TYPE=?;");
		int changerow=jdbcTemplate.update(query.toString(), new PreparedStatementSetter() {  
	            @Override 
	        public void setValues(PreparedStatement pss) throws SQLException{
	            	pss.setString(1,sector.getSector());
	            	pss.setString(2,sector.getrModTime());
	            	pss.setString(3,sector.getDbTs());
	            	pss.setString(4,sector.getSectorTypeId());
                    pss.setString(5,sector.getTestType());
	            	System.out.println("pss"+pss);
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
	public void deleteSector(final Sector sector) {
		// TODO Auto-generated method stub
		StringBuffer query=new StringBuffer();
		query=query.append("delete from sector where SECTOR_ID=? and DEL_FLG=? ");

		int changerow=jdbcTemplate.update(query.toString(), new PreparedStatementSetter() {  
	            @Override 
	        public void setValues(PreparedStatement pss) throws SQLException{
	            	pss.setString(1,sector.getSectorTypeId());
	            	pss.setString(2,"N");
                   System.out.println("pss"+pss);
	            
	            }
		});
		
	}
	
	
	


}
