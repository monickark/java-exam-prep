
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

					url : 'questionSignUp.htm?subSection',

					type : "POST",

					data : {
						
					},
					
					success : function(msg) {
						var subSection= "";
						subSection +=('<option value="" selected="selected">--Select--</option>');
			        		 var count = 0;
			        		 $.each(msg, function(key, value) {			        				
			        			 subSection +=("<option value="+ key + ">" + value + "");
			        				$('#subSection').html("");  					        				        				        			        
				        			$('#subSection').html(subSection);	
				        			alert(subSection);

					        	});

					},
					error : function(jqxhr, textStatus, errorThrown) {
						  console.log(textStatus, jqxhr.getAllResponseHeaders()
						             , errorThrown)
						}
				});
	}
});