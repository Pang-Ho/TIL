# jquery

* node.js => 특화 기능 제공 라이브러리

* vue.js react.js => 화면 구성 컨텐츠 추가

* script src="jquery.js" 써서 사용한다.
* script src="http://cdn.jquery.com/jquery-3.2.1-min"



jQuery객체.속성변수 없음

jQuery객체.함수명()

$('css selector').jQuery객체포함 함수명()

1. $('css selector') 태그 선택하여 jQuery객체로 변환하고
2. jQuery 함수로 속성조회/설정, 다른태그추가 삭제 수정, 이벤트처리함수를 이용한다.



## 문서 객체 선택

## 문서 객체 조작

```javascript
winow.onload = function(){
    document.getElementById().style()
}	


$(document).ready(function() {
		//h1태그선택(여러개여도 반복문 사용 필요없다.) 후 글씨색상 변경 함수 
		//$('h1, h1 > a').css("color","red");
		//id가 second 태그의 글씨색상 변경
		//$('#second, th').css("color","red");
		//class red 태그의 배경색상 빨강
		//$(".red").css("background-color", "#ff0000");
		//h1태그 포함 a태그의 밑줄 없애기
		//$('h1>a').css("textDecoration", "none");
		//h1 태그와 td 태그들 배경 색상 노랑
		//$('h1, td').css("background-color", "yellow");
		//class red인 h1태그 배경색 노랑
		//$('h1[class=red]').css("background-color","yellow");
		//text input 태그 배경색 노랑
		//$('input[type=text]').css("background", "yellow");
		//$('input:text').css("background-color", "yellow");
		//type^시작하는거 type$끝나는거 type%들어가는거
		// input 인데 button input:button
		
		//$("th").css("background-color", "pink")
		//첫번째  tr태그
		$("tr:first").css("background-color", "pink")
		//마지막 tr태그
		$("tr:last").css("background-color", "pink")
		//짝수 번호 even 홀수
		$("tr:even").css("background-color", "pink")
		$("tr:gt(2), te:ep(2)").css("background-color", "orange");
		$("tr:lt(2)").css("background-color", "rangde");
		//tr인덱스 3의 배수
		$("tr:nth-child(3n+1)").css("background-color", "orange");

	});
```

* jquery 함수

  * css - css("속성명", "값"); =>setter

  ​	 	css("속성명"); => getter

  * 태그 속성 변경 attr - attr("태그의속성명", "값"); =>settet

  ​						 attr("태그의속성명"); =>getter

  ​						 removeAttr("태그의속성명");

  $('img').attr("width", 100); = $('img').css("width", "100px");

  * html() - innerHTML

  * text() - textContent

  * append() - html 내용 추가 getter용도로는 못씀

  * after() - html 내용 추가 append와 달리 설정한 부모태그 밖에 내용을 추가함

  * empty()

  * remove()

  * addClass() - 클래스를 추가해줌

  * removeClass() - 클래스를 제거해줌

  * toggleClass()

  * val - input 태그에 입력/선택된 값을...

    val() => value getter

    val("")=> value setter

  * 애니메이션 함수
    * hide show
    * fadeIn fadeOut
    * slideUp slideDown
  * 이벤트처리 함수
    * on off
    * one - 한번만 실행

  

  ```javascript
  $('').on('click', function(e){});
  $('').off('click');
  jQuery에서는 취소 함수가 있어서 편함
  ```

  

  

  

  ```javascript
  $('#contents').append("<input type=password><br>"); //setter 용도 (이전 컨텐츠에서 추가)
  var contents = $('#contents').append(); (X) //getter용도로는 못씀
  alert(contents);
  ```

  

```javascript
$('h1 > a').css("text-decoration", "none");
var a = $('h1');
for(var i = 0 ; i < a.length ; i++){
    var col = (i+1)*80;
    $(a[i]).css("color", "rgb(" + col + "," + col + "," + 0 + ")" );
}
```

```javascript
	$(document).ready(function() {
		$('img').attr("src","/htmltest/images/americano.jpg");
		$('img').attr("width", 100);
		$('img').attr("height", 300);
		
		var height = $('img').attr('height');
		var width = $('img').attr("width");
		var src = $("img").attr("src");
		$('#result').html(src + width + height); //.InnerHTML과 같음 jquery에는 변수가 없어서...
		
	});
```

```javascript
<script src="jquery-3.2.1.min.js"></script>
<script>
	$(document).ready(function() {
		var i = 1;
		$("#btnclick").on('click', function(){
			var value = "추가클릭버튼" + i;	
			$('body').after("<input type=button value='" + value + "'id='btnaddclick'>");
			i++;
		});
		
		$('#btnstop').on('click', function(){
			$("#btnclick").off('click');
		});
		
		$("#btnnotice").one('click', function(){
			alert("공지사항은 1번만 보여드립니다.");
		});
		
		$("body").on('click', "#btnaddclick", function(){ //동적으로 생긴건 body에서 찾아야지 속성에서 찾으면 안됨
			alert(this.value + "동적생성버튼을클릭했습니다."); // this.value = $(this).val()
		});
	});
</script>
</head>
<body>
<input id="btnclick" type="button" value="클릭버튼">
<input id="btnstop" type="button" value="중단버튼">
<input id="btnnotice" type="button" value="공지사항">
<div id="plus"></div>
</body>
```

