import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
  static int[] dp;
  static int[][] meetings;
  static int n;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    n = Integer.parseInt(br.readLine());
    meetings = new int[n][3];
    StringTokenizer st;
    for(int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine());
      for(int j = 0; j < 3; j++) {
        meetings[i][j] = Integer.parseInt(st.nextToken());
      }
    }
    dp = new int[n];
    dp[0] = meetings[0][2];
    if(n==1) {
      System.out.println(dp[0]);
      return;
    }
    dp[1] = Math.max(dp[0], meetings[1][2]);
    for(int i = 2;i < n; i++) {
      dp[i] = Math.max(dp[i-1], dp[i-2] + meetings[i][2]);
    }
    System.out.println(dp[n-1]);
  }
}
