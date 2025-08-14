import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	public static int min = Integer.MAX_VALUE;
	public static int max = Integer.MIN_VALUE;
	
	//아래쪽, 오른쪽 이동을 위한 변수
	public static int[] dx = {1, 0};
	public static int[] dy = {0, 1};
	
	public static int n;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		n = N;
		String[][] map = new String[N][N];
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				map[i][j] = sc.next();
			}
		}
		
		dfs(0, 0, Integer.parseInt(map[0][0]), map[0][0], map);
		System.out.println(max + " " + min);
	}
	
	public static void dfs(int x, int y, int ans, String what, String[][] map) {
		for(int i = 0; i < 2; i++) { //첫 번째 숫자 / 연산자 / 두 번째 숫자 순이기 때문에 i < 2;
			int nx = x + dx[i];
			int ny = y + dy[i];
			
			if(nx <= n-1 && ny <= n-1) { //이차원 배열의 범위 안에 있을 때
				if(map[nx][ny].equals("+")) {
					dfs(nx, ny, ans, "+", map);
				} else if(map[nx][ny].equals("-")) {
					dfs(nx, ny, ans, "-", map);
				} else if(map[nx][ny].equals("*")) {
					dfs(nx, ny, ans, "*", map);
				} else { //숫자일 경우 
					int result = 0;
					
					if(what.equals("+")) { //이전의 값이 연산자일 경우 계산
						result = ans + Integer.parseInt(map[nx][ny]);
					} else if(what.equals("-")) {
						result = ans - Integer.parseInt(map[nx][ny]);
					} else if(what.equals("*")) {
						result = ans * Integer.parseInt(map[nx][ny]);
					} 
                    
					//(N, N) 마지막일 경우 min, max 구하기
					if(nx == n-1 && ny == n-1) {
						max = Math.max(max, result);
						min = Math.min(min, result);
						
						return;
					}
                    
					dfs(nx, ny, result, map[nx][ny], map);
				}
			}
		}
	}
}