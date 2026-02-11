import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
  static int[] kit;
  static int N, K;
//  static boolean[] visited;
  static int answer;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    K = Integer.parseInt(st.nextToken());
    kit = new int[N];
    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < N; i++) {
      kit[i] = Integer.parseInt(st.nextToken());
    }
//    visited = new boolean[N];
    answer = 0;
    solve(0, 500, new boolean[N]);
    System.out.println(answer);
  }
  static void solve(int n, int weight, boolean[] visited) {
    if(n==N) {
      if(weight>=500) {
        answer++;
      }
      return;
    }
    weight-=K;
    for (int i = 0; i < N; i++) {
      if(!visited[i]) {
        if(weight+kit[i]>=500) {
          visited[i] = true;
          solve(n+1, weight+kit[i], visited);
          visited[i] = false;
        }
      }
    }
  }
}
