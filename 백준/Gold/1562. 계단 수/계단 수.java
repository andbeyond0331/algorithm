import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    int[][][] dp = new int[n+1][11][1<<10];
    int mod = 1000000000;
    for(int i = 1; i < 10; i++) {
      dp[1][i][1<<i] = 1;
    }
    int sum = 0;
    for(int i = 2; i <= n; i++) {
      for(int j = 0; j < 10; j++) {
        for(int k = 0; k < 1024; k++) {
          int bit = k | (1 << j);
          if(j==0) {
            dp[i][j][bit] = (dp[i][j][bit] + dp[i-1][j+1][k]) % mod;
          } else if(j == 9) {
            dp[i][j][bit] = (dp[i][j][bit] + dp[i-1][j-1][k]) % mod;
          } else{
            dp[i][j][bit] = (dp[i][j][bit] + dp[i-1][j+1][k] + dp[i-1][j-1][k]) % mod;
          }
//          if(k-1 >=0) {
//            dp[i][j][k | (1<<j)] += dp[i-1][j-1][k];
//          }
//          if(k+1<=9) {
//            dp[i][j][k | (1<<j)] += dp[i-1][j+1][k];
//          }
//          dp[i][j][k | (1<<j)] %= mod;
        }
      }
    }
    for(int i = 0; i < 10; i++) {
      sum += dp[n][i][1023];
      sum %= mod;
    }
    System.out.println(sum);
  }
}
