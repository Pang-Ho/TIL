예시 입력 1 

```
9 3
```

~~~java
//기본적으로 쓰는 내용
BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

//9 3 자리를 한 줄로 가져오기
String str = br.readLine(); // br.readLine()에는 String으로 9 3이 저장되어있다.

//9 3을 분리하는 방법 StringTokenizer()
StringTokenizer st = new StringTokenizer(str, " ");

String str1 = st.nextToken(); //9가 저장되어있다.
String str2 = st.nextToken(); //3이 저장되어있다.
~~~



예시 입력 2

```
8
1 3 5 4 6 7 8 4
```

~~~java
//기본적으로 쓰는 내용
BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

//배열로 가져오기
int N = Integer.parseInt(br.readLine()); //배열 개수인 8 저장
StringTokenizer st = new StringTokenizer(br.readLine(), " "); //배열 데이터
int[] arr = new int[N];
for (int i = 0; i < N; i++) {
  arr[i] = Integer.parseInt(st.nextToken()); //for문을 돌면서 토큰 하나씩 빼오면서 배열에 저장
}
~~~

