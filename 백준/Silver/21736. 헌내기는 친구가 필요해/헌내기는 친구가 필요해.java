import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
  static int count;
  static char[][] map;
  static int[] dx = {-1, 0, 1, 0};
  static int[] dy = {0, 1, 0, -1};
  static boolean[][] visited;
  static int N, M;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
    int x = 0;
    int y = 0;
    map = new char[N][M];
    for (int i = 0; i < N; i++) {
      String s = br.readLine();
      for (int j = 0; j < M; j++) {
        map[i][j] = s.charAt(j);
        if(map[i][j] == 'I') {
          x = i;
          y = j;
        }
      }
    }
    count = 0;
    visited = new boolean[N][M];
    map[x][y] = 'X';
    visited[x][y] = true;
    search(x, y);
    if(count == 0) {
      System.out.println("TT");
      return;
    }
    System.out.println(count);
  }
  static void search(int r, int c) {
    for (int i = 0; i < 4; i++) {
      int nr = r + dx[i];
      int nc = c + dy[i];
      if(nr>=0 && nr < N && nc>=0 && nc < M && !visited[nr][nc] && map[nr][nc]!='X') {
        visited[nr][nc] = true;
        if(map[nr][nc] == 'P') {
          count++;
        }
        map[nr][nc] = 'X';
        search(nr, nc);
      }
    }
  }
}
