package org.aone.service;

import java.util.List;
import java.util.Map;

import org.aone.common.exception.DuplicateEntryException;
import org.aone.common.exception.NoDataFoundException;
import org.aone.common.exception.UpdateFailedException;
import org.aone.controller.SectionListVO;
import org.aone.controller.SectionVO;
import org.aone.controller.SectorListVO;
import org.aone.controller.TestTypeVO;




public interface ISectionService {
	public Map<String, String> getName()
			throws NoDataFoundException;

	void insertSection(SectionVO sectionVO) throws UpdateFailedException,
			DuplicateEntryException;
	public String getNextSectionId();

	

	void deleteSection(SectionVO sectionVO);
	
	public void updateSection(SectionVO sectionVO)throws UpdateFailedException;
	
	public String getDbTs();
	
	public List<SectionListVO> selectSectionList(SectionListVO sectionListVO) throws NoDataFoundException;
	
	public Map<String, SectionListVO> listToMap(List<SectionListVO> sectorVOs);


}
