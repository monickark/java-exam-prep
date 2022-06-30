<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
      <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
      <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<title>Login</title>
<script src="js/subSection.js"></script>


<form:form action="subSectionSignUp.htm" method="POST" commandName="subSectionSignUp">
 	${message}		
<%-- <form:select path="testType" value="testType"  id="testType">
 --%>


section : <form:select id="section" path="subSectionListVO.section">
			<form:option value="" selected="selected">--Select--</form:option>
			
			</form:select> 

<%-- section :         <form:select path="subSectionListVO.section">
			<form:option value="" selected="selected">--Select--</form:option>
			<c:forEach items="${subsSectionVOs}" var="subsSectionVOs"  >
            <form:option value="${subsSectionVOs.section }">${subsSectionVOs.section }</form:option>
           </c:forEach>		
		 </form:select>   --%>
		 subSection:<form:input type="text" 
						path="subSectionListVO.subSection"  />
		<button type="submit">submit</button>
</form:form>
 