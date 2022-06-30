	<!doctype html>
	
	<%@page import="org.aone.common.displaytag.SerialNo"%>
<%@ taglib uri="http://displaytag.sf.net" prefix="display"%>

<div class="content-wrapper" style="min-height: 379px;">
	<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<script type="text/javascript" src="valid-js/jquery.dataTables.min.js"></script>
<script type="text/javascript" src="valid-js/jquery-2.2.0.min.js"></script>

<jsp:directive.page import="org.aone.common.displaytag.*" />
<jsp:scriptlet>
	<![CDATA[SerialNo decorator = new SerialNo();
			pageContext.setAttribute("userListDecorator", decorator);]]>
</jsp:scriptlet>

<form:form  action="viewQuestion.htm"  method="GET" commandName="viewQuestion" >
          
		 
		
   	<display:table id="list" requestURI="viewQuestion.htm" decorator="userListDecorator"  name="sessionScope.questionVO"    sort="list">
   	           <display:setProperty name="basic.msg.empty_list" value="" />
   	           	<display:column property="serialNo" title="#" style="width:40px" />
   	           
   	           <display:column>
   	           <form:input type="hidden" path="questionListVO.questionId" value="${list.questionId }"/>
   	           </display:column>
	         <display:column property="subSection" title="subSection"
			    sortable="true" headerClass="sortable" 	style="width:180px" />
			    <display:column property="question" title="Question"
			    sortable="true" headerClass="sortable" 	style="width:180px" />
			    <display:column property="option1" title="option1"
			    sortable="true" headerClass="sortable" 	style="width:180px" />
			     <display:column property="option2" title="option2"
			    sortable="true" headerClass="sortable" 	style="width:180px" />
			     <display:column property="option3" title="option3"
			    sortable="true" headerClass="sortable" 	style="width:180px" />
			     <display:column property="option4" title="option4"
			    sortable="true" headerClass="sortable" 	style="width:180px" />
			    <display:column property="answer" title="Answer"
			    sortable="true" headerClass="sortable" 	style="width:180px" />
			     <display:column property="subSection" title="subSection"
			   sortable="true"		headerClass="sortable"  style="width:180px" />
                <display:column property="dateAdded" title="Date Added"
			     sortable="true"	headerClass="sortable"  style="width:180px" />
              <display:column title="Action"><a href="updateQuestion.htm?questionId=${list.questionId}">
                 Edit</a>
             <a href="deleteQuestion.htm?questionId=${list.questionId}">
                 Delete</a></display:column> 
        </display:table>
							
							
							 	
                 
							
							</form:form>
</div>
