import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
  static int[] dp;
  static int n, m;
  static int max;
  static int[][] oreum;
  static boolean flag;
  static Integer[][] best;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());
    dp = new int[n + 1];
    best = new Integer[n+1][2*n + 1];
    best[0][0] = 0;
    flag = false;
    max = -1;
    oreum = new int[n+1][2*n+1];
    for(int i = 0; i < m; i++) {
      st = new StringTokenizer(br.readLine());
      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());
      oreum[b][a] = 1;

    }
    for(int x = 0; x < 2*n; x++) {
      for(int y = 0; y <= (x<=n ? x : 2*n-x); y++) {
//        int ny = y+1, nx = x+1;
//        if(inside(nx, ny) && !blocked(nx, ny)) {
//          best[ny][nx] = Math.max(best[ny][nx]==null?ny:best[ny][nx], Math.max(best[y][x]==null?ny: best[y][x], ny));
//        }
        if (best[y][x] == null) continue;     // ← 여기 반드시 넣고,
        int curMax = best[y][x];             // 닿아본 상태에서만 전이를 수행하세요.

        // 올라가기 전이
        int ny = y+1, nx = x+1;
        if (inside(nx, ny) && !blocked(nx, ny)) {
          best[ny][nx] = best[ny][nx]==null
              ? Math.max(curMax, ny)
              : Math.max(best[ny][nx], Math.max(curMax, ny));
        }
        ny = y-1; nx = x+1;
        if(inside(nx, ny) && !blocked(nx, ny)) {
          best[ny][nx] = best[ny][nx] == null
              ? Math.max(curMax, ny)
              : Math.max(best[ny][nx], Math.max(curMax, ny));
        }
//        if(inside(nx, ny) && !blocked(nx, ny)) {
//          best[ny][nx] = Math.max(best[ny][nx]==null?ny:best[ny][nx], Math.max(best[y][x]==null?ny: best[y][x], ny));
//        }
      }
    }
    if(best[0][2*n]==null) {
      System.out.println(-1);
    }else{
      System.out.println(best[0][2*n]);
    }
  }
  static boolean inside(int x, int y) {
    if(x>=0 && x<=n) {
      if(y>=0 && y<=x) {
        return true;
      }
    } else if(x<=2*n) {
      if(y>=0 && y<=2*n-x) {
        return true;
      }
    }
    return false;
  }
  static boolean blocked(int x, int y) {
    if(oreum[y][x]==1) {
      return true;
    }
    return false;
  }

}
