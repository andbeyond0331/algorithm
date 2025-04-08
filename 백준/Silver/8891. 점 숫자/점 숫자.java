import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st;
		for(int i = 0; i < T; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int ax = 0;
			int ay = 0;
			int bx = 0;
			int by = 0;
			int[] am = find(a);
			int[] bm = find(b);
			int tx = am[0]+bm[0];
			int ty = am[1]+bm[1];
            
			System.out.println(loc(tx, ty));
			}
	}
	static int loc(int x, int y) {
		int target = x + y;
        int temp = (target-2)*(target-1)/2;
		
		return temp+x;
	}
	static int[] find(int a) {
		int idx = 0;
		while(idx*(idx+1)/2<a) {
			idx++;
		}
		idx--;
		int temp = idx*(idx+1)/2;
        int[] re = new int[2];
        re[0] = a-temp;
        re[1] = idx+2-a+temp;
		return re;
	}
}