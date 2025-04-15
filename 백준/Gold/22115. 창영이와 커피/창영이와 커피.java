import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int N = Integer.parseInt(st.nextToken());
    int K = Integer.parseInt(st.nextToken());
    int[] c = new int[N];
    int[][] dp = new int[N][K+1];
    final int inf = 100001;
    for(int i = 0; i < N; i++) {
      for(int j = 0; j <= K; j++) {
        if(j==0) {
          dp[i][j] = 0;
        } else {

          dp[i][j] = inf;
        }
      }
    }
    st = new StringTokenizer(br.readLine());
    for(int i = 0; i < N; i++) {
      c[i] = Integer.parseInt(st.nextToken());
    }
    for(int i = 0; i < N; i++) {
      for(int j = K; j > 0; j--) {
        if(i==0) {
          if(c[i]==j) {
            dp[i][j] = 1;
          }
        } else {
          if(j-c[i]>=0) {

            dp[i][j] = Math.min(dp[i-1][j-c[i]]+1, dp[i-1][j]);
          }else{
            dp[i][j] = dp[i-1][j];
          }
        }
      }
    }
    if(dp[N-1][K] == inf) {
      System.out.println(-1);
    }else {
      System.out.println(dp[N-1][K]);
    }
  }
}
