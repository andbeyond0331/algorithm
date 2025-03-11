import java.util.Scanner;

public class Main {

	static int GCD(int n1, int n2) {
		if(n2 ==0) return n1;
		else return GCD(n2,n1%n2);
	}
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int n =sc.nextInt(); //동생의 수
		int s = sc.nextInt(); //나의 위치
		int [] arr = new int[n];
		
		for(int i=0; i<n; i++) {
			int a = sc.nextInt(); //동생의 위치
			arr[i] = Math.abs(s-a); // 내위치와 동생의 위치 차이 저장
		}
		
		int gcd = arr[0];
		for(int i=1; i<arr.length; i++) {
			gcd = GCD(gcd,arr[i]);
		}
		System.out.println(gcd);
		
	}

}