# 자바스크립트

* 기본용어

  표현식 - 값을 만들어내는 코드

  키워드 - 자바 유사

  식별자 - 자바 유사 (_, $, 숫자 문자들, 숫자 시작 불가능, 키워드 사용 불가능)

  주석 - 자바와 동일 //, /* */

  변수 - 자바와 다름

  연산자 - 자바 유사

* 문법이 자바 언어와 닮아서 java script

* html 태그에 동작 추가 언어

  script 태그 안에 자바 스크립트 문장 쓰면 됨 or script 태그 안에 src="a.js"

### 연산자

| 산술         | + - * / => 정수와 실수를 비교하지 않음<br />% ++ --    |
| ------------ | ------------------------------------------------------ |
| 비교         | > >= < <= == !=<br />===(값과 타입 둘다 동일한지 비교) |
| 논리         | && \|\| !                                              |
| 대입         | =                                                      |
| 조건삼항비교 | ?:<br />a?b:c => a true시 b, a false시 c               |

### 자료형

| 숫자   | 정수 실수 표현 가능 |
| ------ | ------------------- |
| 논리값 | true / false        |
| 문자열 | 'aaaaa', "aaaaa"    |

### 변수

| 숫자            | 정수, 실수 따로 두지 않음 |
| --------------- | ------------------------- |
| 논리값          | true/false                |
| 문자열          | ' ' , " "                 |
| 함수            | 자바의 메소드             |
| 객체(배열 포함) | 자바의 객체               |
| undefined       |                           |

* 변수 선언

  var i; / 자바와 달리 타입을 미리 선언해주지만 자바스크립트는 아님

  var / let / const

  var => 선언 후 선언을 하면서 수정 가능

  let => 선언은 1번만 가능하고 수정 가능

  const => 1번 선언후 값 수정이 안됨

  parseInt()



```javascript
var s1 = 100;
var s2 = "100";

document.write(s1 == s2);  => true
document.write(s1 === s2); => false
```



## 창?

```javascript
var input = prompt("입력하는 창");

var input2 = confirm("true, false 나오는 창")
```



* Nan = not a number // 숫자가 아니어서 계산을 못하는 상황

  ```javascript
  if( !isNaN(input1) ) {
      input1 = parseInt(input1);
  }
  ```



## 자바스크립트의 배열

* 자바의 ArrayList처럼 동적인 길이를 갖고있다.
* 여러개 자료형(타입이란 말이 없음) 저장이 가능하다
* 문법 차이가 있다.

```javascript
var a1 = [1, 3.14, 'java', true, undefined, null]; //배열 선언 생성 초기화
var length = a1.length; =>6
a1[0] => 1
a1[5] => null
a1[6] = "추가합니다"; => 이렇게 추가 할 수 있음.
a1[0] = 100; => 수정할 수 있음
```

### 편리한 반복문

```javascript
a1.join(",");
=> a1 배열의 0 ~ 마지막 인덱스의 데이터를 각 분리해서 가져다줌
```

```javascript
var a1 = [1, 3.14, true, "javascript", [1,2,3], undefined, null];

a1[a1.length-1] = "수정";
a1[4][0] = 10; =>이렇게 배열 안에 배열을 바꿀 수 있다.
a1[10] = "10번 인덱스" => 이렇게 하면 a1[7] a1[8] a1[9]는 undefined로 바뀐다!!
```



## 자바와 같은 키워드

* switch-case
* while
* do-while
* break
* continue



* 자바스크립트로 구현하기

  ```javascript
  for(var i = 1 ; i < 6 ; i++){
  		document.write("<tr>");
  		document.write("<td>" + i + "</td><td><a href=''>제목</a>" + i + "</td><td>작성자" + i + "						</td><td>" + i*10 + "</td>");
  		document.write("</tr>");
  }
  ```



## 자바스크립트 함수

* 자바의 메소드와 유사 / 기능 유사

  * 자바스크립트의 함수

    function 함수명(i , j , k) {

    ...

    return xxx;

    }

| 무명 함수<br />function (i,j,k){<br />return xxx;} <br />=> 1, 2, 3 바로 호출이 됨 |
| ------------------------------------------------------------ |
| 무명함수 응용<br />var contents = function(i,j,k){<br />retun xxx;}<br />=> 함수 내용을 정의<br />=> contents(1,2,3); => 실행을 할 수 있다. |

