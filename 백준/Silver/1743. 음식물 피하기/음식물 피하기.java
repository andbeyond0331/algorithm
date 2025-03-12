import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
  static int n, m, k;
  static int[][] route;
  static int max;
  static int temp;
  static int[] dr = {-1, 1, 0, 0};
  static int[] dc = {0, 0, -1, 1};
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());
    k = Integer.parseInt(st.nextToken());
    route = new int[n][m];
    for (int i = 0; i < k; i++) {
      st = new StringTokenizer(br.readLine());
      route[Integer.parseInt(st.nextToken())-1][Integer.parseInt(st.nextToken())-1] = 1;
    }
    max = -1;
    temp = 0;
    for(int i = 0; i < n; i++) {
      for(int j = 0; j < m; j++) {
        if(route[i][j] == 1) {
          food(i, j);
          max = Math.max(max, temp);
          temp = 0;
        }
      }
    }
//    for(int i = 0; i < n; i++) {
//      for(int j = 0; j < m; j++) {
//        System.out.print(route[i][j] + " ");
//      }
//      System.out.println();
//    }
    System.out.println(max);
  }
  static void food(int r, int c) {
    route[r][c] = 2;
    temp++;
    for(int i = 0;i < dr.length;i++) {
      int nr = r + dr[i];
      int nc = c + dc[i];
      if(nr >= 0 && nr < n && nc >= 0 && nc < m && route[nr][nc] == 1) {
        food(nr, nc);
      }
    }
  }

}
