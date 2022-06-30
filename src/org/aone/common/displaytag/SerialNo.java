package org.aone.common.displaytag;


import org.displaytag.decorator.TableDecorator;



public class SerialNo  extends TableDecorator{
	
	 public Integer getSerialNo() {
			return getListIndex()+1;
		    }
	 
	 
	
}
