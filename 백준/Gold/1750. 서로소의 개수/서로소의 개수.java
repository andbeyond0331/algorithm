import java.io.*;
import java.util.*;

public class Main {
    static final int MOD = 10_000_003;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine().trim());
        int[] nums = new int[N];
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(br.readLine().trim());
        }

        // dp[i] : after considering up to index i, map from gcd-value → count
        Map<Integer,Integer> prev = new HashMap<>();
        // base case: only pick nums[0]
        prev.put(nums[0], 1);

        for (int i = 1; i < N; i++) {
            int x = nums[i];
            Map<Integer,Integer> curr = new HashMap<>();

            // 1) not pick x: carry over all old gcd-states
            for (Map.Entry<Integer,Integer> e : prev.entrySet()) {
                int g = e.getKey();
                int cnt = e.getValue();
                curr.merge(g, cnt, (a,b)->(a+b)%MOD);

                // 2) pick x: new gcd = gcd(g, x)
                int g2 = gcd(g, x);
                curr.merge(g2, cnt, (a,b)->(a+b)%MOD);
            }

            // 3) pick x as the first element in a new subset
            curr.merge(x, 1, (a,b)->(a+b)%MOD);

            prev = curr;
        }

        // answer = number of subsets (nonempty) whose gcd==1
        int ans = prev.getOrDefault(1, 0);
        System.out.println(ans);
    }

    // iterative gcd
    static int gcd(int a, int b) {
        while (b != 0) {
            int t = b;
            b = a % b;
            a = t;
        }
        return a;
    }
}
