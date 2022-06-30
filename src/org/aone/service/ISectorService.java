package org.aone.service;

import java.util.List;
import java.util.Map;

import org.aone.common.exception.DuplicateEntryException;
import org.aone.common.exception.NoDataFoundException;
import org.aone.common.exception.UpdateFailedException;
import org.aone.controller.SectorListVO;
import org.aone.controller.SectorVO;
import org.aone.controller.TestTypeVO;



public interface ISectorService {
	public Map<String, String> getName()
			throws NoDataFoundException;

	void insertSector(SectorVO sectorVO) throws UpdateFailedException,
			DuplicateEntryException;
	
	public String getNextSectorId();

	
	void deleteSector(SectorVO sectorVO);
	
	public Map<String, SectorListVO> listToMap(List<SectorListVO> sectorListVO);
	  
	public List<SectorListVO> selectSectorList(SectorListVO sectorListVO) throws NoDataFoundException;
	  
	public void editSector(SectorVO sectorVO)throws UpdateFailedException;
}
