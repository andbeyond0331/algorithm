import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    StringTokenizer st;
    int[][] colors = new int[N][3];
    int[][][] dp = new int[3][N][3];
    int max = Integer.MAX_VALUE;
    for(int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine());
      for(int j = 0; j < 3; j++) {
        colors[i][j] = Integer.parseInt(st.nextToken());
      }
    }
    if(N==1) {
      System.out.println(Math.min(colors[0][0], Math.min(colors[0][1], colors[0][2])));
      return;
    } else if(N==2) {
      int red = Math.min(colors[0][1], colors[0][2]) + colors[1][0];
      int green = Math.min(colors[0][0], colors[0][2]) + colors[1][1];
      int blue = Math.min(colors[0][0], colors[0][1]) + colors[1][2];
      System.out.println(Math.min(red, Math.min(green, blue)));
      return;
    }
    dp[0][0][0] = colors[0][0];
    dp[1][0][1] = colors[0][1];
    dp[2][0][2] = colors[0][2];
    dp[0][0][1] = max;
    dp[0][0][2] = max;
    dp[1][0][0] = max;
    dp[1][0][2] = max;
    dp[2][0][0] = max;
    dp[2][0][1] = max;
    dp[0][1][0] = max;
    dp[0][1][1] = dp[0][0][0] + colors[1][1];
    dp[0][1][2] = dp[0][0][0] + colors[1][2];
    dp[1][1][0] = dp[1][0][1] + colors[1][0];
    dp[1][1][1] = max;
    dp[1][1][2] = dp[1][0][1] + colors[1][2];
    dp[2][1][0] = dp[2][0][2] + colors[1][0];
    dp[2][1][1] = dp[2][0][2] + colors[1][1];
    dp[2][1][2] = max;

    for(int j = 2; j < N; j++) {
      for(int i = 0; i < 3; i++) {
        dp[i][j][0] = Math.min(dp[i][j-1][1], dp[i][j-1][2]) + colors[j][0];
        dp[i][j][1] = Math.min(dp[i][j-1][0], dp[i][j-1][2]) + colors[j][1];
        dp[i][j][2] = Math.min(dp[i][j-1][1], dp[i][j-1][0]) + colors[j][2];
      }
    }
//    System.out.println("====1===");
//    for(int i = 0; i < N; i++) {
//      for(int j = 0; j < 3; j++) {
//        System.out.print(dp[0][i][j] + " ");
//      }
//      System.out.println();
//    }
//    System.out.println("====2===");
//    for(int i = 0; i < N; i++) {
//      for(int j = 0; j < 3; j++) {
//        System.out.print(dp[1][i][j] + " ");
//      }
//      System.out.println();
//    }
//    System.out.println("====3===");
//    for(int i = 0; i < N; i++) {
//      for(int j = 0; j < 3; j++) {
//        System.out.print(dp[2][i][j] + " ");
//      }
//      System.out.println();
//    }
    System.out.println(Math.min(dp[0][N-1][1], Math.min(dp[0][N-1][2], Math.min(dp[1][N-1][0], Math.min(dp[1][N-1][2], Math.min(dp[2][N-1][0], dp[2][N-1][1]))))));
//    for(int i = 0; i < 3; i++) {
//      for(int j = 1; j < N; j++) {
//        dp[i][]
//      }
//    }
  }
}
