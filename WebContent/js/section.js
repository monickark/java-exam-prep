
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

					url : 'sectionSignUp.htm?sector',

					type : "POST",

					data : {
						
					},
					
					success : function(msg) {
						var transport= "";
						transport +=('<option value="" selected="selected">--Select--</option>');
			        		 var count = 0;
			        		 $.each(msg, function(key, value) {			        				
			        			 transport +=("<option value="+ key + ">" + value + "");
			        				$('#sector').html("");  					        				        				        			        
				        			$('#sector').html(transport);	
				        			alert(transport);

					        	});

					},
					error : function(jqxhr, textStatus, errorThrown) {
						  console.log(textStatus, jqxhr.getAllResponseHeaders()
						             , errorThrown)
						}
				});
	}
});