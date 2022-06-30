package org.aone.controller;

public class SectorMasterVO {
private SectorListVO sectorListVO;
private SectorVO sectorVO;
public SectorListVO getSectorListVO() {
	return sectorListVO;
}
public void setSectorListVO(SectorListVO sectorListVO) {
	this.sectorListVO = sectorListVO;
}
public SectorVO getSectorVO() {
	return sectorVO;
}
public void setSectorVO(SectorVO sectorVO) {
	this.sectorVO = sectorVO;
}
@Override
public String toString() {
	return "SectorMasterVO [sectorListVO=" + sectorListVO + ", sectorVO="
			+ sectorVO + ", getSectorListVO()=" + getSectorListVO()
			+ ", getSectorVO()=" + getSectorVO() + ", getClass()=" + getClass()
			+ ", hashCode()=" + hashCode() + ", toString()=" + super.toString()
			+ "]";
}



}
