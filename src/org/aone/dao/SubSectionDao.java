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
public class SubSectionDao extends BaseDao implements ISubSectionDao{
	@Autowired
	JdbcTemplate jdbcTemplate;
	// Logging
	Logger logger = Logger.getLogger(SubSectionDao.class);
	
	
	@Override
	public Map<String, String> mapSectionId() throws NoDataFoundException{

		
		StringBuffer query = new StringBuffer()
		.append("select SECTION_ID,SECTION ").append("from section ")
		.append("where del_flg='N'");
		logger.debug("Query:"+query.toString());
		Map<String, String> map = null;
		
		map = getJdbcTemplate().query(query.toString(),new TransNameRowMapper());

		if (map == null) {
			throw new NoDataFoundException();
		}
		return map;
	}

	
	class TransNameRowMapper implements ResultSetExtractor<Map<String, String>> {

		@Override
		public Map<String, String> extractData(ResultSet rs)
				throws SQLException, DataAccessException {
			Map<String, String> transNameMap = new LinkedHashMap<String, String>();
			while (rs.next()) {
				String key = (rs.getString("SECTION_ID"));
				String value = (rs.getString("SECTION"));
				transNameMap.put(key, value);
			}
			System.out.println("mao"+transNameMap);
			return transNameMap;
		}
	}
	

	
	
	@Override
	public void insertSubSection(final SubSection subSection) throws UpdateFailedException, DuplicateEntryException {
		// TODO Auto-generated method stub
		StringBuffer query=new StringBuffer();
		 System.out.println("section id"+subSection.getSectionId());
		query=query.append("insert into sub_section(SUB_SECTION,SUB_SECTION_ID,DB_TS,DEL_FLG,R_CRE_TIME,R_MOD_TIME,DATE_ADDED,SECTION_ID,SECTION)values(?,?,?,?,?,?,?,?,?)");
      System.out.println("subsectiondao"+subSection.getSectionId());
		try
       {
		jdbcTemplate.update(query.toString(), new PreparedStatementSetter() {

			@Override
			public void setValues(PreparedStatement pss)
					throws SQLException {
				// TODO Auto-generated method stub
				
				pss.setString(1,subSection.getSubSection());
            	pss.setString(2,subSection.getSubSectionId());
            	pss.setString(3,subSection.getDbTs());
            	pss.setString(4,subSection.getDelFlg());
            	pss.setString(5, subSection.getrCreTime());
            	pss.setString(6, subSection.getrModTime());
            	pss.setString(7,subSection.getDateAdded());
            	pss.setString(8,subSection.getSectionId());
            	pss.setString(9,subSection.getSection());
            
            }
        	});
            }
            catch (DuplicateKeyException duplicateKeyException) {
	         throw new DuplicateEntryException();
             }
       
       
      }
	
	

	@Override
	public String getNextSubSectionId() {
		// TODO Auto-generated method stub

   		String sql = "select SUB_SECTION_ID from sub_section order by SUB_SECTION_ID  desc limit 1";
        
   		System.out.println(sql);

   		String subSection = getJdbcTemplate().queryForObject(sql.toString(),
   				String.class);
   		System.out.println(subSection);
   		
		return subSection;
	}


	@Override
	public void editSubSection(final SubSection subSection) throws UpdateFailedException {
		// TODO Auto-generated method stub
		StringBuffer query=new StringBuffer();
		query=query.append("update sub_section set SUB_SECTION=?,R_MOD_TIME=?,DB_TS=? where SUB_SECTION_ID=? and SECTION=?;");
		int changerow=jdbcTemplate.update(query.toString(), new PreparedStatementSetter() {  
	            @Override 
	        public void setValues(PreparedStatement pss) throws SQLException{
	            	pss.setString(1,subSection.getSubSection());
	            	pss.setString(2,subSection.getrModTime());
	            	pss.setString(3,subSection.getDbTs());
	            	pss.setString(4,subSection.getSubSectionId());
	            	pss.setString(5,subSection.getSection());
	            	System.out.println(pss);
	            }
		});
		
	}

	

	@Override
	public String getDbTs() {
		// TODO Auto-generated method stub

   		String sql = "select DB_TS+1 from sub_section order by DB_TS  desc limit 1";

   		String db_Ts = getJdbcTemplate().queryForObject(sql.toString(),
   				String.class);
	
		return db_Ts;
	}

	public void deleteSubSection(final SubSection subSection) {
		// TODO Auto-generated method stub
		StringBuffer query=new StringBuffer();
		query=query.append("delete from sub_section where SUB_SECTION_ID=? and DEL_FLG=? ");
		int changerow=jdbcTemplate.update(query.toString(), new PreparedStatementSetter() {  
	            @Override 
	        public void setValues(PreparedStatement pss) throws SQLException{
	            	pss.setString(1,subSection.getSubSectionId());
	            	pss.setString(2,"N");
                   System.out.println("pss"+pss);
	            
	            }
		});
		
	}
}

	
	



