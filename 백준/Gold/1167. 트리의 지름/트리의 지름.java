import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

class Node {
  int num;
  int value;
  int to;
  public Node(int num, int value, int to) {
    this.num = num;
    this.value = value;
    this.to = to;
  }
}

public class Main {
static int V;
static List<Node>[] tree;
static boolean[] visited;
static int max;
static int farthest;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    V = Integer.parseInt(br.readLine());
    tree = new ArrayList[V+1];
    visited = new boolean[V+1];
    StringTokenizer st;
    max = -1;
    for(int i = 0; i <V; i++) {
      st = new StringTokenizer(br.readLine());
      int number = Integer.parseInt(st.nextToken());
      if(tree[number] == null) {
        tree[number] = new ArrayList<>();
      }
      while(true) {
        int next = Integer.parseInt(st.nextToken());
        if(next == -1) {
          break;
        } else {
          int value = Integer.parseInt(st.nextToken());
          Node node = new Node(number, value, next);
          tree[number].add(node);
        }
      }

//      if(tree.containsKey(number)) {
//
//      }
    }
//    for(int i = 1; i <= V; i++) {
//      if(!visited[i]) {
//        visited = new boolean[V+1];
//        farthest = 0;
//        findMax(i, 0);
//      }
//    }
    findMax(1, 0);
    visited = new boolean[V+1];
    max = -1;
    findMax(farthest, 0);
    System.out.println(max);
  }
  static void findMax(int n, int dist) {
    visited[n] = true;
    if(dist > max) {
      max = dist;
      farthest = n;
    }
    for(Node node : tree[n]) {
      if(!visited[node.to]) {
        findMax(node.to, dist + node.value);
      }
    }
  }

}
