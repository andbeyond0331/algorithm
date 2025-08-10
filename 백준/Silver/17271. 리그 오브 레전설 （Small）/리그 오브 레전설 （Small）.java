import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
  static final int MOD = 1_000_000_007;
  static long[] dp;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(st.nextToken());
    int m = Integer.parseInt(st.nextToken());
    dp = new long[n+1];
    dp[0] = 0;
    // dp[i] = dp[i-1][dp[i-m]
    for(int i = 1; i <m; i++) {
      if(i>n) {
        break;
      }
      dp[i] = 1;
    }
    if(m<=n) {

      dp[m] = 2;
    }
    for(int i = m+1; i <= n; i++) {
      dp[i] = (dp[i-1] + dp[i-m]) % MOD;
    }
    System.out.println(dp[n]);
  }

}
