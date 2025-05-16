import java.io.*;
import java.util.*;

public class Main {
    static final int MOD = 60;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        long N = Long.parseLong(st.nextToken());

        // 1) 각 기차 타입이 출발하는 분(minute) 리스트
        List<Integer> schedule = new ArrayList<>();
        String[] trainNames = new String[T];
        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());
            trainNames[i] = st.nextToken();
            while (true) {
                int x = Integer.parseInt(st.nextToken());
                if (x < 0) break;
                schedule.add(x*100 + i); // (우선 x 기준 정렬, tie-break i로)
            }
        }
        // schedule에는 “(minute,타입인덱스)” 페어를 minute*100+i 로 인코딩해 넣음
        Collections.sort(schedule);

        // 2) nextState[x], nextTrain[x] 계산
        int[] nextState = new int[MOD];
        int[] nextTrain = new int[MOD];
        for (int x = 0; x < MOD; x++) {
            // 현재 시각 mod60 = x, schedule에서 x 이상인 첫 minute 고르고
            int idx = Collections.binarySearch(schedule, x*100);
            if (idx < 0) idx = -idx - 1;
            if (idx == schedule.size()) idx = 0;
            int code = schedule.get(idx);
            int trainIdx = code % 100;
            int departMinute = code / 100;
            int wait = (departMinute - x + MOD) % MOD;
            nextTrain[x] = trainIdx;
            nextState[x] = (x + wait + 1) % MOD;  // 도착 후 +1분
        }

        // 3) 이진승격 준비: f_pow[k][x] = state after 2^k applications from x
        int LOG = 32; // 2^30 > 1e9
        int[][] f_pow = new int[LOG][MOD];
        // f_pow[0] = nextState
        for (int x = 0; x < MOD; x++) f_pow[0][x] = nextState[x];
        for (int k = 1; k < LOG; k++) {
            for (int x = 0; x < MOD; x++) {
                f_pow[k][x] = f_pow[k-1][ f_pow[k-1][x] ];
            }
        }

        // 4) N-1번 합성한 최종 상태 구하기
        int state = M % MOD;
        long steps = N - 1;
        for (int k = 0; k < LOG; k++) {
            if (((steps >> k) & 1) != 0) {
                state = f_pow[k][state];
            }
        }

        // 5) 그 상태에서 탄 기차
        String answer = trainNames[ nextTrain[state] ];
        System.out.println(answer);
    }
}
