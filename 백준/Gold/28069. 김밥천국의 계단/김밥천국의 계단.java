import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

  static boolean answer;
  static int N, k;
  static Integer[] dp;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken()); //계단 개수
    k = Integer.parseInt(st.nextToken()); // 계단 오르는 횟수
    dp = new Integer[N + 1];
    Arrays.fill(dp, 1000001);
    dp[0] = 0;
    for(int i = 0; i < N; i++) {
      if(i+1 <=N) {
        dp[i+1] = Math.min(dp[i+1], dp[i]+1);
      }
      if(i+i/2 <=N) {
        dp[i+i/2] = Math.min(dp[i+i/2], dp[i] + 1);
      }
    }
      System.out.println(dp[N]<=k ? "minigimbob":"water");
  }
}
