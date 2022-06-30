package org.aone.controller;

import org.springframework.stereotype.Component;

@Component
public class SubSectionVO{

private String sectionId;
private String section;
private String dateAdded;
private String subSection;
private String subSectionId;
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

public String getSubSection() {
	return subSection;
}
public void setSubSection(String subSection) {
	this.subSection = subSection;
}

public String getSubSectionId() {
	return subSectionId;
}
public void setSubSectionId(String subSectionId) {
	this.subSectionId = subSectionId;
}
@Override
public String toString() {
	return "SubSectionVO [sectionId=" + sectionId + ", section=" + section
			+ ", dateAdded=" + dateAdded + ", subSection=" + subSection
			+ ", subSectionId=" + subSectionId + ", getSectionId()="
			+ getSectionId() + ", getSection()=" + getSection()
			+ ", getDateAdded()=" + getDateAdded() + ", getSubSection()="
			+ getSubSection() + ", getSubSectionId()=" + getSubSectionId()
			+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
			+ ", toString()=" + super.toString() + "]";
}
}