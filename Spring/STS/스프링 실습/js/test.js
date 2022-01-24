	$(document).ready(function(){
		$("#login_btn").on('click', function(){
			if(document.getElementById("id").value=="a"){
				if(document.getElementById("pw").value=="b"){
					alert(document.getElementById("id").value + ':' + document.getElementById("pw").value);
				}
			}
		});
	});
	