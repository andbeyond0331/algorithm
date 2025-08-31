import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

class Node implements Comparable<Node> {
  int x1, x2, idx;
  Node(int idx, int x1, int x2) {
    this.x1 = x1;
    this.x2 = x2;
    this.idx = idx;
  }
  public int compareTo(Node o) {
    if(this.x1 < o.x1) {
      return -1;
    } else if(this.x1 == o.x1) {
      return 0;
    }
    return 1;
  }
}
public class Main {
  static int n, q;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken()); // 통나무 개수
    q = Integer.parseInt(st.nextToken()); // 통나무 쌍의 개수
    int[] parent = new int[n+1];
    int[] size = new int[n+1];
    Node[] nodes = new Node[n+1];
    for(int i = 1; i <= n; i++) {
      parent[i] = i;
      size[i] = 1;
    }
    nodes[0] = new Node(-1, -1, -1);
    for(int i = 1; i <= n; i++) {
      st = new StringTokenizer(br.readLine());
      nodes[i] = new Node(i, Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
    }
    Arrays.sort(nodes);

    for(int i = 1; i <= n; i++) {
      for(int j = i+1; j<=n; j++) {
        if(nodes[i].x2>=nodes[j].x1) {
          union(nodes[i].idx, nodes[j].idx, parent, size);
        } else {
          break;
        }
      }
    }
    StringBuilder sb = new StringBuilder();
    while (q-- > 0) {
      st = new StringTokenizer(br.readLine());
      int u = Integer.parseInt(st.nextToken());
      int v = Integer.parseInt(st.nextToken());

      int r1 = find(u, parent);
      int r2 = find(v, parent);

      if (r1 == r2) {
        sb.append(1 + "\n");
      } else {
        sb.append(0 + "\n");
      }
    }
    System.out.print(sb);
  }
  static int find(int a, int[] parent) {
    return a == parent[a] ? a : (parent[a] = find(parent[a], parent));
  }

  static void union(int a, int b, int[] parent, int[] size) {
    int r1 = find(a, parent);
    int r2 = find(b, parent);
    if(size[r1] > size[r2]) {
      int temp = r1;
      r1 = r2;
      r2 = temp;
    }

    parent[r1] = r2;
    size[r2] += size[r1];
  }

}
