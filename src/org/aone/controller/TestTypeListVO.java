package org.aone.controller;

import org.springframework.stereotype.Component;

@Component
public class TestTypeListVO {

private String testTypeId;
private String testType;
private String dateAdded;

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
public String getDateAdded() {
	return dateAdded;
}
public void setDateAdded(String dateAdded) {
	this.dateAdded = dateAdded;
}

@Override
public String toString() {
	return "TestTypeVO [testTypeId=" + testTypeId + ", testType="
			+ testType + ", dateAdded=" + dateAdded + ", getTestTypeId()="
			+ getTestTypeId() + ", getTestType()=" + getTestType()
			+ ", getDateAdded()=" + getDateAdded() + ", getClass()="
			+ getClass() + ", hashCode()=" + hashCode() + ", toString()="
			+ super.toString() + "]";
}
	

}
