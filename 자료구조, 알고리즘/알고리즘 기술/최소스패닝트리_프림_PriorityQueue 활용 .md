# 최소스패닝트리 : 프림, PriorityQueue 활용



## 접근 방법

1. 인접리스트 ArrayList<ArrayList\<Edge>> list 를 사용한다.
2. PriorityQueue\<Edge>를 이용해서 가중치가 낮은 노드를 찾아낸다.
3. 모습은 BFS와 비슷한 느낌으로

~~~java
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    static class Edge {
        int v2, cost;

        public Edge(int v2, int cost) {
            this.v2 = v2;
            this.cost = cost;
        }
    }

    static int V, E, sumCost = 0;
    static int[] unf;
    static StringBuilder sb = new StringBuilder();
    static ArrayList<ArrayList<Edge>> list = new ArrayList<>();
    static boolean[] visited;
    static PriorityQueue<Edge> pQ = new PriorityQueue<>((e1, e2) -> e1.cost - e2.cost);

    static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        unf = new int[V + 1];
        visited = new boolean[V + 1];
        for (int i = 0; i <= V; i++) list.add(i, new ArrayList<>());

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            list.get(v1).add(new Edge(v2, cost));
            list.get(v2).add(new Edge(v1, cost));
        }


    }

    static void prim(int v) {
        pQ.offer(new Edge(v, 0));

        while (!pQ.isEmpty()) {
            Edge e = pQ.poll();

            if (!visited[e.v2]) {
                visited[e.v2] = true;
                sumCost += e.cost;
                sb.append(e.v2).append(" ");
                for (Edge ed : list.get(e.v2)) {
                    if (!visited[ed.v2]) {
                        pQ.offer(ed);
                    }
                }
            }

        }
    }

    public static void main(String[] args) throws IOException {
        solution();
        prim(1);
        System.out.println(sumCost);
        System.out.println(sb);
    }
}
~~~

