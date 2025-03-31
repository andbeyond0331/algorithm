import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

class Node {
  int number;
  int value;
  int to;
  public Node(int number, int value, int to) {
    this.number = number;
    this.value = value;
    this.to = to;
  }
}
public class Main {
  static int n;
  static List<Node>[] tree;
  static boolean[] visited;
  static int max;
  static int farthest;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    n = Integer.parseInt(br.readLine());
    tree = new ArrayList[n + 1];
    StringTokenizer st;
    visited = new boolean[n + 1];
    max = -1;
    farthest = 0;
    for (int i = 1; i < n; i++) {
      st = new StringTokenizer(br.readLine());
      int par = Integer.parseInt(st.nextToken());
      int chi = Integer.parseInt(st.nextToken());
      int val = Integer.parseInt(st.nextToken());
      if(tree[par] == null) {
        tree[par] = new ArrayList<>();
      }
      tree[par].add(new Node(par, val,chi));
      if(tree[chi] == null) {
        tree[chi] = new ArrayList<>();
      }
      tree[chi].add(new Node(chi, val, par));
    }
    findMax(1, 0);
    max = -1;
    visited = new boolean[n + 1];
    findMax(farthest, 0);
    System.out.println(max);
  }
  static void findMax(int node, int dist) {
    visited[node] = true;
    if(dist>max) {
      max = dist;
      farthest = node;
    }
    if(tree[node] == null) {
      tree[node] = new ArrayList<>();
    }
    for(Node child : tree[node]) {
      if(!visited[child.to]) {
        findMax(child.to, dist+child.value);
      }
    }
  }
}
