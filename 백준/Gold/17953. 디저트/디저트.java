import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(st.nextToken()); // 한 주기의 날짜 수
    int m = Integer.parseInt(st.nextToken()); // 디저트 종류의 수
    int[][] satisfactions = new int[m][n];
    for (int i = 0; i < m; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < n; j++) {
        satisfactions[i][j] = Integer.parseInt(st.nextToken());
      }
    }
    int[][] dp = new int[m][n];
    for(int i = 0; i < m; i++) {
      dp[i][0] = satisfactions[i][0];
    }
    for (int i = 1; i < n; i++) {
      for (int j = 0; j < m; j++) {
        int max = -1;
        int idx = 0;
        for(int k = 0; k < m; k++) {
          if(k==j) {
            max = Math.max(max, dp[k][i-1] + satisfactions[j][i]/2);
          } else {
            max = Math.max(max, dp[k][i-1] + satisfactions[j][i]);
          }
//          if(k==j) {
//            max = Math.max(max, satisfactions[k][i-1]/2);
//          } else {
//            max = Math.max(max, satisfactions[k][i-1]);
//          }
        }
//        if(idx == j) {
//          dp[j][i] += max + satisfactions[idx][i]/2;
//        } else {
//          dp[j][i] += max + satisfactions[idx][i];
//        }
        dp[j][i] = max;
      }
    }
//    for(int i = 0; i < m; i++) {
//      for(int j = 0; j < n; j++) {
//        System.out.print(dp[i][j] + " ");
//      }
//      System.out.println();
//    }
    int max = -1;
    for(int i = 0; i < m; i++) {
      max = Math.max(max, dp[i][n-1]);
    }
    System.out.println(max);
  }
}
