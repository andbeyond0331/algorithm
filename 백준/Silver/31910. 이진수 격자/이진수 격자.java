import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
  static int[] dr = {1, 0};
  static int[] dc = {0, 1};
  static int[][] matrix;
  static int N;
  static long answer;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    N = Integer.parseInt(br.readLine());
    answer = 0;
    matrix = new int[N][N];
    long[][] dp = new long[N][N];
    for (int i = 0; i < N; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      for (int j = 0; j < N; j++) {
        matrix[i][j] = Integer.parseInt(st.nextToken());
//        dp[i][j] = matrix[i][j];
      }
    }
    dp[0][0] = matrix[0][0];
    for(int i = 1; i < N; i++) {
      dp[0][i] = dp[0][i-1]*2 + matrix[0][i];
    }
    for(int i = 1; i < N; i++) {
      dp[i][0] = dp[i-1][0]*2 + matrix[i][0];
    }
    for(int i = 1; i < N; i++) {
      for(int j = 1; j < N; j++) {
        dp[i][j] = Math.max(dp[i-1][j]*2+matrix[i][j], dp[i][j-1]*2+matrix[i][j]);
      }
    }
    answer = dp[N-1][N-1];
//    move(0, 0, matrix[0][0]);
    System.out.println(answer);
  }

  static void move(int r, int c, long ans) {
    if(r==N-1 && c==N-1){
      if(ans>answer){
        answer = ans;
      }
      return;
    }
    for(int i = 0; i < dr.length; i++) {
      int nr = r+dr[i];
      int nc = c+dc[i];
      if(nr>=0 && nr < N && nc>=0 && nc < N){
        move(nr, nc, ans*2+matrix[nr][nc]);
      }
    }
  }
}
