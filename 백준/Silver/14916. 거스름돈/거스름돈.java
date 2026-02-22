import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    int[] dp = new int[n + 1];
    if(n>=2) {
      dp[2] = 1;
    }
    if(n>=5) {
      dp[5] = 1;
    }
    for(int i = 3; i <= n; i++) {
      int temp = Integer.MAX_VALUE;
      if(dp[i-2]!=0) {
        temp = Math.min(temp, dp[i-2]+1);
      }
      if(i-5>=0 && dp[i-5]!=0) {
        temp = Math.min(temp, dp[i-5]+1);
      }
      if(temp>0 && temp<Integer.MAX_VALUE) {
        dp[i] = temp;
      }
    }
    if(dp[n]==0) {
      System.out.println(-1);
    } else {
      System.out.println(dp[n]);
    }
  }
}
