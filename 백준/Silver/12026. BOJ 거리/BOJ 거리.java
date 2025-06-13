import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
  static int n;
  static char[] blocks;
  static int[] dp;
  static int count;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    n = Integer.parseInt(br.readLine());
    String line = br.readLine();
    blocks = new char[n];
    dp = new int[n];
    for (int i = 0; i < n; i++) {
      blocks[i] = line.charAt(i);
    }
    Arrays.fill(dp, -1);
    dp[0] = 0;
    int ans = walking(n-1);
    System.out.println(ans);
  }
  static int walking(int cur) {
    if (dp[cur] != -1) return dp[cur];
    int best = Integer.MAX_VALUE;
    char need = (blocks[cur]=='B'?'J': blocks[cur]=='O'?'B':'O');
    for (int i = 0; i < cur; i++) {
      if (blocks[i] == need) {
        int prev = walking(i);
        if (prev != -1) {
          best = Math.min(best, prev + (cur-i)*(cur-i));
        }
      }
    }
    dp[cur] = (best==Integer.MAX_VALUE ? -1 : best);
    return dp[cur];
  }
}
