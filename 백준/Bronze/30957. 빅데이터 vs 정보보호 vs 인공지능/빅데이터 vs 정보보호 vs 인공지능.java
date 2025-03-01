
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		String major = br.readLine();
		int b = 0, s = 0, a = 0;
		for(int i = 0;i < N; i++) {
			if(major.charAt(i) == 'B') {
				b++;
			}else if(major.charAt(i) == 'S') {
				s++;
			} else if(major.charAt(i) == 'A') {
				a++;
			}
		}
		int max = Math.max(b, Math.max(s, a));
		String answer = "";
		if(b==max) {
//			System.out.print("B");
			answer+="B";
		}
		if(s == max) {
//			System.out.print("S");
			answer+="S";
		}
		if(a == max) {
//			System.out.print("A");
			answer+="A";
		}
//		System.out.println(answer.length());
		if(answer.length() == 3) {
			System.out.println("SCU");
		} else {
			System.out.println(answer);
		}
//		if(b == s && s == a) {
//			System.out.println("SCU");
//		} else {
//			int max = Math.max(b, Math.max(s, a));
//			if(b==max) {
//				System.out.print("B");
//			}
//			if(s == max) {
//				System.out.print("S");
//			} else if(a == max) {
//				System.out.print("A");
//			}
//		}
	}
}
