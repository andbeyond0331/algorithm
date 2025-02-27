
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[][][] memo;
	static int[][] home;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		memo = new int[N][N][3];
		home = new int[N][N];
		StringTokenizer st;
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++) {
				home[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		memo[0][1][0] = 1;
//		입력 받고 2차 배열 선언
//
//		arr[n-1][n-1]에 최종 경우의 수 저장
//
//		arr[x][y]가 0이면 arr[x-1][y] + arr[x-1][y-1] + arr[x][y-1] 저장
//
//		근데 저 세 개 중 벽이거나 집 크기를 벗어나면 안 됨
//
//		그리고 y가 0이면 무조건 0.(왼쪽으론 못감)
		dp(N-1, N-1, 0);
		dp(N-1, N-1, 1);
		dp(N-1, N-1, 2);
//		for(int i = 0; i < N; i++) {
//			for(int j = 0; j < N; j++) {
//				System.out.print(memo[i][j][0] + "" + memo[i][j][1] + ""+ memo[i][j][2] + " ");
//			}
//			System.out.println();
//		}
//		for(int i = 0; i < N; i++) {
//			for(int j = 0; j < N; j++) {
//				System.out.print(home[i][j]);
//			}
//			System.out.println();
//		}
		int answer = memo[N-1][N-1][0] + memo[N-1][N-1][1] + memo[N-1][N-1][2];
		System.out.println(answer);
	}
	// 0: 가로 1: 세로 2:대각선

	static int dp(int a, int b, int c) {
		if(b == 0) {
			return 0;
		}

		if(!check(a, b)) {
			return 0;
		}

		if(memo[a][b][c] == 0) {
			if(c==2) {
				int temp = 0;
				if(!check(a-1, b) || !check(a, b-1)) {
				}else {
					temp = dp(a-1, b-1, 2)+ dp(a-1, b-1, 0) + dp(a-1, b-1, 1);
				}
				memo[a][b][c] = temp;
			}else if(c==1) {
				memo[a][b][c] = dp(a-1, b, 2) + dp(a-1, b, 1);
			} else if(c==0) {
				memo[a][b][c] = dp(a, b-1, 0) + dp(a, b-1, 2);
			}
		}
		return memo[a][b][c];
	}
	static boolean check(int a, int b) {
		if(a>=0 && a < memo.length && b >= 0 && b < memo.length && home[a][b] != 1) {
			return true;
		}
		return false;
	}
}
