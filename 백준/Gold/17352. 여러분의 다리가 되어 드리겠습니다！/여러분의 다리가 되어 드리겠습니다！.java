import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static int[] parent;
    public static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        parent = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            parent[i] = i;
        }
        for (int i = 0; i < N - 2; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            union(a, b);
        }
        int targetParent = find(1);
        for (int i = 2; i <= N; i++) {
            // N - 2개 다리가 존재하므로 연결된 그룹은 무조건 2개로 나누어짐
            // 1번 섬은 무조건 2개 그룹 중 하나의 그룹에 속해있음
            // 1번 섬과 연결되지 않은 섬을 이어주면 모든 섬이 연결됨
            if (targetParent != find(i)) {
                System.out.println(1 + " " + i);
                break;
            }
        }
    }

    public static void union(int a, int b) {
        a = find(a);
        b = find(b);
        if (a != b) {
            if (a < b) parent[b] = a;
            else parent[a] = b;
        }
    }

    public static int find(int a) {
        if (a == parent[a]) return a;
        return parent[a] = find(parent[a]);
    }
}