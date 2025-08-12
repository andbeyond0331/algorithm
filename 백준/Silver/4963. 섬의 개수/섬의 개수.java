
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	static int[] dr = {1, -1, 0, 0, 1, 1, -1, -1};
	static int[] dc = {0, 0, 1, -1, 1, -1, 1, -1};
	static boolean[][] visited;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		String str;

		while(!(str = br.readLine()).equals("0 0")){
			StringTokenizer st = new StringTokenizer(str);
			int w = Integer.parseInt(st.nextToken());
			int h = Integer.parseInt(st.nextToken());

			int[][] map = new int[h][w];

			for (int i = 0; i < h; i++) {
				StringTokenizer st2 = new StringTokenizer(br.readLine());
				for (int j = 0; j < w; j++) {
					map[i][j] = Integer.parseInt(st2.nextToken());
				}
			}

			// 섬 모양 잘 받아와?
//			for (int i = 0; i < h; i++) {
//				for (int j = 0; j < w; j++) {
//					System.out.print(map[i][j] + " ");
//				}
//				System.out.println();
//			}
			// 응응

			// 그럼 탐색하자!
			// 지도의 네모를 다 볼 건데 search에 들어갈 때마다 ++해줄거고 search에서는 주변에 아무것도 없을 때까지 return하지 않을거야
			// search는 visited가 false이고 map에서 1인 애들만 탐색하고 그렇지 않은 애는 방문했다고 기록하는 애야
			visited = new boolean[h][w];
			int result = 0;
			for (int i = 0; i < h; i++) {
				for (int j = 0; j < w; j++) {
					if(!visited[i][j] && map[i][j] == 1){

						search(map, i, j);
						result++;
					}
				}
			}
			sb.append(result).append("\n");


//			System.out.println("w: " + w + ", h: " + h);
		}


		bw.append(sb);
		bw.flush();
		br.close();
		bw.close();

	}

	static void search(int[][] map, int r, int c){
		visited[r][c] = true;

		for (int i = 0; i < dr.length; i++) {
			int nr = r + dr[i];
			int nc = c + dc[i];

			if(nr>=0 && nr<map.length && nc>=0 && nc<map[0].length){
				if(!visited[nr][nc] && map[nr][nc] == 1){
					search(map, nr, nc);
				}
			}
		}
	}
}
