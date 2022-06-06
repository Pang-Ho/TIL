	$(document).ready(function(){
		$("#login_btn").on('click', function(){
			$.ajax({
				url : "/semiproject/main/main",
				data : {'id':$("#id").val(), 'pw':$("#pw").val() },
				type : 'post',
				dataType : 'json',
				success : function(serverdata){
					$("#result").html("<h3>" + serverdata.process + "</h3>")
				}
			});
		});
	});
	