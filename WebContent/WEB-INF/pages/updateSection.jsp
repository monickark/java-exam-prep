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

<form:form action="updateSection.htm" method="POST" commandName="updateSection">
		
sector <form:select path="sectionVO.sector">
            <form:option value="${sector }">${sector }</form:option>
	</form:select>
		  section:<form:input type="text" 
						path="sectionVO.section"  />
	
          	<button type="submit">submit</button>
</form:form>

 </body>
</html> 