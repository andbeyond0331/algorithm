import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
  static int n, m, k;
//  static int[][][][] map;
//  static List[][] map;
  static int[][] map;
  static long[][] dp;
  static long count;
  static boolean[][] visited;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(st.nextToken());
    int m = Integer.parseInt(st.nextToken());
    int k = Integer.parseInt(br.readLine());
    map = new int[m+1][n+1];
    dp = new long[m+1][n+1];
//    dp[0][0] = 1;
    visited = new boolean[m+1][n+1];
    count = 0;
    // x-1 1
    // y-1 2
    // x-1 y-1 3
    for (int i = 0; i < k; i++) {
      st = new StringTokenizer(br.readLine());
      int x = Integer.parseInt(st.nextToken());
      int y = Integer.parseInt(st.nextToken());
      int x2 = Integer.parseInt(st.nextToken());
      int y2 = Integer.parseInt(st.nextToken());
//      map[y][x][y2][x2] = 1;
//      map[y2][x2][y][x] = 1;
      if(x==x2) {
        if(y>y2) {
          if(map[y][x]==1 || map[y][x] == 3) {
            map[y][x] = 3;
          } else {
            map[y][x] = 2;
          }
        } else {
          if(map[y2][x2]==1 || map[y2][x2] == 3) {
            map[y2][x2] = 3;
          } else {
            map[y2][x2] = 2;
          }
        }
      }
      if(y==y2) {
        if(x>x2) {
          if(map[y][x]==2 || map[y][x] == 3) {
            map[y][x] = 3;
          } else {
            map[y][x] = 1;
          }
        } else {
          if(map[y2][x2]==2 || map[y2][x2] == 3) {
            map[y2][x2] = 3;
          } else {
            map[y2][x2] = 1;
          }
        }
      }
    }
//    for(int i = 0; i <= m; i++) {
//      for(int j = 0; j <= n; j++) {
//        System.out.print(map[i][j] + " ");
//      }
//      System.out.println();
//    }
    dp[0][0] = 1;
    visited[0][0] = true;
    System.out.println(counter(n, m));
//    for(int i = 0; i <= m; i++) {
//      for(int j = 0; j <= n; j++) {
//        System.out.print(dp[i][j] + " ");
//      }
//      System.out.println();
//    }
  }
  static long counter(int x, int y) {
    if(dp[y][x] == 0 && !visited[y][x]) {
      visited[y][x] = true;
      if(y>0) {
        if(map[y][x] != 2 && map[y][x] != 3) {
          dp[y][x] += counter(x, y-1);
        }

      }
      if(x>0) {
        if(map[y][x] != 1 && map[y][x] != 3) {
          dp[y][x] += counter(x-1, y);
        }
      }
    }
    return dp[y][x];
  }
}
