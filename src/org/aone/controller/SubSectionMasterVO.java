package org.aone.controller;

import org.springframework.stereotype.Component;

@Component
public class SubSectionMasterVO{
private SubSectionListVO subSectionListVO;
private SubSectionVO subSectionVO;
public SubSectionListVO getSubSectionListVO() {
	return subSectionListVO;
}
public void setSubSectionListVO(SubSectionListVO subSectionListVO) {
	this.subSectionListVO = subSectionListVO;
}
public SubSectionVO getSubSectionVO() {
	return subSectionVO;
}
public void setSubSectionVO(SubSectionVO subSectionVO) {
	this.subSectionVO = subSectionVO;
}
@Override
public String toString() {
	return "SubSectionMasterVO [subSectionListVO=" + subSectionListVO
			+ ", subSectionVO=" + subSectionVO + ", getSubSectionListVO()="
			+ getSubSectionListVO() + ", getSubSectionVO()="
			+ getSubSectionVO() + ", getClass()=" + getClass()
			+ ", hashCode()=" + hashCode() + ", toString()=" + super.toString()
			+ "]";
}


}