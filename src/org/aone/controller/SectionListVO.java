package org.aone.controller;

import org.springframework.stereotype.Component;

@Component
public class SectionListVO{

private String sectionId;
private String section;
private String dateAdded;
private String dbTs;
private String sectorTypeId;
private String delFlg;
private String sector;
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
public String getSectorTypeId() {
	return sectorTypeId;
}
public void setSectorTypeId(String sectorTypeId) {
	this.sectorTypeId = sectorTypeId;
}

public String getDelFlg() {
	return delFlg;
}
public void setDelFlg(String delFlg) {
	this.delFlg = delFlg;

}
public String getSector() {
	return sector;
}
public void setSector(String sector) {
	this.sector = sector;
}
@Override
public String toString() {
	return "Section [sectionId=" + sectionId + ", section=" + section
			+ ", dateAdded=" + dateAdded + ", dbTs=" + dbTs + ", sectorTypeId="
			+ sectorTypeId + ", delFlg=" + delFlg + ", sector=" + sector
			+ ", getSectionId()=" + getSectionId() + ", getSection()="
			+ getSection() + ", getDateAdded()=" + getDateAdded()
			+ ", getDbTs()=" + getDbTs() + ", getSectorTypeId()="
			+ getSectorTypeId() + ", getDelFlg()=" + getDelFlg()
			+ ", getSector()=" + getSector() + ", getClass()=" + getClass()
			+ ", hashCode()=" + hashCode() + ", toString()=" + super.toString()
			+ "]";
}

}