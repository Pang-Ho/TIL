# Python

## 정수, 실수, 문자열, 논리값 - 단일 데이터 저장 구조
a = 100
print(a)
print(type(a))

b = 100.9
print(type(b))

c = True
print(c)
print(type(c))

d1 = 'python'
d2 = "과정"
print(type(d1) , '-', type(d2))

* 자바와 달리 변수 이름만 선언하고는 사용 못함

  e = None 값이 없는 상태를 선언해서 쓸 수 있음

* 자바스크립트와 달리 자동형변환이 없음

  ```python
  d1='python'
  d3=200
  print(d1 + str(d3)) => int, str, float
  ```

* subString 함수가 없이 간단함 

* [ 시작 : 종료 ] 인덱스 연산자 

  ```python
  d1='python'
  print(d1[0])
  print(d1[0:3])
  print(d1[:3])
  print(d1[2:])
  ```

* 내부 단어 포함 True/False

  ```python
  d7='multicampus'
  print('cam' in d7) => True
  print(d7.find('cam')) => 5번째 부터 보임
  print(d7.count('cam')) => 1번 발견됨
  ```

* 문자 갯수

  ```python
  print(len(d7))
  ```

* 프린터 콤마 결합

  ```python
  print(d1, d2, sep=' ') => 공백빼고 데이터 결합
  ```

* 대문자로 출력

  ```python
  print(d7.upper()) => 
  ```

* isnumeric

  ```python
  print("10101010".isnumeric()) => 숫자로만 이루어진 문자열 true false
  ```

  

* split

  ```python
  print("java-sql-html-python".split("-"))
  ```

* format

* 중괄호 안에 데이터 넣어주기

  ```python
  print("{0} {1} 호에 있습니다.".format("삼성캠퍼스", 507))
  ```

  ```python
  print("multicampus {}호에 있습니다.".format("삼성캠퍼스", 507)) => 앞에 하나만
  ```

* input() 키보드 입력

  ```python
  print("숫자 1개를 입력하시오 : ")
  first = input()
  
  print("숫자 또 1개를 입력하시오 : ")
  second = input()
  
  print(int(first) + int(second))
  ```

## 리스트 튜플 딕셔너리 - 여러 데이터 저장 구조

* list

  ```python
  list1 = [1, 3.14, '리스트', True, [1,2,3]];
  print(list1)
  print(list1[2])
  print(list1[1:5]) => 2번 인덱스부터 5번 인덱스 전까지
  print(list1 + list1) => list1 두번 출력
  print(list1 * 3) => list1 세번 반복
  print('리스트' in list1) => True
  print(len(list1)) => 5
  print(list1[4][0]) => 1
  
  list1[5] = "새로추가"
  list1.append("마지막에 추가")
  list1.insert(2, "정해진 위치에 추가")
  list1[3] = "존재하는 인덱스 수정"
  
  list1.pop() => 마지막 데이터 삭제
  list1.remove(1) => 첫번째로 나오는 1이라는 데이터를 삭제 list.remove(True)
  del list1[0] => 특정 인덱스에있는 값 삭제
  ```

  

* tuple

  ```python
  tuple1 = (1, 2, 3, 4, 5); => 수정이 불가함
  print(tuple1)
  print(tuple1[0])
  
  t1, t2, t3, t4, t5=tuple1;
  print(t1, t2, t3, t4, t5) => 값이 잘 나옴
  ```

* dictionary

  ```python
  dic1 = {"id":1, "pw":3.14, "title":'리스트', "finish":True} => key와 val
  
  dic1['pw']=1234 => 값 변경
  dic1['contents']='리스트내용입니다.' => 키가 존재하지 않아 키 밸류 추가
  print(dic1)
  print(dic1.keys()) #[id, pw, ...] 리스트
  print(dic1.values()) #[1, 3.14 ...] 리스트
  print(dic1.items()) #[(id, 1), (pw,3.14)...] 리스트 형태
  ```

  * 반복문 없이도 출력이 가능하다

  ![image-20210915114944864](../md-images/image-20210915114944864.png)



```python
 print(dir(__builtins__)) #내장함수 목록
```

```python
list2 = [1,2,3,4,5]
print(dir(list2)) #리스트에 적용하는 내장함수 목록
```

```python
str1 = "멀티"
print(dir(str1)) #문자열 타입에 적용하는 내장함수 목록
```

```python
import keyword 
print(keyword.kwlist) #파이썬 키워드 목록
```

* 문자열 리스트 in, [0], [0:2]
* 논리 and or not => 항상 bool 값 리턴
* bool(0) / bool(3) => 숫자를 bool 값으로 리턴 0이면false 0이 아니면 true
* bool(None) => none도 false

## 조건문

* 들여쓰기 해야 인식

```python
if 10 > 5 : print("크다"); print ("크다2");

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
if 100 >= score >= 80 :
    print("이수")
elif score >= 60 :
    print("재시험")
elif score >= 40 :
    print("재수강")
else :
    print("재입과")
print(score, "수고하셨습니다.")
```

* import 모듈(파이썬이 제공하는 라이브러리)

  

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

* for, while
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

* 정의

```python
def hello_3times(): 
    print("hello")
    print("hello")
    print("hello")
    
hello_3times()
```

* 매개변수 있는 함수

```python
def message_3times(message): 
    print(message)
    print(message)
    print(message)
    
message_3times("파이썬")
```

```python
def message_ntimes(message, n):
    for i in range(1, n+1) :
        print(message)
        
message_ntimes("파이썬", 10)
```

* 기본 매개변수 있는 함수 정의

```python
def message_defaulttimes(message, n=5):
    for i in range(1, n):
    	print(message)
        
message_defaulttimese(message="파이썬") => n을 전달 안해도 n=5
message_defaulttimese("파이썬", 3) => n을 전달  n=3

```

* 가변 매개변수 있는 함수 정의

```python
def dynamic_message(*message, n=5):
    for i in range(1, n+1):
        for j in message :
            print(j)
            
dynamic_message("파이썬", "자바", "sql")
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



* 실습

![image-20210915171604045](../md-images/image-20210915171604045.png)

```python
prime =[];
non_prime = [];
a = 0
def get_prime(su):
    for i in range(2, su):
        for j in range(2, i):
            if (i % j) == 0 :
                global non_prime
                non_prime.append(i)
                global a
                a = 0
                break
            else :
                a += 1
                if a == (i-2) :
                    global prime
                    prime.append(i)
                    a = 0


get_prime(28)
print(non_prime)
print(prime)
```

