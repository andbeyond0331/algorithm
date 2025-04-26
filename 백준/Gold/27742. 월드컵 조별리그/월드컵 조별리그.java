import java.io.*;
import java.util.*;

public class Main {
    static int T_team, O_team;     // T팀과 상대팀 인덱스
    static long K;
    static long[][] scores = new long[4][4];
    static int[] headRank = new int[4];  // 상대 전적 순위

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int t = Integer.parseInt(st.nextToken());   // T팀의 head-to-head 순위
        K = Long.parseLong(st.nextToken());

        // 입력 읽기, 누락된 경기 위치 찾기
        for (int i = 0; i < 4; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 4; j++) {
                long x = Long.parseLong(st.nextToken());
                scores[i][j] = x;
                if (x == -1) {
                    T_team = i;
                    O_team = j;
                }
            }
        }

        // headRank 배열 구성: T팀은 t, 나머지는 1~4 중 남은 숫자 순서대로
        headRank[T_team] = t;
        int cur = 1;
        for (int i = 0; i < 4; i++) {
            if (i == T_team) continue;
            if (cur == t) cur++;
            headRank[i] = cur++;
        }

        // 이분탐색으로 최소 점수 찾기
        long lo = 0, hi = K, ans = -1;
        while (lo <= hi) {
            long mid = (lo + hi) >>> 1;
            if (qualify(mid)) {
                ans = mid;
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }

        System.out.println(ans);
    }

    // mid 점수를 T_team vs O_team 경기에 넣었을 때 T팀이 2위 안에 들면 true
    static boolean qualify(long mid) {
        // 1) 점수표 복사
        long[][] s = new long[4][4];
        for (int i = 0; i < 4; i++)
            System.arraycopy(scores[i], 0, s[i], 0, 4);

        // 2) 누락 경기 채우기
        s[T_team][O_team] = mid;
        // 패자 득점은 이미 입력에 있으므로 그대로 둠: s[O_team][T_team]

        // 3) 순위 계산
        int[] pts = new int[4];
        long[] gd = new long[4], gf = new long[4];

        // 각 경기 한 번만(i<j) 처리
        for (int i = 0; i < 4; i++) {
            for (int j = i+1; j < 4; j++) {
                long si = s[i][j], sj = s[j][i];
                // 승점
                if (si > sj) {
                    pts[i] += 3;
                } else if (si < sj) {
                    pts[j] += 3;
                } else {
                    pts[i] += 1;
                    pts[j] += 1;
                }
                // 골득실, 다득점
                gd[i] += si - sj;
                gd[j] += sj - si;
                gf[i] += si;
                gf[j] += sj;
            }
        }

        // 4) Team 객체로 정렬
        Team[] A = new Team[4];
        for (int i = 0; i < 4; i++) {
            A[i] = new Team(i, pts[i], gd[i], gf[i], headRank[i]);
        }
        Arrays.sort(A);

        // 5) 상위 2위 안에 T_team 있는지
        return (A[0].idx == T_team || A[1].idx == T_team);
    }

    static class Team implements Comparable<Team> {
        int idx;
        int pts;
        long gd, gf;
        int hr;
        Team(int idx, int pts, long gd, long gf, int hr) {
            this.idx = idx; this.pts = pts; this.gd = gd; this.gf = gf; this.hr = hr;
        }
        @Override
        public int compareTo(Team o) {
            if (this.pts != o.pts) return Integer.compare(o.pts, this.pts);
            if (this.gd != o.gd) return Long.compare(o.gd, this.gd);
            if (this.gf != o.gf) return Long.compare(o.gf, this.gf);
            // head-to-head total order
            return Integer.compare(this.hr, o.hr);
        }
    }
}
