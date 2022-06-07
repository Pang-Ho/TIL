# 2438 별 찍기 - 1

입력

~~~
5
~~~

출력

```
*
**
***
****
*****
```



* 평범한 방법

  * for 구문 두 번 사용

    ~~~java
    for(int i = 1 ; i <= n ; i++) {
    			for(int j = 1 ; j <= i ; j++){
    				sb.append("*");
    			}
    			sb.append("\n");
    }
    ~~~



* 지향할 방법

  * for 구문 한 번 사용

    ~~~java
    StringBuilder sb1 = new StringBuilder();
    StringBuilder sb2 = new StringBuilder();
    
    for(int i = 1 ; i <= n ; i++) {
      sb1.append("*");
      sb2.append(sb1).append("\n");
    }
    ~~~

    

# 2439 별 찍기 - 2

입력

~~~
5
~~~

출력

```
    *
   **
  ***
 ****
*****
```



* 지향할 방법

  * for 구문 한 번 사용

    ~~~java
    StringBuilder sb1 = new StringBuilder();
    StringBuilder sb2 = new StringBuilder();
    
    for(int i = 0 ; i < N ; i++) {
    			sb1.append(" ");
    }
    
    for(int i = 0 ; i < N ; i++) {
    			sb1.delete(0, 1);
    			sb1.append("*");
    			sb2.append(sb1).append("\n");
    }
    ~~~

  * char 배열 이용

    * char배열은 출력시 콤마로 구별돼서 나오지 않음
    * char에 데이터 입력시 ' ' 에 넣어야함

    ~~~java
    char[] star = new char[N]
    
    for(int i = 0 ; i < N ; i++) {
      star[i] = ' ';
    }
    
    for(int i = 0 ; i < N ; i++) {
      star[N - 1 - i] = '*';
      sb.append(star).append("\n");
    }
    ~~~

    