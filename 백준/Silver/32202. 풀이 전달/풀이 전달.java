import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
  static final int MOD = (int) Math.pow(10, 9) + 7;
  static int[] dp;
  static int n;
  public static void main(String[] args) throws IOException {
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    n = Integer.parseInt(bufferedReader.readLine().trim());
    dp = new int[2];
    dp[0] = 1;
    dp[1] = 2;
    for(int i = 1; i < n; i++) {
      int prev0 = dp[0];
      int prev1 = dp[1];
      dp[0] = prev1;
      dp[1] = (prev0 +prev1) % MOD;
      dp[1] = (dp[1] *2) % MOD;
    }
    System.out.println((dp[0] + dp[1])%MOD);
  }
}