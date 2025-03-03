import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	static int m, n, k;
	static int[][] paper;
	static int[] dr = {1, -1, 0, 0};
	static int[] dc = {0, 0, 1, -1};
	static boolean[][] visited;
	static Map<Integer, Integer> size;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		m = Integer.parseInt(st.nextToken()); // 세로
		n = Integer.parseInt(st.nextToken()); // 가로
		k = Integer.parseInt(st.nextToken());
		int x1, y1, x2, y2;
		size = new HashMap<>();
		paper = new int[m+1][n+1];
		visited = new boolean[m][n];
		int count = k;
		for(int i = 0; i < k; i++) {
			st = new StringTokenizer(br.readLine());
			x1 = Integer.parseInt(st.nextToken());
			y1 = Integer.parseInt(st.nextToken());
			x2 = Integer.parseInt(st.nextToken());
			y2 = Integer.parseInt(st.nextToken());
			for(int j = y1; j < y2; j++) {
				paper[j][x1]++;
				paper[j][x2]--;
			}
		}
		for(int i = 0; i <=m; i++) {
			for(int j = 0; j <=n; j++) {
				if(j !=0) {
					paper[i][j] += paper[i][j-1];
				}
			}
		}
		for(int i = 0; i <m; i++) {
			for(int j = 0; j < n; j++) {
//				System.out.print(paper[i][j] + " ");
				if(!visited[i][j] && paper[i][j]==0) {
					size.put(++k, 1);
					visited[i][j] = true;
					dfs(i, j, k);
				}
			}
//			System.out.println();
		}
		System.out.println(k-count);
		List<Integer> answer = new ArrayList<>();
		for(int i : size.keySet()) {
			answer.add(size.get(i));
		}
		answer.sort(Comparator.naturalOrder());
		for(int i: answer) {
			System.out.print(i + " ");
		}
	}
	static void dfs(int r, int c, int num) {
		for(int i =0; i < dr.length; i++) {
			int nr = r + dr[i];
			int nc = c + dc[i];
			if(check(nr, nc)) {
				visited[nr][nc] = true;
				size.put(num, size.get(num) + 1);
				dfs(nr, nc, num);
			}
		}
	}
	static boolean check(int r, int c) {
		if(r>=0 && r<m && c>=0 && c<n && !visited[r][c] && paper[r][c] == 0) {
			return true;
		}
		return false;
	}
}
