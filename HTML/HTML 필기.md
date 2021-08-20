# Web

* url : uniform resource location

  웹에서 표준으로 정한 서버 식별 방법

  http://ip.port/a.html / http://70.1.2.100:1521/a.html => ip.port 번호를 이름으로 http://www.google.com/a.html

  프로토콜 - tcp, http, ftp, telnet, jdbc 인터넷 모든 컴퓨터 약속 통신 방식 / 서버와 클라이언트의 규칙, 약속

  

![image-20210819103724568](C:/Users/Pang/Desktop/TIL/md-images/image-20210819103724568.png)

## HTML

* 웹 클라이언트 기술 = (웹 브라우저 실행 - 웹서버 요청시 다운로드) =  웹 표준 2.0
* html5 + css + javascript

### 구성요소 (태그 + 요소)

```html
<h1> 안녕하세요 </h1> 
<img src="a.jpg" alt="이미지삭제되었어요"> <!-- 이미지 표시기능 -->
부가적 설명.src 속성 이미지이름 
alt 속성 = 이미지 표시 불가능한 경우 대체 문자열
```



### 글자 태그

```html
<h1>제목1</h1>

<hr> <!-- 수평선 -->
&nbsp; <!-- 공백 -->
<p>
단락 &nbsp;&nbsp;&nbsp;단락<br>
2번재 줄 <br>
3번 째 줄 <br>
</p>
```

## 게시판 메뉴

```html
orderd list
<ol 속성 = "값">
	<li>뉴스게시판</li> //자동 줄바꿈 기능 있음
	<li>경제게시판</li>
	<li>코로나게시판</li>
    unorderd list
		<ul type = "square">
		    <li>오늘현황</li>
    		<li>총 발생현황</li>
    		<li>접종 현황</li>
		</ul>
</ol>
```

## 테이블 태그

```html
<table border = 1>
	<tr> <td> 자바 </td> <td> 웹 </td> <td> ai </td> </tr>
    <tr> <td> 85 </td> <td> 100 </td> <td> 90 </td></tr>
    <tr> <td colspan = 3> 총점</td> <td> 
        평균 </td> <td> colspan=2 1등 점수 </td></tr> <!--html은 연산, 변수 없음 -->
    <!-- 자바 넣을 수 잇다고 함 <% ? %> -->
</table>

<table border = 2
	<caption>카페 메뉴</caption>
	<tr><td rowspan = 3>커피</td><td>아메리카노</td></tr>
	<tr><td>카페라떼</td></tr>
	<tr><td>바닐라라떼</td></tr>
	<tr><td rowspan = 2>에이드</td><td>레몬에이드</td></tr>
	<tr><td >자몽에이드</td></tr>
	<tr><td rowspan = 3>디저트</td></tr>
	<tr><td>샌드위치</td></tr>
</table>
```

## 미디어 태그

```html
img
audio, video
video
```

## 경로

* http://localhost:9090 => / 임을 알고

  /htmltest/images/americano.jpg => 절대경로

  images/americano.jpg => 상대경로

## 입력 양식 태그

* name="role" => 변수인데 html에서 쓰는게 아닌 action으로 연결된 곳에 쓰일 변수임
* type = "hidden" value가 꼭 있어야함. 사용자에게 입력 받는게 아닌  붙어서 받는 내용

## input 태그

* text, password : 키보드 입력(화면 감추어서)
* checkbox, radio : 화면에 출력 다중/단일 마우스 선택
* hidden : action 속성 지정 파일 특정값 전송, value 필수
* file, image : 파일 선택창 열림
* submit : 클릭 버튼 / 기능 action 속성 지정파일로 전송
* reset : 클릭 버튼 / 입력취소, 전송취소
* button : 클릭 버튼 / 내장기능 없음 사용자 정의 동작(javascript)

