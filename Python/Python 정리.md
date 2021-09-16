# Python 정리

## 단일 데이터

* 자바와 달리 변수 이름만 선언 불가

  * d; (x) // d = Null (o)

* 자바스크립트와 달리 자동형변환 없음

  str, int, float

  ```python
  d1 = 'python'
  d2 = 200
  d1 + d2 (x)
  d1 + str(d2) (o)
  ```

## 다중 데이터

* list

  ```python
  list = [1, 3.14, '리스트', True, [1,2,3]]
  print(list) => 리스트 그대로 나옴
  list[2]
  list[1:5]
  list+list
  list*3
  len(list) => 리스트 길이
  
  list[5] = "새로 추가"
  list[5] = "기존 변경"
  list.append("마지막에 추가")
  list.insert(2, "정해진 위치에 추가")
  list.pop() => 마지막 데이터 삭제
  list.pop(2) => 2번째 요소 삭제
  list.remove(1) => 첫번째로 나오는 1이라는 데이터를 삭제
  list.remove(True)
  del list[0] => 특정 인덱스 값 삭제
  ```

* tuple

  ```python
  tuple1 = (1, 2, 3, 4, 5) => 튜플은 수정이 불가
  tuple2 = 1, 2, 3, 4, 5
  tuple3 = 1,
  t1, t2, t3, t4, t5 = tuple1 => 변수 설정해서 값 받아오기
  ```

* dictionary

  ```python
  dic1 = {"id":1, "pw":2, "title":"파이썬", "finish":True}
  => key와 value로 이루어짐
  
  dic1['pw'] = 1234 => vlaue 변경
  dic1['pww'] = 1234 => key가 존재하지 않아 키 밸류 추가
  print(dic1['pw']) => value 호출
  
  dic1.keys() => dict_keys(['','',''])
  dic1.values() => dict_values(['','',''])
  dic.items() => dict_items([,],[,],[,])
  => 리스트가 아님
  ```

* 내장 함수

  ```python
  dir(__builtins__) => 내장함수 목록
  dri(dir(list1)) => list1에 적용 가능한 내장함수 목록
  keyword.kwlist => 파이썬 키워드 목록
  ```

  

## 메소드

* subString 함수 없이 사용 가능

  ```python
  d1 = 'python'
  d1[0] => p
  d1[0:3] => pyth
  d1[2:] => thon
  d1[:3] => pyth
  ```

* in, find, count

  ```python
  d1 = 'multicampus'
  'cam' in d1 => True d1안에 'cam'이 있니?
  list = ['a','b','c','d']
  list in [0] => False list 안에 [0]리스트가 있니?
  
  d1.find('cam') => 5 5번째부터 보인다
  d1.count('cam') => 1 'cam'은 한 번 보인다
  ```

* sort, reverse

  ```python
  list =[1,2,6,4,3]
  list.sort() => 오름차순 정렬
  list.sort(reverse=True) => 내림차순 정렬
  list.reverse() => 리스트 요소 순서를 반대로 뒤집는다
  ```

  

* len

  ```python
  d1 = 'python'
  len(d1) => 문자 개수는 6개 
  ```

* upper, split

  ```python
  d1 = 'python'
  d1.upper() => PYTHON
  d2 = 'p-y-thon'
  d2.split("-") => ['p', 'y', 'thon']
  ```

* isnumeric

  ```python
  d1 = '21341'
  d1.isnumeric() => True 숫자로만 이루어진 문자열
  ```

* format

  ```python
  중괄호 안에 데이터 넣어주기
  "{0} {1}".format("나는", 303) => "나는 303"
  "{}".format("나는", 303) => "나는"
  ```

* input

  ```python
  키보드 입력
  print("숫자 1개를 입력하시오 : ")
  first = input()
  type(first) => str
  ```

  

## 논리 연산자

* not, and, or

  ```python
  not None => True
  not 'ab' => False #비어있는 문자열을 부정하면 True
  ```

* bool()

  ```python
  bool(0) => False #0이 아닌 수는 True
  bool('') => False #모든 리스트 형태들은 비어있으면 Flase
  ```

  

## 조건문

* 들여쓰기로 구역 구별
* import 모듈을 써야 모듈 사용 가능(파이썬이 제공하는 라이브러리)

```python
if 10 < 5 :
    print("크다")
    print ("크다2")
else :
    print("else 수행")
print("if문 상관없이 출력된다")
```



```python
import random
score = random.randint(1,100)
score = random.randrange(1,101)#같은 표현
if 100 >= score and score >= 80 :
    print("이수")
elif score >= 60 :
    print("재시험")
elif score >= 40 :
    print("재수강")
else :
    print("재입과")
print(score, "수고하셨습니다.")
```



```python
print("짝 홀수 판단할 숫자를 입력하세요")
key_num = input()
if key_num.isnumeric() :
    key_num = int(key_num)
    if key_num % 2 ==0 :
        print(key_num, " : 짝수")
    else :
        print(key_num, " : 홀수")
else :
    print(key_num, "의 타입은", type(key_num), "입니다. 숫자만 입력하세요")
```



## 반복문

* for 유한 횟수

```python
num=input();
for i in (1,2,3,4,5,6,7,8,9,10) : #튜플 데이터
    print(i)
    print("번 째 반복중")

num=input();
for i in [1,2,3,4,5,6,7,8,9,10] : #리스트 데이터
    print(i)
    print("번 째 반복중")

num=input();
for i in {1,2,3,4,5,6,7,8,9,10} : #딕셔너리 데이터 (key를 안쓰면 key와 value는 같은 값)
    print(i)
    print("번 째 반복중")
```



* while 횟수를 모를 때

```python
mynum = random.randint(1,100);
while True :
    print("숫자 입력해주세요")
    yournum = int(input())
    if yournum > mynum :
        print(yournum, "보다 작습니다.")
    elif yournum == mynum :
        print("잘했어!")
        break
    else :
        print(yournum, "보다 큽니다.")
```

* range(start, value, end)

```python
print(list(range(1, 11, 1))) #1부터 11이전값까지 1씩 증가
print(list(range(11))) #0부터 11이전까지 1씩 증가

for i in range(11):
    print(i)
    
list2 = ["python", "multi", 100, True]
print(list2)

for i in list2:
    print(i)

for i in range( len(list2) ): #range(4)이니까 0 1 2 3
    print(i, list2[i])
```

* continue와 튜플

```python
dic2 = {"k1":1, "k2":2, "k3":3, "k4":4, "k5":5}

print(type(("k1",1)))
k, v = ("k1", 1)

for k, v in dic2.items() :
    if k=='k3' :
        continue
    print(k, " 키의 값은 ", v, " 이다.")
```

 

## 함수

* 정의, 호출 방법

  ```python
  def hello():
      print("hello")
      
  hello()
  ```

* 매개변수 있는 함수

  ```python
  def message(message):
      print(message)
      
  message("hello")
  ```

  ```python
  def message_ntimes(message, n):
      for i in range(1, n+1) :
          print(message)
          
  message_ntimes("파이썬", 10)
  ```

* 기본 매개변수를 둔 함수

  ```python
  def message_ntimes(message, n=5):
      for i in range(1, n+1) :
          print(message)
          
  message_ntimes("파이썬", 10) => n을 전달 안하면 n=5
  ```

* 가변 매개변수가 있는 함수

  ```python
  def message(*message, n=5):
      for i in range(1, n+1):
          for j in message:
              print(j)
              
  message("파이썬", "자바", "sql")
  ```

  * 가변 매개변수 있는 함수 정의
    * 매개변수 앞에 * 하나면 튜플 * 두개면 딕셔너리가 된다.

  ```python
  def dynamic_message(*message, n=5):
      for i in range(1, n+1):
          for j in message :
              print(j)
              
  dynamic_message("파이썬", "자바", "sql")
  ```

  ```python
  def playerteam(**player):
      for k in player.keys():
          print('{0} 플레이어는 {1}팀이다'.format(k, player[k]))
  playerteam(박지성="한국", 이에마스="일본")
  ```

  

  * 리턴값 있는 함수

    리턴 값이 없으면 함수를 호출해서 변수에 넣을 수 없다.

    ```python
    def no_return():
        print("노 리턴")
    r = no_return() => None
    ```

  ```python
  def return():
  	print("리턴")
      result = 10 + 10
      return result, "리턴값"
  r= return => (20, "리턴값")
  type(r3) => 튜플
  
  r = return3()
  print(r[0], r[1])
  
  first, second = return3()
  print(first, second); => 20 "리턴값"
  ```

  



* 지역변수, 전역변수

```python
def var_test():
    b = 10
    print(b)
    
var_test()
print(b) => 오류 b는 지역변수니까
```

```python
global_b = "전역변수"

print(glober_b)
```

* 자바와 다르게 함수를 호출해서 전역 변수라고 값을 바꾸려해도 지역변수로 선언이 되어 값이 변경 안됨 

```python
glober_var = "전역변수"
def var_test():
    local = 10
    print(local) => 10
    global global_var #global이 this. 이랑 같은거임 이걸 선언해줘야 지역변수로 선언 안됨
    global_var = "전역변수 수정"
    
print(global_var) => 전역변수 수정 / global이 없으면 함수에서 값이 변경이 안됨
```

