
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[] memo;
	static int[] coins;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());

		memo = new int[k + 1];
		coins = new int[n];
		for (int i = 0; i < n; i++) {
			coins[i] = Integer.parseInt(br.readLine());
		}
		memo[0] = 1;
		for(int num: coins) {
			for(int i = num; i <=k; i++) {
				memo[i] += memo[i-num];
			}
		}
//		for(int num : memo) {
//			System.out.print(num + " ");
//		}
		System.out.println(memo[k]);
	}
}
