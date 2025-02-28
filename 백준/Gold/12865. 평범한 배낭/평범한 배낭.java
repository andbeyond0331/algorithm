
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	static int N, K;
	static int[] w, v;
	static Integer[][] sack;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		w = new int[N];
		v = new int[N];
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			w[i] = Integer.parseInt(st.nextToken());
			v[i] = Integer.parseInt(st.nextToken());
		}
		sack = new Integer[N][K+1];
		System.out.println(pack(N-1, K));
//		for(int i = 0; i < N; i++) {
//			for(int j = 0; j <=K; j++) {
//				System.out.print(sack[i][j] +" ");
//			}
//			System.out.println();
//		}
	}
	static int pack(int i, int j) {
		if(i<0) {
			return 0;
		}
		if(sack[i][j]==null) {
			if(w[i]>j) {
				sack[i][j] = pack(i-1, j);
			}else {
				sack[i][j] = Math.max(pack(i-1, j-w[i]) + v[i], pack(i-1, j));

			}
		}
		return sack[i][j];
	}
}
