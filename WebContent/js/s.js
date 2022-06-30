
$(document).ready(function() {
	onload=function(){
		testType();

		sector();
		section();
		subSection();
		if(testType!=""){
			var testType= $("#testType").val();
			test(testType);
		}
		transport();
	}
	$("#testType"). change(function(){
		var testType= $("#testType").val();
        test(testType);
		
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
	
	function testType() {
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
			        			 alert(key+value);
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
	function stuName(testType) {
		if(testType!="" ){
		$.ajax({

					url : 'insertTest.htm?sector',

					type : "POST",

					data : {
						"testType" : testType,
					},
					
					success : function(msg) {
						var test= "";
						//alert(msg);
						 
						test +=('<option value="" selected="selected">--Select--</option>');
			        		 var count = 0;
			        		 $.each(msg, function(key, value) {			        				
			        			 student +=("<option value="+ key + ">" + value + "");
			        				$('#sector').html("");  					        				        				        			        
				        			$('#sector').html(test);	
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
	
	
	
	
	
	
	
	
	
	
	
	
	
/*
	function sector() {
		$.ajax({

					url : 'insertTest.htm?sector',

					type : "POST",

					data : {
						
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

					},
					error : function(jqxhr, textStatus, errorThrown) {
						  console.log(textStatus, jqxhr.getAllResponseHeaders()
						             , errorThrown)
					        			alert('f');

						}
				});
	}
	

	*/
	
	
	
	
	function section() {
		$.ajax({

					url : 'insertTest.htm?section',

					type : "POST",

					data : {
						
					},
					
					success : function(msg) {
						var section= "";
						section +=('<option value="" selected="selected">--Select--</option>');
			        		 var count = 0;
			        		 $.each(msg, function(key, value) {			        				
			        			 section +=("<option value="+ key + ">" + value + "");
			        				$('#section').html("");  					        				        				        			        
				        			$('#section').html(section);	

					        	});

					},
					error : function(jqxhr, textStatus, errorThrown) {
						  console.log(textStatus, jqxhr.getAllResponseHeaders()
						             , errorThrown)
						}
				});
	}
	
	
	function subSection() {
		$.ajax({

					url : 'insertTest.htm?subSection',

					type : "POST",

					data : {
						
					},
					
					success : function(msg) {
						

					        	

					},
					error : function(jqxhr, textStatus, errorThrown) {
						  console.log(textStatus, jqxhr.getAllResponseHeaders()
						             , errorThrown)
						}
				});
	}
});