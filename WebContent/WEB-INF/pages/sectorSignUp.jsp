<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
      <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
      <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<title>Login</title>
<script src="js/testtype.js"></script>


<form:form action="sectorSignUp.htm" method="POST" commandName="sectorSignUp">
 	${message}		

          test Type
		 <form:select id="testType" path="sectorListVO.testType">
			<form:option value="" selected="selected">--Select--</form:option>
			
			</form:select>
		  Sector:<form:input type="text" 
						path="sectorListVO.sector"  />
		<button type="submit">submit</button>
</form:form>
 