# Stream으로 2개 이상 배열 합치기



## Object

`Stream.of` 파라미터로 합칠 `Object` 배열을 넣어주고, `flatMap`을 이용하여 Object 변형 후 원하는 Array로 변형한다.

```java
int[][] arr1 = {{1,2}, {2,3}, {3,4}};
int[][] arr2 = {{4,5}, {5,6}};
int[][] arr3 = {{6,7}, {7,8}, {8,9}};

Stream.of(arr1, arr2, arr3).flatMap(Arrays::stream).toArray(int[][]::new);
```

## 예시문제

https://school.programmers.co.kr/learn/courses/30/lessons/12946

## 코드

```java
import java.util.*;
import java.util.stream.Stream;

class Solution {
    public int[][] solution(int n) {
        //2개 템플릿 a => b, a => c, b => c 
        //template2(a, b, c) : 2개를 a => c로 옮기는 방법
        
        //2개 옮길 때 1 => 2, 1 => 3, 2 => 3
        //3개 옮길 때 2개를 1 => 2로 이동, 1 => 3 이동, 2개를 2 => 3로 이동
        //3개 템플릿 template2(1, 3, 2), [1,3] ,template2(2, 1, 3)
        //template3(a,b,c) = template2(a,c,b), [1,3], template2(b,a,c);
        
        //4개 옮길 때 3개를 1 => 2로 이동, 1 => 3 이동, 3개를 2 => 3로 이동
        //          2개를 1 => 3 이동, 1 => 2 이동, 2개를 3 => 2 이동
        //          1 => 3
        //          2개를 2 => 1 이동, 2 => 3 이동, 2개를 1 => 3 이동
        //template4(a,b,c) = template3(a,c,b), [1,3], template3(b,a,c);
        
        return template(n, 1, 2, 3);
    }
    
    static int[][] template(int n, int a, int b, int c) {

        if (n == 1) {
            return new int[][]{{a,c}};
        }

        return Stream.of(template(n - 1, a, c, b), new int[][]{{a,c}}, template(n - 1, b, a, c)).flatMap(Arrays::stream).toArray(int[][]::new);
    }
}

//2개 옮길 때 3
//3개 옮길 때 3 + 1 + 3
//4개 옮길 때 3 + 1 + 3 + 1 + 3 + 1 + 3
//n개 옮길 때 2 * f(n -1) + 1
```



## int[]

`IntStream.of()` or `Arrays.stream()`을 이용해서 각각 `IntStream`으로 만들고 `concat()`메서드로 합친다.

~~~java
int[] arr1 = {1,2,3,4};
int[] arr2 = {3,4,5,6};
int[] arr3;

arr3 = IntStream.concat(IntStream.of(arr1), IntStream.of(arr2)).toArray();
arr3 = IntStream.concat(Arrays.stream(arr1), Arrays.stream(arr2)).toArray();

//3개 이상
int[] arr4 = Stream.of(arr1, arr2, arr3).flatMapToInt(IntStream::of).toArray();
~~~



## String[]

~~~java
String[] arr1 = {"a","b","c"};
String[] arr2 = {"d","e","f"};
String[] arr3;

arr3 = Stream.concat(Arrays.stream(arr1), Arrays.stream(arr2)).toArray(String[]::new);

//3개 이상
String[] arr4 = Stream.of(arr1, arr2, arr3).flatMap(Stream::of).toArray(String[]::new);
~~~

