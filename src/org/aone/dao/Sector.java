package org.aone.dao;

import org.springframework.stereotype.Component;

@Component
public class Sector {

private String testTypeId;
private String testType;
private String dateAdded;
private String dbTs;
private String sectorTypeId;
private String  sector;

private String delFlg;
private String rCreTime;
private String rModTime;

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
public String getSectorTypeId() {
	return sectorTypeId;
}
public void setSectorTypeId(String sectorTypeId) {
	this.sectorTypeId = sectorTypeId;
}
public String getSector() {
	return sector;
}
public void setSector(String sector) {
	this.sector = sector;
}
@Override
public String toString() {
	return "Sector [testTypeId=" + testTypeId + ", testType=" + testType
			+ ", dateAdded=" + dateAdded + ", dbTs=" + dbTs + ", sectorTypeId="
			+ sectorTypeId + ", sector=" + sector + ", delFlg=" + delFlg
			+ ", rCreTime=" + rCreTime + ", rModTime=" + rModTime
			+ ", getDelFlg()=" + getDelFlg() + ", getTestTypeId()="
			+ getTestTypeId() + ", getTestType()=" + getTestType()
			+ ", getDateAdded()=" + getDateAdded() + ", getDbTs()=" + getDbTs()
			+ ", getSectorTypeId()=" + getSectorTypeId() + ", getSector()="
			+ getSector() + ", getrCreTime()=" + getrCreTime()
			+ ", getrModTime()=" + getrModTime() + ", getClass()=" + getClass()
			+ ", hashCode()=" + hashCode() + ", toString()=" + super.toString()
			+ "]";
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
