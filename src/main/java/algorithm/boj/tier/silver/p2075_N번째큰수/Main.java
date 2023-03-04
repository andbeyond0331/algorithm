package main.java.algorithm.boj.tier.silver.p2075_N번째큰수;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());
		PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				pq.add(Integer.parseInt(st.nextToken()));
			}
		}
		for (int i = 0; i < N-1; i++) {
			pq.poll();
		}
		sb.append(pq.poll());

		bw.append(sb);
		bw.flush();
		br.close();
		bw.close();

	}
}
