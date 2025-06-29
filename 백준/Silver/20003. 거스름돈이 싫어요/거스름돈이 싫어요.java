import java.io.*;
import java.util.*;

public class Main {
    // 최대공약수
    static long gcd(long a, long b) {
        while (b != 0) {
            long t = b;
            b = a % b;
            a = t;
        }
        return a;
    }
    // 최소공배수
    static long lcm(long a, long b) {
        return a / gcd(a,b) * b;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine().trim());
        
        long Gnum = 0;        // 분자들의 GCD
        long Lden = 1;        // 분모들의 LCM
        
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            long A = Long.parseLong(st.nextToken());
            long B = Long.parseLong(st.nextToken());
            // 1) 기약분수로 만들기
            long g = gcd(A, B);
            long a = A / g;
            long b = B / g;
            // 2) 분자 GCD 갱신
            Gnum = (i == 0 ? a : gcd(Gnum, a));
            // 3) 분모 LCM 갱신
            Lden = lcm(Lden, b);
        }
        
        // 4) P/Q = Gnum / Lden, 다시 기약분수로
        long g2 = gcd(Gnum, Lden);
        long P = Gnum / g2;
        long Q = Lden / g2;
        
        System.out.println(P + " " + Q);
    }
}
