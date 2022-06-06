/**
 * 입력 항목에 입력되어 있는지 반환하는 함수
 */
 function necessary() {
 	$('.need').each(function(){
 		if($(this).val() == "") {
 			alert("입력하세요!");
 			$(this).focus();
 			need = false;
 			return need;
 		}
 	});
 	return need;
 }