import java.io.*;
import java.util.*;

public class Main {
    static String n, m, x;
    static boolean[][] visited;
    static class Info {
        int l, r;
        String path;
        Info(int l, int r, String path) {
            this.l = l;
            this.r = r;
            this.path = path;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = br.readLine().trim();
        m = br.readLine().trim();
        x = br.readLine().trim();
        visited = new boolean[n.length()+1][m.length()+1];
        System.out.print(bfs());
    }

    static String bfs() {
        ArrayDeque<Info> q = new ArrayDeque<>();
        // depth = index in x
        int depth = 0;
        // 초기상태: x[0]이 n[0] 또는 m[0]과 일치하면 큐에 추가
        if (n.charAt(0) == x.charAt(0)) {
            q.addLast(new Info(1, 0, "1"));
            visited[1][0] = true;
        }
        if (m.charAt(0) == x.charAt(0)) {
            q.addLast(new Info(0, 1, "2"));
            visited[0][1] = true;
        }

        while (!q.isEmpty()) {
            int sz = q.size();
            // depth 번째 문자에 맞춰 다음 문자를 꺼낼 것이므로
            for (int i = 0; i < sz; i++) {
                Info cur = q.removeFirst();
                // 목표: 두 문자열 모두 끝까지 다 사용했다면 path 반환
                if (cur.l == n.length() && cur.r == m.length()) {
                    return cur.path;
                }
                // 다음 depth
                int next = depth + 1;
                // n에서 하나 더 뽑기
                if (cur.l < n.length()
                    && next < x.length()
                    && !visited[cur.l+1][cur.r]
                    && n.charAt(cur.l) == x.charAt(next)) {
                    visited[cur.l+1][cur.r] = true;
                    q.addLast(new Info(cur.l+1, cur.r, cur.path + "1"));
                }
                // m에서 하나 더 뽑기
                if (cur.r < m.length()
                    && next < x.length()
                    && !visited[cur.l][cur.r+1]
                    && m.charAt(cur.r) == x.charAt(next)) {
                    visited[cur.l][cur.r+1] = true;
                    q.addLast(new Info(cur.l, cur.r+1, cur.path + "2"));
                }
            }
            depth++;
        }
        // 문제 조건상 항상 해가 있음
        return "";
    }
}
