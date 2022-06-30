<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
      <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
      <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
       <%@page import="org.aone.common.displaytag.TestSetup"%>
       <%@ taglib uri="http://displaytag.sf.net" prefix="display"%>
<title>Login</title>

<script src="js/test.js"></script>
<jsp:directive.page import="org.aone.common.displaytag.*" />
<jsp:scriptlet>
	<![CDATA[TestSetup decorator = new TestSetup();
			pageContext.setAttribute("testSetup", decorator);]]>
</jsp:scriptlet>

<form:form action="insertTest.htm" method="POST" commandName="insertTest">
 	${message}		
 		Test :<form:input type="text" path="test"/>	
 	   Test type : <form:select id="testType" path="testType">
			<form:option value="" selected="selected">--Select--</form:option>
             </form:select> 
             
             
            sector : <form:select id="sector" path="sector">
			<form:option value="" selected="selected">--Select--</form:option>
			<input type="hidden" value="${sector}"
										id="sectorName" />
								<div class="errors"></div>
			</form:select> 
			
			    
       <%-- sector : <form:select id="section" path="section">
			<form:option value="" selected="selected">--Select--</form:option>
			<input type="hidden" value="${section}"
										id="sectionName" />
								<div class="errors"></div>
			</form:select>  --%>
           <br>
				Section:<div id="section"></div>
				
			 <%-- <display:table id="list" requestURI="insertTest.htm"  name="sessionScope.sectionName" decorator="testSetup"  sort="list">
			   <display:setProperty name="basic.msg.empty_list" value="" />
				
				<display:column>
		         <input type="text" value="${section}"
										id="sectionName" />
				</display:column>
   	          	<display:column property="noofQuestions" title="No Of Question" style="width:40px" />
   	            <display:column property="minutes" title="Minutes" style="width:40px" />
   	            <display:column property="rightAnswerMark" title="Right Answer Mark" style="width:40px" />
   	           <display:column property="wrongAnswerMark" title="Wrong Answer Mark" style="width:40px" />
   	           </display:table> --%>  
</form:form>
 