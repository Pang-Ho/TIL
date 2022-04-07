# Stream으로 2개 이상 배열 합치기



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

