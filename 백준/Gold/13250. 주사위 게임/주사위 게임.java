import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    double[] dp = new double[n + 7];
    for(int i = n-1; i >= 0; i--) {
      dp[i] = 1 + ((dp[i+1] + dp[i+2] + dp[i+3] + dp[i+4] + dp[i+5] + dp[i+6]) / 6);
    }
    System.out.println(dp[0]);
  }
}
