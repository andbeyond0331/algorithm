
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[][] rgb;
	static int[][] house;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st;
		rgb = new int[N][3];
		house = new int[N][3];
		for(int i = 0;i < N; i++) {
			st = new StringTokenizer(br.readLine());
			rgb[i][0] = Integer.parseInt(st.nextToken());
			rgb[i][1] = Integer.parseInt(st.nextToken());
			rgb[i][2] = Integer.parseInt(st.nextToken());
		}
		house[0][0] = rgb[0][0];
		house[0][1] = rgb[0][1];
		house[0][2] = rgb[0][2];
		house[1][0] = Math.min(rgb[0][1], rgb[0][2]) + rgb[1][0];
		house[1][1] = Math.min(rgb[0][0], rgb[0][2]) + rgb[1][1];
		house[1][2] = Math.min(rgb[0][0], rgb[0][1]) + rgb[1][2];
		for(int i = 2; i < N; i++) {
			// 012 021 102 120 201 210
			if(i==2) {
//				house[i][0] = Math.min(rgb[0][1] + rgb[1][2], rgb[0][2] + rgb[1][1]) + rgb[i][0];
//				house[i][1] = Math.min(rgb[0][0] + rgb[1][2], rgb[0][2] + rgb[1][0]) + rgb[i][1];
//				house[i][2] = Math.min(rgb[0][0] + rgb[1][1], rgb[0][1] + rgb[1][0]) + rgb[i][2];
				house[i][0] = Math.min(house[i-1][1], house[i-1][2]) + rgb[i][0];
				house[i][1] = Math.min(house[i-1][0], house[i-1][2]) + rgb[i][1];
				house[i][2] = Math.min(house[i-1][0], house[i-1][1]) + rgb[i][2];

			} else {
				house[i][0] = Math.min(house[i-1][1], house[i-1][2]) + rgb[i][0];
				house[i][1] = Math.min(house[i-1][0], house[i-1][2]) + rgb[i][1];
				house[i][2] = Math.min(house[i-1][0], house[i-1][1]) + rgb[i][2];
			}
		}
//		for(int i = 0;i < N; i++) {
//			for(int j = 0; j < 3; j++) {
//				System.out.print(house[i][j] + " ");
//			}
//			System.out.println();
//		}
		System.out.println(Math.min(house[N-1][0], Math.min(house[N-1][1], house[N-1][2])));
	}
}
