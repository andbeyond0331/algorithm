import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
  static final long MOD = 1000000007;
  static int N, M;
  static int[] parent;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
    parent = new int[N + 1];
    for(int i = 1; i <= N; i++) {
      parent[i] = i;
    }
    for(int i = 0;i < M; i++) {
      st = new StringTokenizer(br.readLine());
      union(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
    }
    Map<Integer, Integer> map = new HashMap<>();
    for(int i = 1; i <= N; i++) {
      int p = find(i);
      if(map.containsKey(p)) {
        map.put(p, map.get(p) + 1);
      } else {
        map.put(p, 1);
      }
    }
    long ans = 0;
    for(int i:map.values()) {
      if(ans == 0) {
        ans = i % MOD;
      } else {
        ans = ans * i % MOD;
      }
    }
    System.out.println(ans);
  }
  static void union(int a, int b) {
    int rootA = find(a);
    int rootB = find(b);
    if(rootA!=rootB) {
      parent[rootA] = rootB;
    }
  }

  static int find(int a) {
    if(a == parent[a]) {
      return a;
    }
    return parent[a] = find(parent[a]);
  }
}
// 1 2
// 3 1
// 4 5
// 4 6

// 1
