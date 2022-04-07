# Collections 로 2개 이상 배열 합치기



~~~java
String[] arr1 = {"A","B","C"};
String[] arr2 = {"A","B","C"};
String[] arr3 = {"A","B","C"};

ArrayList<String> list = new ArrayList<String>();
Collections.addAll(list, arr1);
Collections.addAll(list, arr2);
Collections.addAll(list, arr3);

String[] arr4 = list.toArray(new String[0]);
~~~

