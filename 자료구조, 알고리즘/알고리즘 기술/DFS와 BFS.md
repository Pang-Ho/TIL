# DFS와 BFS

DFS 는 깊이 우선 탐색

BFS 는 너비 우선 탐색



## DFS와 BFS알고리즘이 쓰이는 문제 유형

1. 그래프의 **모든 정점을 방문**해야할 때

   단순히 모든 정점을 방분하는 것이면 DFS, BFS 어느 것을 사용해도 문제 없다.

   * ~~백준-백트래킹-연산자 끼워넣기 문제같이~~

     ~~AAAA BBB CCCC DDDD를 나열하는 문제라면 DFS 알고리즘 형태로 만들어야 한다.~~

     밑의 모습은 DFS가 아니고 완전 탐색 모습이다. 헷갈리지 말자!

     ~~~java
     void rec_function(int k, int num) {
       if (k == N) {
         max = Math.max(num, max);
         return;
       }
       
       for (int i = 0; i < 4; i++) { // 4가지 종류를 다 돌릴것이다.
         if (operator[i] > 0) {
           operator[i]--; //사용한 거 갯수 빼고
           
           //이렇게 작성해야, i가 0에서 k가 0 ~ N까지 바로 쭉 탐색하고 그다음 i가 1이 되고 반복
           if (i == 0) { 
             rec_function(k + 1, num + number[k]);
           } else if (i == 1) {
             rec_function(k + 1, num - number[k]);
           } else if (i == 2) {
             rec_function(k + 1, num * number[k]);
           } else {
             rec_function(k + 1, num / number[k]);
           }
           
           operator[i]++; //i 가 0인건 끝났으니 다시 채워주고
           
         }
       }
     }
     ~~~

     

2. **경로의 특징**을 저장해둬야 하는 문제

   예를들어 각 정점에 숫자가 적혀있고, a부터 b까지 가는 경로를 구하는데 경로에 같은 숫자가 있으면 안된다는 등,

   각각 경로마다 특징을 저장해둬야 할 때

   DFS를 사용한다. (BFS는 경로의 특성을 가지지 못한다.)

3. **최단거리**를 구해야 하는 문제

   미로 찾기 등 최단 거리를 구해야 할 경우 BFS가 유리하다.

   DFS 경우 처음으로 발견되는 해답이 최단거리가 아닐 수 있지만,

   BFS 경우 현재 노드에서 가장 가까운 곳 부터 찾기 때문에 경로 탐색시 먼저 찾아지는 해답이 곧 최단 거리다.



## DFS와 BFS를 이용한 코드

DFS의 경우 스택과 큐를 활용하거나 재귀 함수를 활용한다.

BFS의 경우 큐 두 개를 활용한다.



1. 인접행렬

      1 2 3 4 5 6 7

   1 0 1 0 0 0 1 0  

   2 1 0 1 0 0 1 0  

   3 0 1 0 1 0 0 0  

   4 0 0 0 1 0 1 1  

   5 1 1 0 1 0 0 0 

   6 0 0 0 1 0 0 0

   7 0 0 0 1 0 0 0

   arr1 = {0,1,0,0,0,1,0}

   ...

   위 형식으로 n번과 k번의 꼭지점이 연결되어 있으면 1로, 아니라면 0으로 처리해서 배열로 구현함.

   그러나, 이 방법은 꼭지점의 개수가 많아지면 탐색 시간이 오래 걸린다.

   어느 꼭지점에서 한 간선이 연결되어 있는지 확인하는 시간이 매우 길어지게 된다.

   ~~~java
   import java.io.BufferedReader;
   import java.io.IOException;
   import java.io.InputStreamReader;
   import java.util.Arrays;
   import java.util.LinkedList;
   import java.util.Queue;
   import java.util.StringTokenizer;
   
   public class Main {
   
       static int N, M, V;
       static int[][] map;
       static boolean[] visit;
       static StringBuilder sb = new StringBuilder();
   
       static void solution() throws IOException {
           BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
           StringTokenizer st = new StringTokenizer(br.readLine(), " ");
           N = Integer.parseInt(st.nextToken());
           M = Integer.parseInt(st.nextToken());
           V = Integer.parseInt(st.nextToken());
           map = new int[N + 1][N + 1];
           visit = new boolean[N + 1];
   
           for (int i = 0; i < M; i++) {
               String edge = br.readLine();
               st = new StringTokenizer(edge, " ");
               int a = Integer.parseInt(st.nextToken());
               int b = Integer.parseInt(st.nextToken());
               map[a][b] = 1;
               map[b][a] = 1;
           }
       }
   
       static void dfs(int v) {
           visit[v] = true;
           sb.append(v).append(" ");
   
           for (int i = 1; i <= N; i++) {
               if (!visit[i] && map[v][i] == 1) {
                   dfs(i);
               }
           }
       }
   
       static void bfs(int v) {
           Queue<Integer> q = new LinkedList<>();
           q.offer(v);
           visit[v] = true;
           while (!q.isEmpty()) {
               int temp = q.poll();
               sb.append(temp).append(" ");
   
               for (int i = 1; i <= N; i++) {
                   if (!visit[i] && map[temp][i] == 1) {
                       q.offer(i);
                       visit[i] = true;
                   }
               }
           }
       }
   
       public static void main(String[] args) throws IOException {
           solution();
           dfs(V);
           sb.append("\n");
           Arrays.fill(visit, false);
           bfs(V);
           System.out.println(sb);
       }
   }
   ~~~

   


2. 인접리스트

   

* needVisit 스택 / visited 큐

* graph를 HashMap으로 구현하고, needVisit를 ArrayList로 받아서 DFS와 BFS 구현

~~~java
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int N, M, V;
    static boolean[] visited;
    static HashMap<Integer, ArrayList<Integer>> graph = new HashMap<>();
    static StringBuilder sb = new StringBuilder();

    static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());
        visited = new boolean[N + 1];

        for (int i = 1; i <= N; i++) graph.put(i, new ArrayList<>());
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph.get(a).add(b);
            graph.get(b).add(a);
        }

    }

    static void dfs(int v) {
        visited[v] = true;
        sb.append(v).append(" ");
        ArrayList<Integer> arr = graph.get(v);

        for (int i = 1; i <= N; i++) {
            if (!visited[i] && arr.contains(i)) {
                dfs(i);
            }
        }
    }

    static void bfs(int v) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(v);
        visited[v] = true;

        while (!q.isEmpty()) {
            int temp = q.poll();
            ArrayList<Integer> arr = graph.get(temp);
            sb.append(temp).append(" ");

            for (int i = 1; i <= N; i++) {
                if (!visited[i] && arr.contains(i)) {
                    q.offer(i);
                    visited[i] = true;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        solution();
        dfs(V);
        sb.append("\n");
        Arrays.fill(visited, false);
        bfs(V);
        System.out.println(sb);
    }
}
~~~