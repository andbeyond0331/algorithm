import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // 입력 처리
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] a = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }

        long ans = 0; // 결과는 커질 수 있으므로 long 사용
        Map<Integer, Integer> window = new HashMap<>();

        for (int i = 0; i < n; i++) {
            int target = a[i] ^ k;
            ans += window.getOrDefault(target, 0); // a[i]^k 값이 몇 개 있는지 확인

            // 현재 값 추가
            window.put(a[i], window.getOrDefault(a[i], 0) + 1);

            // 윈도우 크기 유지
            if (i >= m) {
                int prev = a[i - m];
                window.put(prev, window.get(prev) - 1);
                if (window.get(prev) == 0) {
                    window.remove(prev);
                }
            }
        }

        System.out.println(ans);
    }
}
