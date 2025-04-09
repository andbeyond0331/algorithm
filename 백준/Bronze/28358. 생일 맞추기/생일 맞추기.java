import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st;
		List<String> days = new ArrayList<>();
		for(int i = 1; i <=12; i++) {
			String temp = "";
			for(int j = 1; j <= 31; j++) {
				if(i==1 || i==3 || i==5 || i==7 || i==8 || i==10 || i==12) {
				} else if(i==2) {
					if(j>29) {
						continue;
					}
				} else {
					if(j>30) {
						continue;
					}
				}
				temp+=i + "" + j;
				days.add(temp);
				temp = "";
			}
		}
		int[] nums;
		for(int i = 0;i < T; i++) {
			int answer = 0;
			st = new StringTokenizer(br.readLine());
			nums = new int[10];
			for(int j = 0; j < 10; j++) {
				nums[j] = Integer.parseInt(st.nextToken());
			}
			o: for(String s : days) {
				for(int k = 0; k < 10; k++) {
					if(nums[k]==1 && s.contains(String.valueOf(k))) {
						continue o;
					}
				}
				answer++;
			}
			System.out.println(answer);
		}
	}
}
			