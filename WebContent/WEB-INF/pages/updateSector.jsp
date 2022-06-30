<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
      <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
      <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">


 <html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login</title>
</head>
<body>

<form:form action="updateSectors.htm" method="POST" commandName="updateSectors">
		
	Test Type:
	<form:select path="sectorVO.testType">
            <form:option value="${testType }">${testType }</form:option>
	</form:select>
		sector Type:<form:input type="text" path="sectorVO.sector"/>	
	
          	<button type="submit">submit</button>
</form:form>

 </body>
</html> 