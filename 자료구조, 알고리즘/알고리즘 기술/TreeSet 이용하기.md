# TreeSet

HashSet이면서 정렬되어 들어가는 자료구조

~~~java
//오름차순
TreeSet<Integer> treeSet = new TreeSet<>();
//내림차순
TreeSet<Integer> treeSet = new TreeSet<>(Collections.reverseOrder());
~~~



## 사용되는 메서드

~~~java
TreeSet<Integer> treeSet = new TreeSet<>(Collections.reverseOrder());

treeSet.remove(143);
int max = treeSet.first();
int min = treeSet.last();
~~~

