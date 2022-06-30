package org.aone.dao;

import java.util.List;

import org.aone.common.exception.NoDataFoundException;




public interface ISectionListDao {

	public List<SectionList> getTestListfromDb(final SectionList testTpe)
			throws NoDataFoundException ;
	

}
