<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Adminstration</title>
</head>
<body>
<form:form action="login.htm" method="POST" commandName="login">
Name:<form:input type="text" path="username"/>
Password:<form:input type="password" path="password"/>
<button type="submit">Login</button>
${success }
${fail }
${name}
</form:form>
</body>
</html>