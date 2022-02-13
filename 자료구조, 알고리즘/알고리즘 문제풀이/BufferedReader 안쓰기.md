# BufferedReader 안쓰고 System.in.read() 쓰기

```java
package BOJ;

import java.io.IOException;

public class BOJ10818 {
   static int N;
   static int min = Integer.MAX_VALUE;
   static int max = Integer.MIN_VALUE;
   static StringBuilder sb = new StringBuilder();

   static void input() throws IOException {
      N = readInt();

      for(int i = 0 ; i < N ; i++) {
         int num = readInt();
         min = Math.min(min, num);
         max = Math.max(max, num);
      }

      sb.append(min).append(" ").append(max);
   }

   static int readInt() throws IOException {
      boolean isNegative = false;
      int sum = 0;

      while(true) {
         int input = System.in.read();
         if(input == '\n' || input == ' ') {
            return isNegative ? -1 * sum : sum;
         } else if(input == '-') {
            isNegative = true;
         } else {
            sum = (sum * 10) + (input - 48);
         }
      }
   }

   public static void main(String[] args) throws IOException {
      input();
   }
}
```