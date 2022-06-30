package org.aone.dao;

import org.springframework.stereotype.Component;

@Component
public class Question{

private String sectionId;
private String section;
private String dateAdded;
private String dbTs;
private String subSection;
private String delFlg;
private String subSectionId;

private String questionId;
private String question;
private String option1;
private String option2;
private String option3;
private String option4;
private String answer;
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
	return "Question [sectionId=" + sectionId + ", section=" + section
			+ ", dateAdded=" + dateAdded + ", dbTs=" + dbTs + ", subSection="
			+ subSection + ", delFlg=" + delFlg + ", subSectionId="
			+ subSectionId + ", questionId=" + questionId + ", question="
			+ question + ", option1=" + option1 + ", option2=" + option2
			+ ", option3=" + option3 + ", option4=" + option4 + ", answer="
			+ answer + ", rCreTime=" + rCreTime + ", rModTime=" + rModTime
			+ ", getSectionId()=" + getSectionId() + ", getSection()="
			+ getSection() + ", getDateAdded()=" + getDateAdded()
			+ ", getDbTs()=" + getDbTs() + ", getSubSection()="
			+ getSubSection() + ", getDelFlg()=" + getDelFlg()
			+ ", getSubSectionId()=" + getSubSectionId() + ", getQuestionId()="
			+ getQuestionId() + ", getQuestion()=" + getQuestion()
			+ ", getOption1()=" + getOption1() + ", getOption2()="
			+ getOption2() + ", getOption3()=" + getOption3()
			+ ", getOption4()=" + getOption4() + ", getAnswer()=" + getAnswer()
			+ ", getrCreTime()=" + getrCreTime() + ", getrModTime()="
			+ getrModTime() + ", getClass()=" + getClass() + ", hashCode()="
			+ hashCode() + ", toString()=" + super.toString() + "]";
}
public String getQuestionId() {
	return questionId;
}
public void setQuestionId(String questionId) {
	this.questionId = questionId;
}
public String getQuestion() {
	return question;
}
public void setQuestion(String question) {
	this.question = question;
}
public String getOption1() {
	return option1;
}
public void setOption1(String option1) {
	this.option1 = option1;
}
public String getOption2() {
	return option2;
}
public void setOption2(String option2) {
	this.option2 = option2;
}
public String getOption3() {
	return option3;
}
public void setOption3(String option3) {
	this.option3 = option3;
}
public String getOption4() {
	return option4;
}
public void setOption4(String option4) {
	this.option4 = option4;
}
public String getAnswer() {
	return answer;
}
public void setAnswer(String answer) {
	this.answer = answer;
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