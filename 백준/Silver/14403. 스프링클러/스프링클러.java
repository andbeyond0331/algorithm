import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static class Flower implements Comparable<Flower> {
        long d1, d2;
        Flower(long d1, long d2) {
            this.d1 = d1;
            this.d2 = d2;
        }
        @Override
        public int compareTo(Flower o) {
            return Long.compare(this.d1, o.d1);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int x1 = Integer.parseInt(st.nextToken());
        int y1 = Integer.parseInt(st.nextToken());
        int x2 = Integer.parseInt(st.nextToken());
        int y2 = Integer.parseInt(st.nextToken());

        Flower[] a = new Flower[n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken()), y = Integer.parseInt(st.nextToken());
            long dx1 = x - x1, dy1 = y - y1;
            long dx2 = x - x2, dy2 = y - y2;
            long d1 = dx1*dx1 + dy1*dy1;
            long d2 = dx2*dx2 + dy2*dy2;
            a[i] = new Flower(d1, d2);
        }

        // d1 오름차순 정렬
        Arrays.sort(a);

        // suffixMax[i] = i번째 꽃부터 끝까지의 d2 최댓값
        long[] suffixMax = new long[n];
        suffixMax[n-1] = a[n-1].d2;
        for (int i = n-2; i >= 0; i--) {
            suffixMax[i] = Math.max(a[i].d2, suffixMax[i+1]);
        }

        // r1=0 일 때: r2 = suffixMax[0]
        long ans = suffixMax[0];

        // 각 i를 r1으로 삼고 나머지 r2 계산
        for (int i = 0; i < n; i++) {
            long r1 = a[i].d1;
            long r2 = (i+1 < n ? suffixMax[i+1] : 0);
            ans = Math.min(ans, r1 + r2);
        }

        System.out.println(ans);
    }
}
