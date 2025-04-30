import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int m = Integer.parseInt(st.nextToken());
    int n = Integer.parseInt(st.nextToken());
    int[][] dp = new int[m][n];
    int[][] land = new int[m][n];
    int max = 0;
    for(int i = 0; i < m; i++) {
      st = new StringTokenizer(br.readLine());
      for(int j = 0; j < n; j++) {
        land[i][j] = Integer.parseInt(st.nextToken());
      }
    }
    for(int i = 0; i < m; i++) {
      for(int j = 0; j < n; j++) {
        if(i==0) {
          if(land[i][j] == 0) {
            dp[i][j] = 1;
          } else {
            dp[i][j] = 0;
          }
        } else {
          if(j==0) {
            if(land[i][j] == 0) {
              dp[i][j] = 1;
            } else {
              dp[i][j] = 0;
            }
          } else {
            if(land[i][j] == 0) {
              dp[i][j] = Math.min(dp[i-1][j], Math.min(dp[i-1][j-1], dp[i][j-1])) + 1;
            }
          }
        }
        max = Math.max(max, dp[i][j]);
      }
    }
    System.out.println(max);
  }
}
