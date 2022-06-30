package org.aone.controller;

import org.springframework.stereotype.Component;

@Component
public class QuestionMasterVO{
private QuestionListVO questionListVO;
private QuestionVO questionVO;
public QuestionListVO getQuestionListVO() {
	return questionListVO;
}
public void setQuestionListVO(QuestionListVO questionListVO) {
	this.questionListVO = questionListVO;
}
public QuestionVO getQuestionVO() {
	return questionVO;
}
public void setQuestionVO(QuestionVO questionVO) {
	this.questionVO = questionVO;
}
@Override
public String toString() {
	return "QuesrtionMasterVO [questionListVO=" + questionListVO
			+ ", questionVO=" + questionVO + ", getQuestionListVO()="
			+ getQuestionListVO() + ", getQuestionVO()=" + getQuestionVO()
			+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
			+ ", toString()=" + super.toString() + "]";
}
}