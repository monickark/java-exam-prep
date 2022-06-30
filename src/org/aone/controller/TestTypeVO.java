package org.aone.controller;

import org.springframework.stereotype.Component;

@Component
public class TestTypeVO {

private String testTypeId;
private String testType;

 public String getTestTypeId() {
	return testTypeId;
}
public void setTestTypeId(String testTypeId) {
	this.testTypeId = testTypeId;
}

public String getTestType() {
	return testType;
}
public void setTestType(String testType) {
	this.testType = testType;
}

@Override
public String toString() {
	return "TestTypeVO [testTypeId=" + testTypeId + ", testType=" + testType
			+ ", getTestTypeId()=" + getTestTypeId() + ", getTestType()="
			+ getTestType() + ", getClass()=" + getClass() + ", hashCode()="
			+ hashCode() + ", toString()=" + super.toString() + "]";
}
	

}
