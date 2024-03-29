package main.java.algorithm.boj.tier.gold.p17070_파이프옮기기1_unsolved;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	static int[][] dp;
	static int[][] home;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine()); // 집의 크기 3 ~ 16

		dp = new int[N][N];
		home = new int[N][N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				home[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		// dp 이용,

		bw.append(sb);
		bw.flush();
		br.close();
		bw.close();

	}

	static int sum (int x, int y){

		return 0;
	}
}
