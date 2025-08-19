import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        long[] addLinear = new long[1000002]; // j 계수
        long[] addConst = new long[1000002];  // 상수항

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int l = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());

            addLinear[l] += 1;
            addLinear[r+1] -= 1;

            addConst[l] += -(l-1);
            addConst[r+1] -= -(l-1);
        }

        long linearSum = 0, constSum = 0;
        StringBuilder sb = new StringBuilder();

        for (int i = 1; i <= k; i++) {
            linearSum += addLinear[i];
            constSum += addConst[i];
            long val = linearSum * i + constSum;
            sb.append(val).append(" ");
        }
        System.out.println(sb);
    }
}
