# String 분리하기

~~~java
//입력:26
BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
String str = br.readLine();

//1. charAt()
int A = str.charAt(0) - 48; //2
int B = str.charAt(1) - 48; //6

//2. StringTokenizer(import java.util.StringTokenizer)
StringTokenizer st = new StringTokenizer(str, " ");
int A = Integer.parseInt(st.nextToken()); //2
int B = Integer.parseInt(st.nextToken()); //6

//3. 연산
int N = Integer.parseInt(str);
int A = N / 10; //2
int B = N % 10; //6
~~~





* BOJ 1110
  * while 조건문을 나중에 판단하고 무조건 한 번은 돌리고 싶다면 do while사용

~~~java
package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
	static int N;

	static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		N = Integer.parseInt(str);
		int cycle = 0;
		int N_tmp = N;
		int N_first;
		int N_second;
		int N_sum;

		do{
			N_first = N_tmp % 10; // 6
			N_second = N_tmp / 10; // 2
			N_sum = N_first + N_second; // 8

			N_tmp = N_first * 10 + N_sum % 10; //68
			cycle++;
		} while(N_tmp != N);

		System.out.println(cycle);
	}

	public static void main(String[] args) throws IOException {
		input();
	}
}
~~~

