package org.aone.dao;

import org.springframework.stereotype.Component;

@Component
public class SubSection{

private String sectionId;
private String section;
private String dateAdded;
private String dbTs;
private String subSection;
private String delFlg;
private String subSectionId;
private String rCreTime;
private String rModTime;
public String getSectionId() {
	return sectionId;
}
public void setSectionId(String sectionId) {
	this.sectionId = sectionId;
}
public String getSection() {
	return section;
}
public void setSection(String section) {
	this.section = section;
}
public String getDateAdded() {
	return dateAdded;
}
public void setDateAdded(String dateAdded) {
	this.dateAdded = dateAdded;
}
public String getDbTs() {
	return dbTs;
}
public void setDbTs(String dbTs) {
	this.dbTs = dbTs;
}
public String getSubSection() {
	return subSection;
}
public void setSubSection(String subSection) {
	this.subSection = subSection;
}
public String getDelFlg() {
	return delFlg;
}
public void setDelFlg(String delFlg) {
	this.delFlg = delFlg;
}
public String getSubSectionId() {
	return subSectionId;
}
public void setSubSectionId(String subSectionId) {
	this.subSectionId = subSectionId;
}
@Override
public String toString() {
	return "SubSection [sectionId=" + sectionId + ", section=" + section
			+ ", dateAdded=" + dateAdded + ", dbTs=" + dbTs + ", subSection="
			+ subSection + ", delFlg=" + delFlg + ", subSectionId="
			+ subSectionId + ", rCreTime=" + rCreTime + ", rModTime="
			+ rModTime + ", getSectionId()=" + getSectionId()
			+ ", getSection()=" + getSection() + ", getDateAdded()="
			+ getDateAdded() + ", getDbTs()=" + getDbTs()
			+ ", getSubSection()=" + getSubSection() + ", getDelFlg()="
			+ getDelFlg() + ", getSubSectionId()=" + getSubSectionId()
			+ ", getrCreTime()=" + getrCreTime() + ", getrModTime()="
			+ getrModTime() + ", getClass()=" + getClass() + ", hashCode()="
			+ hashCode() + ", toString()=" + super.toString() + "]";
}
public String getrCreTime() {
	return rCreTime;
}
public void setrCreTime(String rCreTime) {
	this.rCreTime = rCreTime;
}
public String getrModTime() {
	return rModTime;
}
public void setrModTime(String rModTime) {
	this.rModTime = rModTime;
}
}