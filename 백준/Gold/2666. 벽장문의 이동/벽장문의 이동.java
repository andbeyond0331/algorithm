import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
  static int n;
  static int one, two;
  static int[] closet;
  static int closetCount;
  static Integer[][][] dp;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
     n = Integer.parseInt(br.readLine());
    StringTokenizer st = new StringTokenizer(br.readLine());
     one = Integer.parseInt(st.nextToken());
     two = Integer.parseInt(st.nextToken());
     closetCount = Integer.parseInt(br.readLine());
     closet = new int[closetCount];
    dp = new Integer[closetCount][n+1][n+1];
    for(int i = 0; i < closetCount; i++) {
      closet[i] = Integer.parseInt(br.readLine());
    }
    System.out.println(solve(0, one, two));
  }
  static int solve(int openIdx, int o, int t) {
    if(openIdx == closetCount) {
      return 0;
    }
    if(dp[openIdx][o][t] != null) {
      return dp[openIdx][o][t];
    }
    int oCnt = solve(openIdx + 1, closet[openIdx], t) + Math.abs(closet[openIdx] - o);
    int tCnt = solve(openIdx + 1, o, closet[openIdx]) + Math.abs(closet[openIdx] - t);
    dp[openIdx][o][t] = Math.min(oCnt, tCnt);
    return dp[openIdx][o][t];
  }
}
