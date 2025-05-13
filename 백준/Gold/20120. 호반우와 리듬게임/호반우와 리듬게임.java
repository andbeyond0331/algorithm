import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
  static final long NEG_INF = Long.MIN_VALUE / 4;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    int[] notes = new int[n+1];
    StringTokenizer st = new StringTokenizer(br.readLine());
    for (int i = 1; i <= n; i++) {
      notes[i] = Integer.parseInt(st.nextToken());
    }

    long[][] dp = new long[n+1][n+1];
    // initialize dp with very negative values
    for (int i = 0; i <= n; i++) {
      for (int j = 0; j <= n; j++) {
        dp[i][j] = NEG_INF;
      }
    }

    // base cases: at first note, either hit (combo 1) or skip (combo 0)
    dp[1][1] = (long)notes[1];
    dp[1][0] = 0L;

    for (int i = 1; i < n; i++) {
      for (int combo = 0; combo <= i; combo++) {
        long curr = dp[i][combo];
        if (curr == NEG_INF) continue;
        // 1) play note i+1 (increase combo by 1)
        dp[i+1][combo+1] = Math.max(dp[i+1][combo+1],
            curr + (long)notes[i+1] * (combo+1));

        // 2) skip exactly one note: jump to i+2, reset combo to 1 if within bounds
        if (i+2 <= n) {
          dp[i+2][1] = Math.max(dp[i+2][1],
              curr + notes[i+2]);
        } else {
          // if skipping lands beyond n, update dp[n][0] (end state)
          dp[n][0] = Math.max(dp[n][0], curr);
        }

        // 3) skip two notes: jump to i+3, reset combo to 1, but avoid invalid from start
        if (!(i == 1 && combo == 0)) {
          if (i+3 <= n) {
            dp[i+3][1] = Math.max(dp[i+3][1],
                curr + notes[i+3]);
          } else {
            dp[n][0] = Math.max(dp[n][0], curr);
          }
        }
      }
    }

    // answer: the best value at the end across all possible combos
    long answer = 0;
    for (int combo = 0; combo <= n; combo++) {
      answer = Math.max(answer, dp[n][combo]);
    }

    System.out.println(answer);
  }
}
