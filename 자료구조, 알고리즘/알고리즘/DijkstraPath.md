# DijkstraPath

~~~java
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Arrays;
import java.util.PriorityQueue;

public class DijkstraPath {
  public HashMap<String, Integer> dijkstraFunc(HashMap<String, ArrayList<Edge>> graph, String startNode) {
    HashMap<String, Integer> distances = new HashMap<String, Integer>();
    for(String key : graph.keySet()) {
      distances.put(key, Integer.MAX_VALUE);
    }
    distances.put(startNode, 0);

    PriorityQueue<Edge> pQueue = new PriorityQueue<Edge>();
    pQueue.offer(new Edge(0, startNode));

    while(pQueue.size() != 0) {
      Edge currEdge = pQueue.poll();
      int currdistance = currEdge.distance;
      String currNode = currEdge.vertex;

      ArrayList<Edge> edgeList = graph.get(currNode);
      for(int i = 0 ; i < edgeList.size() ; i++) {
        Edge adjacentEdge = edgeList.get(i);
        int weight = adjacentEdge.distance;
        String adjacentNode = adjacentEdge.vertex;

        int distance = currdistance + weight;

        if(distances.get(adjacentNode) > distance) {
          distances.put(adjacentNode, distance);
          pQueue.offer(new Edge(distance, adjacentNode));
        }
      }
    }
    return distances;
  }

  public static void main(String[] args) {
    HashMap<String, ArrayList<Edge>> graph = new HashMap<String, ArrayList<Edge>>();
    graph.put("A", new ArrayList<Edge>(Arrays.asList(new Edge(8, "B"), new Edge(1, "C"), new Edge(2, "D"))));
    graph.put("B", new ArrayList<Edge>());
    graph.put("C", new ArrayList<Edge>(Arrays.asList(new Edge(5, "B"), new Edge(2, "D"))));
    graph.put("D", new ArrayList<Edge>(Arrays.asList(new Edge(3, "E"), new Edge(5, "F"))));
    graph.put("E", new ArrayList<Edge>(Arrays.asList(new Edge(1, "F"))));
    graph.put("F", new ArrayList<Edge>(Arrays.asList(new Edge(5, "A"))));
    
    DijkstraPath dPath = new DijkstraPath();
    System.out.println(dPath.dijkstraFunc(graph, "A")); // {A=0, B=6, C=1, D=2, E=5, F=6}
  }
}

class Edge implements Comparable<Edge> {
  int distance;
  String vertex;

  public Edge(int distance, String vertex) {
    this.distance = distance;
    this.vertex = vertex;
  }

  @Override
  public int compareTo(Edge e) {
    return this.distance - e.distance;
  }
}

~~~

