<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
      <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
      <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<title>Login</title>

<script src="js/section.js"></script>

<form:form action="sectionSignUp.htm" method="POST" commandName="sectionSignUp">
 	${message}		
sector : <form:select id="sector" path="sectionListVO.sector">
			<form:option value="" selected="selected">--Select--</form:option>
			
			</form:select> 


		  Section:<form:input type="text" 
						path="sectionListVO.section"  />
		<button type="submit">submit</button>
</form:form>
 