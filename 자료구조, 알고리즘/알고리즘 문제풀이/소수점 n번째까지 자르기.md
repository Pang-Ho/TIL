# 소수점 n번째까지 자르기

* String.format() : 소수점 n번째까지 자르는데, 값이 0인 경우에도 표현함
* Math.round() : 소수점 n번째까지 자르는데, 값이 0인 경우에는 없앰

~~~java
double num = 1000.0000;

//String.format()
String.format("%.3f", num); // 결과 : 1000.000

//Math.round()
Math.round( (num * 1000) / 1000 ); //결과 : 1000
~~~

