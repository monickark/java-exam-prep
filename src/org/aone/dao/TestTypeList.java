package org.aone.dao;

import org.springframework.stereotype.Component;

@Component
public class TestTypeList {

private String testTypeId;
private String testType;
private String dateAdded;
private String dbTs;

private String delFlg;


public String getDelFlg() {
	return delFlg;
}
public void setDelFlg(String delFlg) {
	this.delFlg = delFlg;
}
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
public String getDbTs() {
	return dbTs;
}
public void setDbTs(String dbTs) {
	this.dbTs = dbTs;
}
@Override
public String toString() {
	return "TestTypeList [testTypeId=" + testTypeId + ", testType=" + testType
			+ ", dateAdded=" + dateAdded + ", dbTs=" + dbTs + ", delFlg="
			+ delFlg + "]";
}

}
