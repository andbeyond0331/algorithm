import java.io.*;
import java.util.*;

public class Main {
	
	static int n;
	static int[] uparr, doarr;
	static int upcount = 0; // 오름차순
	static int downcount = 1; // 내림차순, 배열 전체 뒤집기 +1
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		n = Integer.parseInt(br.readLine()); // 원소의 개수
		StringTokenizer st = new StringTokenizer(br.readLine()); // 서로 다른 정수 배열
		
		uparr = new int[n]; // 오름차순
		doarr = new int[n]; // 내림차순
		for (int i = 0; i < n; i++) {
			uparr[i] = Integer.parseInt(st.nextToken());
			doarr[i] = uparr[i];
		}
		
		ascend(); // 오름차순 정렬
		descend(); // 내림차순 정렬
		
		bw.write(Integer.toString(Math.min(upcount, downcount)));
		bw.flush();
		bw.close();
		br.close();
	}
	
	// 오름차순 정렬
	private static void ascend() {
		boolean run = true;
		int sub;
		
		while (run) {
			boolean check = false;
			
			for (int i = 0; i < n - 1; i++) {
				if (uparr[i] > uparr[i + 1]) { // 앞에 원소가 더 작다면
					check = true;
					sub = uparr[i + 1];
					uparr[i + 1] = uparr[i];
					uparr[i] = sub;
					upcount++;
				}
			}
			
			if (!check) { // 정렬이 완료되면 종료
				run = false;
			}
		}
	}
	
	// 내림차순 정렬
	private static void descend() {
		boolean run = true;
		int sub; 
		
		while (run) {
			boolean check = false;
			
			for (int i = 0; i < n - 1; i++) {
				if (doarr[i] < doarr[i + 1]) { // 앞에 원소가 더 크다면
					check = true;
					sub = doarr[i + 1];
					doarr[i + 1] = doarr[i];
					doarr[i] = sub;
					downcount++;
				}
			}
			
			if (!check) { // 정렬이 완료되면 종료
				run = false;
			}
		}
	}
}