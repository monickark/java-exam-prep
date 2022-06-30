package org.aone.service;

import java.util.List;
import java.util.Map;

import org.aone.common.exception.DuplicateEntryException;
import org.aone.common.exception.NoDataFoundException;
import org.aone.common.exception.UpdateFailedException;
import org.aone.controller.SubSectionListVO;
import org.aone.controller.SubSectionVO;
import org.aone.controller.TestTypeVO;




public interface ISubSectionService {

	void deleteSubSection(SubSectionVO subSectionVO);
	
	public List<SubSectionListVO> selectSubSectionList(SubSectionListVO subSectionListVO) throws NoDataFoundException;

	public Map<String, SubSectionListVO> listToMap(List<SubSectionListVO> subSectionListVOs);


	public void editSubSection(SubSectionVO subSectionVO)throws UpdateFailedException;
	public String getDbTs();

	public Map<String, String> getSectionName()
			throws NoDataFoundException;

    public void insertSubSection(SubSectionVO  subSectionVO) throws UpdateFailedException, DuplicateEntryException ;

    public String getNextSubSection() ;
}
