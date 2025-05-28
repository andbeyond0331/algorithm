
import java.io.*;
import java.util.*;

public class Main {
	
	static int h, w, jump;
	static int[][] map;
	static boolean[][] visit;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		h = Integer.parseInt(br.readLine()); // 행의 개수
		w = Integer.parseInt(br.readLine()); // 열의 개수
		
		// 등굣길을 저장할 배열
		map = new int[h][w];
		
		// 갈 수 있는지 없는지 체크하는 배열
		visit = new boolean[h][w];
		
		StringTokenizer st;
		for (int i = 0; i < h; i++) {
			st = new StringTokenizer(br.readLine());
			
			for (int j = 0; j < w; j++) {
				map[i][j] = Integer.parseInt(st.nextToken()); // 보도블럭의 색상
			}
		}
		
		jump = Integer.parseInt(br.readLine()); // 지훈이의 점프력
		
		// 시작과 끝의 보도블럭이 다르면 무조건 실패한다.
		if (map[0][0] != map[h - 1][w - 1]) {
			sb.append("DEAD");
		} else {
			function(0, 0); // 첫 시작점은 왼쪽 위 (0,0)이다.
			
			if (visit[h - 1][w - 1]) { // 갈 수 있다면
				sb.append("ALIVE");
			} else { // 못 간다면
				sb.append("DEAD");
			}
		}
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}
	
	// 갈 수 있는 곳을 체크하는 함수.
	private static void function(int y, int x) {
		int nowy = y;
		int nowx = x;
		int dis; // 거리
		visit[nowy][nowx] = true;
		
		for (int i = 0; i < h; i++) {
			for (int j = 0; j < w; j++) {
				dis = Math.abs(nowy - i) + Math.abs(nowx - j);
				
				// 한번도 가지 않고, 점프하는 거리보다 같거나 작으면서 같은 보드블록이라면
				if (!visit[i][j] && dis <= jump && map[nowy][nowx] == map[i][j]) {
					function(i, j);
				} else if (dis > jump && nowx < j) { // 점프할 수 없는 거리라면
					break;
				}
			}
			
			// 점프할 수 없는 거리라면
			if (Math.abs(nowy - i) > jump && nowy < i) {
				break;
			}
		}
	}
}
