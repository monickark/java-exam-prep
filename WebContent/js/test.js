
$(document).ready(function() {
	onload=function(){
	getTestType();
     if(testType!=""){
			var testType= $("#testType").val();
			getSector(testType);
		}
     
     if(testType!="" && sector!=""){
			var testType= $("#testType").val();
			var sector= $("#testType").val();

			getSection(testType,sector);
		}
	}
	$("#testType"). change(function(){

		var testType= $("#testType").val();

		getSector(testType);
		
	});
	$("#sector"). change(function(){

		var testType= $("#testType").val();
		var sector= $("#sector").val();
		getSection(testType,sector);
		
	});
});
	$.ajaxSetup({
		   statusCode : {
		            200 : function (data, textStatus, jqxhr) {
		                    console.log(data);
		            },
		            406 : function (jqxhr, textStatus, errorThrown) {
		                    console.log(textStatus + "\n" + errorThrown);
		            }
		        }
		 });
	
	function getTestType() {
		$.ajax({

					url : 'insertTest.htm?testType',

					type : "POST",

					data : {
						
					},
					
					success : function(msg) {
						var testType= "";
						testType +=('<option value="" selected="selected">--Select--</option>');
			        		 var count = 0;
			        		 $.each(msg, function(key, value) {			        				
			        			 testType +=("<option value="+ key + ">" + value + "");
			        				$('#testType').html("");  					        				        				        			        
				        			$('#testType').html(testType);	
					        	});

					},
					error : function(jqxhr, textStatus, errorThrown) {

						  console.log(textStatus, jqxhr.getAllResponseHeaders()
						             , errorThrown)
						}
				});
	}
	function getSector(testType) {
		if(testType!="" ){
		$.ajax({

					url : 'insertTest.htm?sector',

					type : "POST",

					data : {
						"testType" : testType,
					},
					
					success : function(msg) {
						var sector= "";
						 
						sector +=('<option value="" selected="selected">--Select--</option>');
			        		 var count = 0;
			        		 $.each(msg, function(key, value) {			        				
			        			 sector +=("<option value="+ key + ">" + value + "");
			        				$('#sector').html("");  					        				        				        			        
				        			$('#sector').html(sector);	
					        	});
			        		 if($("#sectorName").val()!=""){	
			     				$("#sectorName option[value='"+$("#sectorName").val()+"']").attr('selected',true);
			     			}
			        		

					},
					error : function(jqxhr, textStatus, errorThrown) {
						  console.log(textStatus, jqxhr.getAllResponseHeaders()
						             , errorThrown)
						}
				});
		}
	}
	
	function getSection(testType,sector) {
		if(testType!="" && sector!=""){
		$.ajax({

					url : 'insertTest.htm?section',

					type : "POST",

					data : {
						"testType" : testType,
						"sector":sector,
					},
					
					success : function(msg) {
						alert('success');
						/*var section= "";
						 
						section +=('<option value="" selected="selected">--Select--</option>');*/
						/*var count = 0;
			        		 $.each(msg, function(key, value) {		
			        			 alert(key+value);
			        			 section +=("<option value="+ key + ">" + value + "");
			        				$('#section').html("");  					        				        				        			        
				        			$('#section').html(section);	
					        	});
			        		 if($("#sectionName").val()!=""){	
			     				$("#sectionName option[value='"+$("#sectionName").val()+"']").attr('selected',true);
			     			}*/
			        		
						var section="<ul style='list-style-type:none'>";
						
							/*for(i=0;i<msg.length;i++){
								var sectionList=msg[i];
								section+="<li>"+sectionList.key+"</li>"+"<li>"+sectionList.value+"</li>";
								
							}*/
							$.each(msg, function(key, value) {
								section+="<li style='display:none'>"+key+"</li>"+"<li>"+value+"</li>";
							});
							section+="</ul>"
							$('#section').html("");  					        				        				        			        
		        			$('#section').html(section);
					},
					error : function(jqxhr, textStatus, errorThrown) {
						  console.log(textStatus, jqxhr.getAllResponseHeaders()
						             , errorThrown)
						}
				});
		}
	}