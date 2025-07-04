import java.io.*;
import java.util.*;

public class Main {
  static final int MAX = 100001;
  static int[] parent = new int[MAX];
  static long[] planet = new long[MAX];

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int N = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(st.nextToken());

    // 초기화
    for (int i = 1; i <= N; i++) {
      parent[i] = i;
    }
//    st = new StringTokenizer(br.readLine());
    for (int i = 1; i <= N; i++) {
      planet[i] = Integer.parseInt(br.readLine());
    }

    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    for (int i = 0; i < M; i++) {
      st = new StringTokenizer(br.readLine());
      int A = Integer.parseInt(st.nextToken());
      int B = Integer.parseInt(st.nextToken());
      int rootA = find(A);
      int rootB = find(B);

      if (rootA != rootB) {
        long merged = union(rootA, rootB);
        bw.write(merged + "\n");
      } else {
        bw.write(Math.max(planet[rootA], planet[rootB]) + "\n");
      }
    }
    bw.flush();
  }

  static int find(int x) {
    if (parent[x] == x) return x;
    return parent[x] = find(parent[x]);
  }

  static long union(int x, int y) {
    // x, y are roots
    if (x < y) {
      parent[y] = x;
      planet[x] += planet[y];
      planet[y] = 0;
      return planet[x];
    } else {
      parent[x] = y;
      planet[y] += planet[x];
      planet[x] = 0;
      return planet[y];
    }
  }
}
