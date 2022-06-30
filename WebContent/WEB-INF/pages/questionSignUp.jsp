<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
      <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
      <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<title>Login</title>

<script src="js/question.js"></script>

<form:form action="questionSignUp.htm" method="POST" commandName="questionSignUp">
 	${message}		
         SubSection <form:select id="subSection" path="questionListVO.subSection">
			<form:option value="" selected="selected">--Select--</form:option>
			
			</form:select> 
  
		 question:<form:input type="text" 
						path="questionListVO.question"  />
		 option1:<form:textarea type="text" 
						path="questionListVO.option1"  /> 
		 option2:<form:input type="text" 
						path="questionListVO.option2"  /> 
		 option3:<form:input type="text" 
						path="questionListVO.option3"  /> 
		  option4:<form:input type="text" 
						path="questionListVO.option4"  />
		  answer:<form:input type="text" 
						path="questionListVO.answer"  />
		<button type="submit">submit</button>
</form:form>
 