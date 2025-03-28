import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
  static char[][] matrix;
  static int N, M;
  static int[][] dp;
  static final int mod =  1000000009;
  static boolean[][] visited;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
    matrix = new char[N][M];
    visited = new boolean[N][M];
    for(int i = 0; i < N; i++) {
      String line = br.readLine();
      for(int j = 0; j < M; j++) {
        matrix[i][j] = line.charAt(j);
      }
    }
    dp = new int[N][M];
    dp[N-1][M-1] = 1;

    for(int i = 0; i < N; i++) {
      for(int j = 0; j < M; j++) {
        if(!visited[i][j]) {
          solve(i, j);
        }
      }
    }
    int count = 0;
    for(int i = 0; i < N; i++) {
      for(int j = 0; j < M; j++) {
//        System.out.print(dp[i][j] + " ");
        count = (count + dp[i][j]) % mod;
      }
//      System.out.println();
    }

    System.out.println(count);
  }
  static int solve(int r, int c) {
    if(!visited[r][c]) {
      visited[r][c] = true;
      if(matrix[r][c] == 'E') {
        dp[r][c] = solve(r, c+1) % mod;
      } else if (matrix[r][c] == 'S') {
        dp[r][c] = solve(r+1, c) % mod;
      } else if (matrix[r][c] == 'X') {
        dp[r][c] = 1;
      } else if (matrix[r][c] == 'B') {
        dp[r][c] = (solve(r+1, c) + solve(r, c+1)) % mod;
      }
    }
    return dp[r][c] % mod;
  }
}
