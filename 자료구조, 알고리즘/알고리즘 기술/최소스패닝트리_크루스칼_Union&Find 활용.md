# 최소스패닝트리 : 크루스칼, Union&Find 활용



* 그래프와 트리의 차이
  * 그래프는 간선이 정해져 있지 않다. 또한, 사이클이 생김
  * 트리는 모든 노드가 간선으로 연결되어 있는데, 사이클이 존재하지 않고, 간선은 노드의 개수의 -1개



## 접근 방법

1. Edge 클래스를 만들고 v1, v2, cost 변수를 넣는다.
2. 제공되는 Edge를 ArrayList\<Edge>로 만들고 cost기준으로 오름차순 정렬하낟.
3. Find() 메서드를 통해 루트 노드가 서로 같지 않다면 Union으로 트리 형성시키고, cost를 더해준다.
4. 추가적으로 시간복잡도를 더 줄이기 위해, 간선의 수를 세서 N-1개가 되면 for문에서 벗어나도록 한다.

~~~java
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {

    static class Edge {
        int v1, v2, cost;
        public Edge(int v1, int v2, int cost) {
            this.v1 = v1;
            this.v2 = v2;
            this.cost = cost;
        }
    }

    static int V, E, sumCost = 0;
    static int[] unf;
    static ArrayList<Edge> list = new ArrayList<>();

    static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        unf = new int[V+1];
        for (int i = 1; i <= V; i++) unf[i] = i;

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            list.add(new Edge(v1, v2, cost));
        }
        Collections.sort(list, (e1, e2) -> e1.cost - e2.cost);
        
        int cnt = 0;
        for (int i = 0; i < E; i++) {
            Edge e = list.get(i);
            if (Find(e.v1) != Find(e.v2)) {
                Union(e.v1, e.v2);
                sumCost += e.cost;
                cnt++;
                if (cnt == V-1) return;
            }
        }
    }

    static int Find(int v) {
        if (v == unf[v]) return v;
        else return unf[v] = Find(unf[v]);
    }

    static void Union(int a, int b) {
        int fa = Find(a);
        int fb = Find(b);
        if (fa != fb) unf[fa] = fb;
    }

    public static void main(String[] args) throws IOException {
        solution();
        System.out.println(sumCost);
    }
}
~~~

