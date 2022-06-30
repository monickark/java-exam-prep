package org.aone.controller;

import org.springframework.stereotype.Component;

@Component
public class SectorVO {

private String testTypeId;
private String testType;
private String dbTs;
private String sectorTypeId;
private String  sector;
private int sno;
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
 int getSno() {
	return sno;
}
public void setSno(int sno) {
	this.sno = sno;
}
@Override
public String toString() {
	return "SectorVO [testTypeId=" + testTypeId + ", testType=" + testType
			+ ", dbTs=" + dbTs + ", sectorTypeId=" + sectorTypeId + ", sector="
			+ sector + ", sno=" + sno + ", delFlg=" + delFlg + ", getDelFlg()="
			+ getDelFlg() + ", getTestTypeId()=" + getTestTypeId()
			+ ", getTestType()=" + getTestType() + ", getDbTs()=" + getDbTs()
			+ ", getSectorTypeId()=" + getSectorTypeId() + ", getSector()="
			+ getSector() + ", getSno()=" + getSno() + ", getClass()="
			+ getClass() + ", hashCode()=" + hashCode() + ", toString()="
			+ super.toString() + "]";
}
}
