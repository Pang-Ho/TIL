## HashMap 객체 비교 및 key가 null일 때 추가하기

1. HashMap은 key와 value가 같다면 객체가 동일한지 확인할 수 있다.
2. get의 경우 key가 있는지 없는지 모른다면, `getOrDefault()`를 통해 key가 없을경우 value 초기값을 잡아줄 수 있다.

~~~java
HashMap<Integer, Integer> map = new HashMap<>();
HashMap<Integer, Integer> temp = new HashMap<>();

map.put(2, map.getOrDefault(2, 0) + 1);
temp.put(2, map.getOrDefault(2, 0) + 1);

if (map.equals(temp)) cnt++; //true
~~~



~~~java
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Main {
    static int cnt = 0;

    static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        char[] anagram = br.readLine().toCharArray();

        HashMap<Integer, Integer> map = new HashMap<>();
        HashMap<Integer, Integer> temp = new HashMap<>();

        for (char c : anagram) {
            add(temp, (int) c);
        }
        int lt = 0, rt = anagram.length-1;

        for (int i = lt; i <= rt; i++) {
            add(map, (int)str.charAt(i));
        }

        while (rt < str.length()) {
            if (map.equals(temp)) {
                cnt++;
            }
            if (rt == str.length()-1) break;

            add(map, (int)str.charAt(++rt));
            remove(map, (int)str.charAt(lt++));
        }
    }

    static void add(HashMap<Integer, Integer> map, int n) {

        if (map.containsKey(n)) {
            map.put(n, map.get(n) + 1);
        } else {
            map.put(n, 1);
        }
    }

    static void remove(HashMap<Integer, Integer> map, int n) {

        if (map.get(n) > 1) {
            map.put(n, map.get(n) - 1);
        } else {
            map.remove(n);
        }
    }

    public static void main(String[] args) throws IOException {
        solution();

        System.out.println(cnt);

    }
}
~~~



## 단순화

`equals()` 메서드와 `getOrDefault(n, 0)`메서드를 사용하면 정말 단순해진다.

~~~java
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Main {
    static int cnt = 0;

    static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        char[] anagram = br.readLine().toCharArray();

        HashMap<Character, Integer> map = new HashMap<>();
        HashMap<Character, Integer> temp = new HashMap<>();

        for (char c : anagram) {
            temp.put(c, temp.getOrDefault(c, 0) + 1);
        }
        int lt = 0, L = anagram.length - 1;

        for (int i = lt; i < L; i++) {
            map.put(str.charAt(i), map.getOrDefault(str.charAt(i), 0) + 1);
        }

        for (int rt = L; rt < str.length(); rt++) {
            map.put(str.charAt(rt), map.getOrDefault(str.charAt(rt), 0) + 1);
            if (map.equals(temp)) cnt++;
            map.put(str.charAt(lt), map.get(str.charAt(lt)) - 1);
            if (map.get(str.charAt(lt)) == 0) map.remove(str.charAt(lt));
            lt++;
        }
    }

    public static void main(String[] args) throws IOException {
        solution();
        System.out.println(cnt);
    }
}
~~~

