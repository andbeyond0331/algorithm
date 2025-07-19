import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
  static int n, m;
  static char[][] floor;
  static boolean[][] visited;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());
    floor = new char[n][m];
    visited = new boolean[n][m];
    for(int i = 0; i < n; i++) {
      String line = br.readLine();
      for(int j = 0; j < m; j++) {
        floor[i][j] = line.charAt(j);
      }
    }
    int count = 0;
    for(int i = 0; i < n; i++) {
      for(int j = 0; j < m; j++) {
        if(!visited[i][j]) {
          count++;
          solve(i, j, floor[i][j]);
        }
      }
    }
    System.out.println(count);
  }
  static void solve(int r, int c, char current) {
    visited[r][c] = true;
    if(current == '-') {
      if(c+1<m && floor[r][c+1] == '-') {
        solve(r, c+1, current);
      }
    } else {
      if(r+1<n && floor[r+1][c] == '|') {
        solve(r+1, c, current);
      }
    }
  }
}
