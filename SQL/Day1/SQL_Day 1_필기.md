# 데이터베이스

* DBMS - 데이터베이스 관리시스템 -저장 조회 관리
* RDBMS - 관계형 데이터베이스 관리시스템 - 데이터 구조를 테이블 형태로 표현
* 오라클 **11G XE** EnterPrise / Standard / Express edition

오라클 설치하면 hr 계정 잠금 상태이므로 풀고 쓰기

시스템 계정 들어가서 alter user hr identified by hr(암호) account unlock;

179p PL/SQL 기본 - SQL 문법 설명

## SQL 문법

1. db언어
2. 대소문자 구분하지 않음
3. 계정의 암호는 대소문자 구분함.
4. 데이터 값은 대소문자 구분함
5. 문자열 데이터 값 - '문자열'
6. 클래스 생성 필요 x, 메인 메소드x
7. 즉각 실행 문장으로 실행

## SQL 종류

| DATA QUERY LANGUAGE - DQL                                    | select ~                                             | 조회                                                         |
| ------------------------------------------------------------ | ---------------------------------------------------- | ------------------------------------------------------------ |
| DATA DEFINITION LANGUAGE - DDL                               | create table ~<br />alter table ~ <br />drop table ~ | 테이블 구조 정의<br />테이블 구조 변경<br />테이블 삭제      |
| DATA MANIPULATION LANGUAGE - DML                             | insert<br />update<br />delete                       | 테이블 내에 데이터 저장<br />테이블 내에 데이터 수정<br />테이블 내에 데이터 삭제 |
| TRANSACTION CONTROL LANGUAGE - TCL                           | commit<br />rollback                                 | 연속적인 SQL 실행 완료 / 취소<br />트랜잭션 처리             |
| DATA CONTROL LANGUAGE - DCL<br />DBAdmin 만 사용하는 명령어<br />system 계정 - DBA<br />hr 계정 - 일반계정 | grant<br />revoke                                    | 특정 계정에 특정 권한 부여<br />특정 계정에 권한 부여를 취소 |

* 오라클 설치하면 내부에 계정이 2개 존재 - System / hr

  테이블 정의하고 데이터를 저장할 계정이 필요 - 몇 권한을 부여해서 DB 사용할 수 있도록 함

## SQL명령어

* connect system/system
* create user test identified by test =
* grant resouce, connect to test = 리소스랑 커넥스 승인해줘
* select * from tab; = 테이블 보여줘
* show user = 현재 계정 알려줘

## select

DQL 조회 - select문

* select - 컬럼명

  학생 1명 데이터 = (학번, 이름, 전공, 학년)

| 학번컬럼(COLUMN - 열)               | 이름컬럼 | 전공컬럼 | 학년컬럼 |
| ----------------------------------- | -------- | -------- | -------- |
| 데이터 열 - ROW행 - 레코드<br />100 | 김학생   | it       | 4        |
|                                     |          |          |          |

​	select 이름컬럼, 전공컬럼, 학년컬럼, 학번컬럼 = 보여줘
​	from 학생테이블
​	select * = 모든 컬럼 다 보여줘
​	from 학생테이블

작성 순서

* select 컴럼명
* from 테이블명
* [where 조회 데이터의 조건식]
* [group by 집계함수 적용기준 컬럼명]
* [having 집계함수 조건식]
* [order by 정렬순서 / 컬럼명 + asc/desc + nulls first/last]

실행 순서

* from => where => group by => having => select => order by



* select * from employees

* desc(ribe) employees

  컬럼 구조 확인 / 열 이름 타입 등 

* select tname from tab; = 테이블 보여줘

* select first_name , last_name , employee_id from employees; 

* edit => 직전 명령코드 수정 완료 후 => / 사용 => 명령어 수정해서 실행됨

* 급여 컬럼 - 월급 조회 

  select salary from emoloyees;

* 급여 12배 - 연봉 컬럼 만들기

  select salary*12 from employees;
  
  
  
* 별칭 만들기 - alias

  select salary 월봉, salary*12 [as] 연봉 from employees;

  

* select 뒤에 올 수 있는 것 

  *, 컬럼명, as 별칭, +-/, 함수



* distinct

* 모든 사원의 직종코드 조회

  select job_id from employees; => 107개 동일 직종코드도 여러번 나옴
  
* 직종코드 종류별 1개 조회

  select distinct job_id from employees; => 동일 직종코드는 안나오고 직종 종류를 알 수 있음.

  

* 주석처리 --

## where 조건식

* where 레코드 조건식 만족

  * employees 테이블 급여가 salary 10000이상인 사원이 이름과 급여 조회

    where salary >= 10000;

    where 컬럼명 연산자 값;

  ex) employees테이블 급여 salary 1000이상이고 15000이하인 사원의 이름과 급여 조회

  1. select first_name, salary from employees

     where salary >= 10000 and salary <= 15000;

  2. select first_name, salary from employees

     where salary between 10000 and 15000;

  ex) employees 테이블에서 사번(employee_id)컬럼이 100, 120, 200, 300인 사원의 사번 조회

  ​	select employee_id from employees;

  ​	where employee_id = 100 or

  ​	where employee_id  = 120 or  => where employee_id in (100, 120, 200, 300 ...)

  ​	where employee_id = 200 or

  ​	where employee_id = 300

  ex) 이름에 'ex' 문자 포함 사원의 이름조회

  ​	select first_name from employees

  ​	where first_name = 'ex'; =>이름이 ex인 사람을 조회하는 것

  ​	where first_name like '%ex%';  => % 0개 이상의 아무글자나 와도 좋아

  ex) 이름에 'e'를 포함하되 2번 째 있을 경우 이름조회

  ​	where first_name like '_e%' => _  1개 아무 글자나 와도 좋아

  ex) 이름에 'e' 2개이상 있는  경우 이름조회

  ​	where first_name like '%e%e%'

  

  문자 대소비교 = 사전 나열 순서(앞이 작다 / 뒤 크다)

  날짜 대소비교 = 오래될 수록 크다

  * 입사일자(hire_date) 

  * 날짜시각형식 select sysdate from dual; 오라클 현재시각 함수

    21/08/12 => 오라클 디본 날짜 형식 - rr.mm.dd

    ​	rr => 0~49 - 2000년대

    ​	rr =>50~99 1990년 대 

    ​	select to_char(sysdate, "yyyy-mm-dd hh24:miss") from dual;

     * select hire_date from employees;

       전체 인원의 입사정보

       

  ​	02년도 입사일자

  ​	select hire_date from Employees

  ​	where hire_date >= '02/01/01'

  ​	and hire_date <= '02/12/31';

  ​	==> like 연산자

  ​	where hire_date like '02%';

  ​	where hire_date like '02______';0

  

  * employees 테이블에 커미션 commission_pct 컬럼이 있음

    null 상태에서는 출력형태가 공백으로 보임

  ex) 커미션을 받는 사원

  ​	select commission_pct from employees

  ​	where commission_pct is not null;

  

  | 비교연산자      | > , >= , < , <= , = , !=(<>)                            |
  | --------------- | ------------------------------------------------------- |
  | 산술연산자      | + - * / (나머지 구하는 건 함수로 제공됨)                |
  | 논리연산자      | salary >= 10000 and employee_id=100                     |
  | 범위연산자      | 컬럼명 between A and B                                  |
  | 목록            | 컬럼명 in (값1, 값2, ....)                              |
  | 유사패턴연산자  | like, %, _                                              |
  | null비교 연산자 | is null<br />is not null<br />where first_name is null; |


## order by

* select employee_id from employees;

  => 사번 작은 값부터 큰 값 순으로 보이는게 아니고 저장 순서로 조회됨

* ex)이름 알파벳 오름차순 조회

  select first_name from employees;

  order by first_name asc; => 기본 값이 asc라 생략 가능

* ex)이름 알파벳 내림차순 조회

  order by first_name desc;

* ex) 급여 많은 사원부터 조회하되 급여 같으면 이름 순

  select first_name, salary from employees

  order by salary desc, first_name;

* select first_name, salary from employees

  order by 2 desc, 1;

  select first_name 이름, salary 급여 from employees

  order by 급여 desc, 이름;

* 커미션 많은 사원부터 조회

  select commission_pct from employees

  order by commission_pct desc;

  order by commission_pct asc; => null값은 마지막부터 나온다.

* 커미션이 많은 사원부터 조회하되 null은 마지막 조회

  select commission_pct from employees

  order by commission_pct desc **nulls last**;

## rownum 과 sample

* 사번 조회 아무 사번 5% 갯수 추출

  select employee_id from employees sample(5);

* 이름 조회 순서대로 5개 추출

  select first_name from employees

  where rownum <=  5;

* 급여가 많은 사원부터 5명 추출은 어떻게 함??

  select salary from employees

  where rownum <= 5  => 이건 급여 저장 순서대로 5명 뽑고 내림차순

  order by salary desc;
  
  

### select 실행

select rownum, salary from employees

oreder by salary desc

1. from 절 테이블 가져온다. / 8개 테이블 중에서 1개 테이블을 메모리에 올림

2. where절이 있으면 실행 /  조건에 맞는 레코드로 줄어듦

3. select 절 실행하면 salary 컬럼 가져올 때마다 rownum 생성

   1 14000

   2 17000

   3 17000

4. 급여가 많은 사원부터 결과의 순서 변경

   2 17000

   3 17000

   1 14000

​	=====> rownum과 desc 같이 쓰지마라

| 집계함수 = 다중행함수             | sum, avg, max, min, count, std, variance                     |
| --------------------------------- | ------------------------------------------------------------ |
| 단일행함수                        | upper('oracle') => ORACLE<br />SELECT UPPER(FIRST_NAME) FROM EMPLOYEES;<br />---> 107 레코드의 이름 대문자 변경 |
| sum, avg<br />max, min<br />count | 숫자타입 컬럼만<br />모든타입 컬럼<br />컬럼의 not null 데이터 갯수만  => null도 같이 얻고자 하면 count(*) |

* 급여 총합을 구하라

  select sum(salary) from employees;

  평균 - avg(salary)

  개수 - count(salary)

* 가장 먼저 입사한 사원의 입사일자 , 가장 최근에 입사한 사원의 입사일자

  select min(hire_date), max(hire_date) from employees;

  => 누구나 이해할 수 있게 별칭 붙이자

  select min(hire_date) 사장님의입사일, max(hire_date) 신입사원의입사일 from employees;

* 이름 알파벳 순서상 가장 처음, 마지막 이름

  select min(first_name) 처음, max(first_name) 마지막 from employees;

* 커미션을 받는 사원수

  select count(commission_pct) from employees;

* 부서 속한 사원수

  select count(department_id) from employees;

* 모든 사원수

  select count(*) from employees;

* 부서가 없는 사원

  select first_name, department_id from employees 

  where department_id is null;

* 부서종류 조회

  select distinct department_id from employees

  

## group by

* 부서별 급여 총합조회

  select sum(salary) from employees

  group by department_id;   => 그룹지어서 나옴

* 집계함수 select 시는 다른 컬럼 같이 조회 불가능

* 급여 총합 이름과 같이 조회 불가능

* select first_name, sum(salary) from employees

  ​				107개		1개 

  group by department_id;  => 갯수가 맞지 않아 이 결과가 안나옴

* 단, group by 뒤에  쓴 컬럼명은 같이 조회 가능

  select department_id , sum(salary) from employees

  group by department_id; 

* 부서별 급여 총합 조회하되 부서원 없는 부서는 제외

  급여 총합 많은 부서부터 순서대로 조회

  select department_id, sum(salary) from employees

  where department_id is not null

  group by department_id

  order by sum(salary) desc;

* group by department_id, jop_id, hire_date

## having

* 부서별 급여 총합 조회하되, 총합이 10만 이상 조회

  select department_id , sum(salary) from employees

  where sum(salary) >= 100000

  group by department_id; 

  from => where => ! 그룹함수가 실행이 되지 않아서 조건을 못쓴다!

* 그래서 having을 쓴다

  select department_id , sum(salary) from employees

  group by department_id

  having sum(salary) >= 100000

  실행 순서

  from => where => group by => having => select => order by

## ORACLE의 데이터 형식

* 숫자 / 날짜 / 문자 / 이진수-대용량 동영상 이미지 음향

  | 숫자 | number(38자리)<br />정수 number(5) number(5, 0)<br />실수 number(10, 2) => 정수 8자리 / 소수점이하 2자리 |
  | ---- | ------------------------------------------------------------ |
  | 날짜 | date<br />년 월 일 시 분 초 요일<br />기본적 date 타입 형식은 rr/mm/dd 형식임<br />변경 가능함 |
  | 문자 | varchar2<br />char(2) - 2byte 문자                           |
  |      | char(10) - 10byte - (java)(6byte)<br />'java' => 4byte<br />varchar2(10) - 10byte <br />(java) 4byte로 동적 변경됨<br />'가나다' - 9byte(한글 1개당 3byte)<br />varchar2(4000) => 최대크기는 4000byte 한글은 1333글자 |

  * length => 글자 개수
  * lengthb => 글자1개 바이트 차지

  | 집계함수   | sum avg max min count |                                        |
  | ---------- | --------------------- | -------------------------------------- |
  | 단일행함수 | 문자열함수            | length<br />lenghtb<br />upper / lower |
  |            | 숫자함수              |                                        |
  |            | 날짜함수              |                                        |
  |            | 타입변환함수          |                                        |
  |            | null처리함수          |                                        |

  * 'A' - ASCII CODE

    select ASCII ('A') from dual;

    * dual - 1행 가상 테이블로 select 결과 저장 임시 테이블

  * asciistr('가')

    select asciistr('가') from dual;

    한글 유니코드 값 16진수로 나옴

  * employees 테이블에서 first_name salary 조회할 때
    xxxx사원은 급여 xxxx를 받습니다.

    select first_name || ' 사원은 급여 ' || salary || '를 받습니다 '  from employees

    || => 문자열 결합

  * concate연산자

    결합 문자는 2개밖에 안들어감

    select concat(concat(concat(first_name, ' 사원은 급여 ' ) , salary)  '를 받습니다 ')  from employees;

  * instr - 특정 문자열 찾은 위치 리턴 / 몰라도 이 기능을 만드는법은 많다.

    select first_name from employees

    where instr(first_name, 'ex') >= 1; => 0개 아닌 사람 

    같음 where first_name like '%ex%';

    select first_name, instr(first_name, 'ex') from employees; => 107명 다나옴

    

  * lower 

    select first_name from employees

    where lower(first_name) = lower('NeeNa');

  * upper

  * initcap

    첫 문자만 대문자로 만들 경우

    select first_name from employees

    where first_name = initcap('Neena');

  * substr

    substr('Neena', 1, 2) => 1번째 문자열부터 2개만 'Ne'

    instr('Neena', 'Ne') => 1

  * 02년도 입사자 입사일 조회

    where hire_date >= '02/01/01' and hire_date <= '02/12/31';

    where hire_date like '02%';

    where substr(hire_date, 1, 2) = '02';

    where instr(hire_date, 02) = 1;

    

  * 02월 입사자 조회 생각해봥~

    

  * lpad, ltrim

    lpad('문자열' , 늘일길이 , '채울 문자열') => 오른쪽 정렬, 왼쪽 정렬에 쓰임

    문자열을 길이로 늘리고 빈곳을 문자열로 채우는 것

