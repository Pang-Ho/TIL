# 기본수학1 10757번



## 문제

두 정수 A와 B를 입력받은 다음, A+B를 출력하는 프로그램을 작성하시오.

## 입력

첫째 줄에 A와 B가 주어진다. (0 < A,B < 1010000)

## 출력

첫째 줄에 A+B를 출력한다.

~~~java
package BOJ;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		String A = st.nextToken();
		String B = st.nextToken();
		StringBuilder sb = new StringBuilder();
		int num = 0, ten = 0;

		for(int i = 0, j = 0 ; i < A.length() || j < B.length() ; i++, j++) {
			if(i < A.length()) num += A.charAt(A.length() - 1 - i) - 48;
			if(i < B.length()) num += B.charAt(B.length() - 1 - j) - 48;

			if(ten == 1) num++;

			if(num >= 10) {
				ten = 1;
				num -= 10;
			} else {
				ten = 0;
			}
			sb.append(num);
			num = 0;
		}
		if(ten == 1) sb.append(1);
		System.out.println(sb.reverse());
	}

	public static void main(String[] args) throws IOException {
		input();
	}
}
~~~



* 다른 방법
  * two pointer algorithm

~~~java
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main2 {
    public ArrayList<Integer> solution(String A, String B) {
        ArrayList<Integer> answer = new ArrayList<Integer>();
        char[] arrA = A.toCharArray();
        char[] arrB = B.toCharArray();
        int p1 = arrA.length - 1;
        int p2 = arrB.length - 1;
        int ten = 0;
        int num = 0;
        while (p1 >= 0 || p2 >= 0) {
            if (p1 >= 0) num += arrA[p1--] - '0';
            if (p2 >= 0) num += arrB[p2--] - '0';

            if (ten == 1) {
                num++;
                ten = 0;
            }
            if (num >= 10) {
                answer.add(num-10);
                ten = 1;
            } else {
                answer.add(num);
            }

            num = 0;
        }
        if (ten == 1) answer.add(1);
        return answer;
    }

    public static void main(String[] args) throws IOException {
        Main2 T = new Main2();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        String A = st.nextToken();
        String B = st.nextToken();

        ArrayList<Integer> list = T.solution(A, B);
        for (int i = list.size()-1; i >= 0; i--) {
            System.out.print(list.get(i));
        }
    }
}
~~~

