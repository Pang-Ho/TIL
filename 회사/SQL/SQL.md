



## 정규 표현식

정규표현식 튜토리얼: https://regexone.com/lesson/introduction_abcs
정규표현식을 테스트 해 볼 수 있는 사이트: https://regexr.com/

~~~sql
//a e i o u로 시작되는 필드를 가져와라
select city
from station
where city like 'a%' or city like 'e%' or city like 'i%' or city like 'u%';

select city
from station
where city regexp '^[aeiou].*';

//끝 문자 aeiou
select city
from station
where city regexp '[aeiou]$';

//처음 문자 끝 문자 aeiou
select distinct city
from station
where city regexp '^[aeiou]' and city regexp '[aeiou]$'
~~~

