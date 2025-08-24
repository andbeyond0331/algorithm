import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n, m;
    static int[][] fuel;
    static int[][][] dp; // 0=왼쪽, 1=직선, 2=오른쪽

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        fuel = new int[n][m];
        dp = new int[n][m][3];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                fuel[i][j] = Integer.parseInt(st.nextToken());
                // dp 배열 초기화
                for (int k = 0; k < 3; k++) {
                    dp[i][j][k] = Integer.MAX_VALUE;
                }
            }
        }

        // 첫 번째 행 초기화
        for (int j = 0; j < m; j++) {
            dp[0][j][0] = fuel[0][j];
            dp[0][j][1] = fuel[0][j];
            dp[0][j][2] = fuel[0][j];
        }

        // DP 진행
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < m; j++) {
                // 왼쪽 대각선에서 옴 (k=0)
                if (j > 0) {
                    dp[i][j][0] = Math.min(dp[i][j][0],
                            Math.min(dp[i-1][j-1][1], dp[i-1][j-1][2]) + fuel[i][j]);
                }
                // 직선 위에서 옴 (k=1)
                dp[i][j][1] = Math.min(dp[i][j][1],
                        Math.min(dp[i-1][j][0], dp[i-1][j][2]) + fuel[i][j]);

                // 오른쪽 대각선에서 옴 (k=2)
                if (j < m - 1) {
                    dp[i][j][2] = Math.min(dp[i][j][2],
                            Math.min(dp[i-1][j+1][0], dp[i-1][j+1][1]) + fuel[i][j]);
                }
            }
        }

        // 마지막 행에서 최소값 찾기
        int answer = Integer.MAX_VALUE;
        for (int j = 0; j < m; j++) {
            for (int k = 0; k < 3; k++) {
                answer = Math.min(answer, dp[n-1][j][k]);
            }
        }

        System.out.println(answer);
    }
}
