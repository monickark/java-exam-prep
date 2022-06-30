package org.aone.controller;

import org.springframework.stereotype.Component;

@Component
public class QuestionVO{

private String sectionId;
private String section;
private String dateAdded;
private String subSection;
private String subSectionId;
private String questionId;
private String question;
private String option1;
private String option2;
private String option3;
private String option4;
private String answer;
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
	return "QuestionVO [sectionId=" + sectionId + ", section=" + section
			+ ", dateAdded=" + dateAdded + ", subSection=" + subSection
			+ ", subSectionId=" + subSectionId + ", questionId=" + questionId
			+ ", question=" + question + ", option1=" + option1 + ", option2="
			+ option2 + ", option3=" + option3 + ", option4=" + option4
			+ ", answer=" + answer + "]";
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
}