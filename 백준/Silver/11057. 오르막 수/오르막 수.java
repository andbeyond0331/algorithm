
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static int[][] memo;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		memo = new int[N][10];
		int answer = 0;
		for(int i = 0; i < memo[0].length; i++) {
			memo[N-1][i] = 1;
		}
//		for(int i = 0; i < N; i++) {
//			dp(N, )
//		}
		for(int i = 0; i < memo[0].length; i++) {
			dp(0, i);
		}
//		dp(0, 0);
		for(int i = 0; i < memo[0].length; i++) {
			answer=(answer+memo[0][i]) % 10007;
		}
//		for(int i = 0;i < memo.length;i++ ) {
//			for(int j = 0; j < memo[0].length;j++) {
//				System.out.print(memo[i][j] + " ");
//			}
//			System.out.println();
//		}
		System.out.println(answer);
	}

	static int dp(int a, int b) {
		if(a == memo.length-1) {
			return memo[a][b];
		}
		if(memo[a][b] == 0) {
			for(int i = b; i < 10; i++) {
				memo[a][b] = (memo[a][b] + dp(a+1, i)) % 10007;
			}
		}
		return memo[a][b];
//		if(a==memo.length-1) {
//			for(int i = 0; i < memo[a].length; i++) {
//				memo[a][i] = 1;
//			}
//		} else {
//			for(int i = 0; i < memo[a].length; i++) {
//
//			}
//		}

	}
}
