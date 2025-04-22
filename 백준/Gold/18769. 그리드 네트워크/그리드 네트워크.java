import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
  static class Node implements Comparable<Node> {
    int from;
    int to;
    int cost;

    public Node(int from, int to, int cost) {
      this.from = from;
      this.to = to;
      this.cost = cost;
    }

    @Override
    public int compareTo(Node o) {
      return cost - o.cost;
    }
  }

  static int R, C;
  static int V, E;
  static int[] parents;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int T = Integer.parseInt(br.readLine());
    StringTokenizer st;
    for(int t = 1; t <= T; t++) {
      st = new StringTokenizer(br.readLine());
      R = Integer.parseInt(st.nextToken());
      C = Integer.parseInt(st.nextToken());
      int count = 0;
      int N = (R-1)*C + (C-1)*R;
      parents = new int[R*C];
      for(int i = 0; i < R*C; i++) {
        parents[i] = i;
      }
      int totalCost = 0;
      PriorityQueue<Node> pq = new PriorityQueue<>();
      for(int i = 0; i < R; i++) {
        st = new StringTokenizer(br.readLine());
        for(int j = 0; j < C-1; j++) {
          pq.add(new Node(i*C + j, i*C + j + 1, Integer.parseInt(st.nextToken())));
        }
      }
      for(int i = 0; i < R-1; i++) {
        st = new StringTokenizer(br.readLine());
        for(int j = 0; j < C; j++) {
          pq.add(new Node(i*C + j, i*C + j + C, Integer.parseInt(st.nextToken())));
        }
      }
      while(!pq.isEmpty()) {
        Node node = pq.poll();
        if(union(node.from, node.to)) {
          totalCost += node.cost;
          count++;
          if(count == N-1) break;
        }
      }
      System.out.println(totalCost);
    }
  }
  static boolean union(int from, int to) {
    int rootFrom = find(from);
    int rootTo = find(to);

    if(rootFrom == rootTo) {
      return false;
    }
    parents[rootFrom] = rootTo;
    return true;
  }

  static int find(int x) {
    if(parents[x] == x) return x;
    return parents[x] = find(parents[x]);
  }

}
