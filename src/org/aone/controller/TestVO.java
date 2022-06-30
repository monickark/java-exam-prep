package org.aone.controller;

import org.springframework.stereotype.Component;

@Component
public class TestVO {

private String testId;
private String test;
private String testTypeId;
private String sector;
private String section;
private String subSection;
private String sectionId;
private String sectorId;
private String noofQuestions;
private String minutes;
private String rightAnswerMark;
private String wrongAnswerMark;
private String testType;
public String getTestId() {
	return testId;
}
public void setTestId(String testId) {
	this.testId = testId;
}
public String getTest() {
	return test;
}
public void setTest(String test) {
	this.test = test;
}
public String getTestTypeId() {
	return testTypeId;
}
public void setTestTypeId(String testTypeId) {
	this.testTypeId = testTypeId;
}
public String getSector() {
	return sector;
}
public void setSector(String sector) {
	this.sector = sector;
}
public String getSection() {
	return section;
}
public void setSection(String section) {
	this.section = section;
}
public String getSubSection() {
	return subSection;
}
public void setSubSection(String subSection) {
	this.subSection = subSection;
}
public String getSectionId() {
	return sectionId;
}
public void setSectionId(String sectionId) {
	this.sectionId = sectionId;
}
public String getSectorId() {
	return sectorId;
}
public void setSectorId(String sectorId) {
	this.sectorId = sectorId;
}
public String getNoofQuestions() {
	return noofQuestions;
}
public void setNoofQuestions(String noofQuestions) {
	this.noofQuestions = noofQuestions;
}
public String getMinutes() {
	return minutes;
}
public void setMinutes(String minutes) {
	this.minutes = minutes;
}
public String getRightAnswerMark() {
	return rightAnswerMark;
}
public void setRightAnswerMark(String rightAnswerMark) {
	this.rightAnswerMark = rightAnswerMark;
}
public String getWrongAnswerMark() {
	return wrongAnswerMark;
}
public void setWrongAnswerMark(String wrongAnswerMark) {
	this.wrongAnswerMark = wrongAnswerMark;
}
public String getTestType() {
	return testType;
}
public void setTestType(String testType) {
	this.testType = testType;
}
@Override
public String toString() {
	return "TestVO [testId=" + testId + ", test=" + test + ", testTypeId="
			+ testTypeId + ", sector=" + sector + ", section=" + section
			+ ", subSection=" + subSection + ", sectionId=" + sectionId
			+ ", sectorId=" + sectorId + ", noofQuestions=" + noofQuestions
			+ ", minutes=" + minutes + ", rightAnswerMark=" + rightAnswerMark
			+ ", wrongAnswerMark=" + wrongAnswerMark + ", testType=" + testType
			+ ", getTestId()=" + getTestId() + ", getTest()=" + getTest()
			+ ", getTestTypeId()=" + getTestTypeId() + ", getSector()="
			+ getSector() + ", getSection()=" + getSection()
			+ ", getSubSection()=" + getSubSection() + ", getSectionId()="
			+ getSectionId() + ", getSectorId()=" + getSectorId()
			+ ", getNoofQuestions()=" + getNoofQuestions() + ", getMinutes()="
			+ getMinutes() + ", getRightAnswerMark()=" + getRightAnswerMark()
			+ ", getWrongAnswerMark()=" + getWrongAnswerMark()
			+ ", getTestType()=" + getTestType() + ", getClass()=" + getClass()
			+ ", hashCode()=" + hashCode() + ", toString()=" + super.toString()
			+ "]";
}


 

}
