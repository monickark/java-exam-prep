package org.aone.controller;

import org.springframework.stereotype.Component;

@Component
public class SectionMasterVO{
private SectionListVO sectionListVO;
private SectionVO sectionVO;
public SectionListVO getSectionListVO() {
	return sectionListVO;
}
public void setSectionListVO(SectionListVO sectionListVO) {
	this.sectionListVO = sectionListVO;
}
public SectionVO getSectionVO() {
	return sectionVO;
}
public void setSectionVO(SectionVO sectionVO) {
	this.sectionVO = sectionVO;
}
@Override
public String toString() {
	return "SectionMasterVO [sectionListVO=" + sectionListVO + ", sectionVO="
			+ sectionVO + ", getSectionListVO()=" + getSectionListVO()
			+ ", getSectionVO()=" + getSectionVO() + ", getClass()="
			+ getClass() + ", hashCode()=" + hashCode() + ", toString()="
			+ super.toString() + "]";
}

}