package org.aone.common.displaytag;


import org.aone.controller.TestVO;
import org.displaytag.decorator.TableDecorator;



public class TestSetup  extends TableDecorator{
	
	
	 
	 public String getNoofQuestions() {
            TestVO testVO = (TestVO) getCurrentRowObject();

			StringBuffer buffer = new StringBuffer();
			buffer.append("<input type=\"text\" name=\"noofQuestions\"  value=\"");
			buffer.append(testVO.getNoofQuestions());

			buffer.append("\"");
			buffer.append("/>");
			
System.out.println("buffer"+buffer);
			return buffer.toString();
	 }
	 
	 public String getMinutes() {
		 TestVO testVO = (TestVO) getCurrentRowObject();

		 StringBuffer buffer = new StringBuffer();
		 buffer.append("<input type=\"text\" name=\"minutes\"  value=\"");
		 buffer.append(testVO.getMinutes());
         buffer.append("\"");
	     buffer.append("/>");
	     System.out.println("buffer"+buffer);

    return buffer.toString();
    }
	
	 public String getrightAnswerMark() {
         TestVO testVO = (TestVO) getCurrentRowObject();

         StringBuffer buffer = new StringBuffer();
         buffer.append("<input type=\"text\" name=\"rightAnswerMark\"  value=\"");
         buffer.append(testVO.getRightAnswerMark());
         buffer.append("\"");
         buffer.append("/>");
	
         System.out.println("buffer"+buffer);

	return buffer.toString();
    }
	 
	public String getwrongAnswerMark() {
         TestVO testVO = (TestVO) getCurrentRowObject();

	      StringBuffer buffer = new StringBuffer();
	      buffer.append("<input type=\"text\" name=\"wrongAnswerMark\"  value=\"");
	      buffer.append(testVO.getWrongAnswerMark());
       	  buffer.append("\"");
	      buffer.append("/>");
	      System.out.println("buffer"+buffer);

    return buffer.toString();
    }
}
