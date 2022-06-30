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

<form:form  action="viewSubSection.htm"  method="GET" commandName="viewSubSection" >
          
		 
		
   	<display:table id="list" requestURI="viewSubSection.htm" decorator="userListDecorator"  name="sessionScope.subSectionListVOs"    sort="list">
   	           <display:setProperty name="basic.msg.empty_list" value="" />
   	           	<display:column property="serialNo" title="#" style="width:40px" />
   	           
   	           <display:column>
   	           <form:input type="hidden" path="subSectionListVO.subSectionId" value="${list.subSectionId }"/>
   	           </display:column>
	     
			    <display:column property="subSection" title="subSection"
			    sortable="true" headerClass="sortable" 	style="width:180px" />
			     <display:column property="section" title="section"
			   sortable="true"		headerClass="sortable"  style="width:180px" />
                <display:column property="dateAdded" title="Date Added"
			     sortable="true"	headerClass="sortable"  style="width:180px" />
              <display:column title="Action"><a href="updateSubSection.htm?subSectionId=${list.subSectionId}">
                 Edit</a>
             <a href="deleteSubSection.htm?subSectionId=${list.subSectionId}">
                 Delete</a></display:column> 
        </display:table>
							
							
							 	
                 
							
							</form:form>
</div>
