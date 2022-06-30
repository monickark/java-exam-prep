	<!doctype html>
	
	<%@ taglib uri="http://displaytag.sf.net" prefix="display"%>

<div class="content-wrapper" style="min-height: 379px;">
	<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<script type="text/javascript" src="valid-js/jquery.dataTables.min.js"></script>
<script type="text/javascript" src="valid-js/jquery-2.2.0.min.js"></script>


<form:form  action="viewTest.htm"  method="GET" commandName="viewTest" >
          
		 
		
   	<display:table id="list" requestURI="viewTest.htm"  name="sessionScope.viewTest"    sort="list">
   	           <display:setProperty name="basic.msg.empty_list" value="" />
	           <display:column property="testTypeId" title="Test Type Id"
			   sortable="true"		headerClass="sortable"  style="width:180px" />
			    <display:column property="testType" title=" Test Type"
			    sortable="true" headerClass="sortable" 	style="width:180px" />
                <display:column property="dateAdded" title="Date Added"
			     sortable="true"	headerClass="sortable"  style="width:180px" />
                <display:column><a href="updateTest.htm?testTypeId=${list.testTypeId}">
                 update</a></display:column>
                 <display:column><a href="deleteTest.htm?testTypeId=${list.testTypeId}">
                 delete</a></display:column>
        </display:table>
							
							
							 	
                 
							
							</form:form>
</div>
