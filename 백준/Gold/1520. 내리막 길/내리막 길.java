
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[][] map;
	static int[][] memo;
	static int count;
	static int[] dr = {1, -1, 0, 0};
	static int[] dc = {0, 0, 1, -1};
	static boolean[][] visited;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int M = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		memo = new int[M][N];
		map = new int[M][N];
		visited = new boolean[M][N];
		memo[0][0] = 1;

		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		System.out.println(dp(M-1, N-1));

//		System.out.println(count);
	}

	static int dp(int r, int c) {
		if(memo[r][c] == 0 && !visited[r][c]) {
			visited[r][c] = true;
//			int temp = 0;
			for(int i = 0; i < dr.length; i++) {
				int nr = r + dr[i];
				int nc = c + dc[i];
				if(check(nr, nc) && map[nr][nc] > map[r][c]) {
					memo[r][c]+=dp(nr, nc);
				}
			}
		}
		return memo[r][c];
	}
	static boolean check(int r, int c) {
		if(r>=0 && r < memo.length && c >=0 && c < memo[0].length) {
			return true;
		}
		return false;
	}
}
