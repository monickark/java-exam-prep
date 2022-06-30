package org.aone.dao;

import java.util.List;

import org.aone.common.exception.NoDataFoundException;




public interface ISectorListDao {

	public List<SectorList> selectSectorList(final SectorList testTpe)
			throws NoDataFoundException ;


}
