import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    st = new StringTokenizer(br.readLine());
    int N = Integer.parseInt(st.nextToken()); // 표의 크기
    int M = Integer.parseInt(st.nextToken()); // 합 구해야 하는 횟수
    int[][] table = new int[N+1][N+1];
    int[][] count = new int[N+1][N+1];
    for(int i = 1;i <= N; i++) {
      st = new StringTokenizer(br.readLine());
      for(int j = 1;j <= N; j++) {
        table[i][j] = Integer.parseInt(st.nextToken());
        count[i][j] = table[i][j] + count[i-1][j];

      }
    }
    for(int i = 1; i <=N; i++) {
      for(int j = 1; j <=N; j++) {
        count[i][j] += count[i][j-1];
      }
    }
//    System.out.println();
//    for(int i = 1;i <= N;i++) {
//      for(int j = 1;j <= N;j++) {
//        System.out.print(count[i][j] + " ");
//      }
//      System.out.println();
//    }
    StringBuilder sb = new StringBuilder();
    for(int i = 0; i < M; i++) {
      st = new StringTokenizer(br.readLine());
      int x1 = Integer.parseInt(st.nextToken());
      int y1 = Integer.parseInt(st.nextToken());
      int x2 = Integer.parseInt(st.nextToken());
      int y2 = Integer.parseInt(st.nextToken());
      sb.append(count[x2][y2] - count[x1-1][y2] - count[x2][y1-1] + count[x1-1][y1-1]).append("\n");
    }
    System.out.println(sb.toString());

  }
}
