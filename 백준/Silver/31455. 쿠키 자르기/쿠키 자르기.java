
import java.io.*;
import java.util.*;

public class Main {
  static int N;
  static int[][] A;
  static int[][] ps; // 2D prefix sum

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int T = Integer.parseInt(br.readLine());
    StringBuilder out = new StringBuilder();
    while (T-- > 0) {
      N = Integer.parseInt(br.readLine());
      A = new int[N][N];
      for (int i = 0; i < N; i++) {
        String s = br.readLine().trim();
        for (int j = 0; j < N; j++) {
          A[i][j] = s.charAt(j) - '0';
        }
      }
      buildPrefix();
      long ans = dfs(0, 0, N);
      out.append(ans).append('\n');
    }
    System.out.print(out);
  }

  // build 2D prefix sums in ps, size (N+1)x(N+1)
  static void buildPrefix() {
    ps = new int[N+1][N+1];
    for (int i = 1; i <= N; i++) {
      int rowSum = 0;
      for (int j = 1; j <= N; j++) {
        rowSum += A[i-1][j-1];
        ps[i][j] = ps[i-1][j] + rowSum;
      }
    }
  }

  // query sum in [r, r+sz), [c, c+sz)
  static int rectSum(int r, int c, int sz) {
    int r2 = r + sz, c2 = c + sz;
    return ps[r2][c2] - ps[r][c2] - ps[r2][c] + ps[r][c];
  }

  // recursively compute sum of remaining pieces
  static long dfs(int r, int c, int sz) {
    if (sz == 1) {
      // size 1x1, always keep it
      return A[r][c];
    }
    int total = rectSum(r, c, sz);
    int x = total % 4;
    int h = sz/2;
    long sum = 0;
    // quadrants: 0=(r,c), 1=(r,c+h), 2=(r+h,c), 3=(r+h,c+h)
    if (x != 0) sum += dfs(r,     c,     h);
    if (x != 1) sum += dfs(r,     c + h, h);
    if (x != 2) sum += dfs(r + h, c,     h);
    if (x != 3) sum += dfs(r + h, c + h, h);
    return sum;
  }
}
