<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
      <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
      <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<title>Login</title>


<form:form action="updateQuestion.htm" method="POST" commandName="updateQuestion">
 	${message}		
   sub section :
     <form:select path="questionVO.subSection">
            <form:option value="${subSection }">${subSection }</form:option>
	</form:select> 
		 question:<form:input type="text" 
						path="questionVO.question"  />
		 option1:<form:textarea 
						path="questionVO.option1"  /> 
		 option2:<form:textarea
						path="questionVO.option2"  /> 
		 option3:<form:textarea
						path="questionVO.option3"  /> 
		  option4:<form:textarea
						path="questionVO.option4"  />
		  answer:<form:input type="text" 
						path="questionVO.answer"  />
		<button type="submit">submit</button>
</form:form>
 