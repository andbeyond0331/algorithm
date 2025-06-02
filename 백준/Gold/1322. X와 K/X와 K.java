import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long x = Long.parseLong(st.nextToken());
        long k = Long.parseLong(st.nextToken());

        List<Long> availableBits = new ArrayList<>();
        long curNum = 1;

        while ((1L << availableBits.size()) <= k) {
            if ((x | curNum) != x) {
                availableBits.add(curNum);
            }
            curNum <<= 1;
        }

        long result = 0;
        for (int i = availableBits.size() - 1; i >= 0; i--) {
            if (k == 0) break;
            long power = 1L << i;
            if (k >= power) {
                result += availableBits.get(i);
                k -= power;
            }
        }

        System.out.println(result);
    }
}