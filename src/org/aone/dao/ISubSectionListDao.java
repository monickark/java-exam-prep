package org.aone.dao;

import java.util.List;

import org.aone.common.exception.NoDataFoundException;




public interface ISubSectionListDao {

	public List<SubSectionList> selectSubSectionList(final SubSectionList testTpe)
			throws NoDataFoundException ;

}
