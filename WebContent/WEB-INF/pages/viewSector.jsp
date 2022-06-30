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

<form:form  action="viewSector.htm"  method="GET" commandName="viewSector" >
          
		 
		
   	<display:table id="list" requestURI="viewSector.htm" decorator="userListDecorator"  name="sessionScope.sectorVOs"    sort="list">
   	           <display:setProperty name="basic.msg.empty_list" value="" />
   	           							<display:column property="serialNo" title="#" style="width:40px" />
   	           
   	           <display:column>
   	           <form:input type="hidden" path="sectorListVO.sectorTypeId" value="${list.sectorTypeId }"/>
   	           </display:column>
	     
			 <display:column property="sector" title="sector"
			    sortable="true" headerClass="sortable" 	style="width:180px" />
			     <display:column property="testType" title="Test Type"
			   sortable="true"		headerClass="sortable"  style="width:180px" />
                <display:column property="dateAdded" title="Date Added"
			     sortable="true"	headerClass="sortable"  style="width:180px" />
              <display:column title="Action"><a href="updateSectors.htm?sectorTypeId=${list.sectorTypeId}">
                 Edit</a>
             <a href="deleteSector.htm?sectorTypeId=${list.sectorTypeId}">
                 Delete</a></display:column>   
        </display:table>
							
							
							 	
                 
							
							</form:form>
</div>
