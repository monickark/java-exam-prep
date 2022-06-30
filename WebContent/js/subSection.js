
$(document).ready(function() {
	onload=function(){
		transport();
	}
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
	function transport() {
		$.ajax({

					url : 'subSectionSignUp.htm?section',

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
				        			alert(key);

					        	});

					},
					error : function(jqxhr, textStatus, errorThrown) {
						  console.log(textStatus, jqxhr.getAllResponseHeaders()
						             , errorThrown)
						}
				});
	}
});