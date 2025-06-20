import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
  static int[][] result;
  static int[] dr = {0, 1, 0, -1};
  static int[] dc = {1, 0, -1, 0};
  static int R, C;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int t = Integer.parseInt(br.readLine());
    for (int i = 0; i < t; i++) {
      String[] input = br.readLine().split(" ");
      R = Integer.parseInt(input[0]);
      C = Integer.parseInt(input[1]);
      StringBuilder message = new StringBuilder();
      for(int n = 2; n < input.length; n++) {
        message.append(n == input.length - 1 ? input[n] : input[n] + " ");
      }
      result = new int[R][C];
      StringBuilder binary = new StringBuilder();
      for(int j = 0; j < message.length(); j++) {
        char ch = message.charAt(j);
        int index = ch==' '?0:ch-'A'+1;
        binary.append(String.format("%5s", Integer.toBinaryString(index)).replace(" ", "0"));
//        System.out.println(String.format("%5s", Integer.toBinaryString(index)).replace(" ", "0"));
      }
      filling(0, 0, 0, String.valueOf(binary), 0, new boolean[R][C]);

      StringBuilder sb = new StringBuilder();
      for(int j = 0; j < R; j++) {
        for (int k = 0; k < C; k++) {
          sb.append(result[j][k]);
        }
      }
      System.out.println(sb);
    }
  }
  static void filling(int r, int c, int cur, String target, int dir, boolean[][] visited) {
    if(cur == target.length()) {
      return;
    }
    result[r][c] = Integer.parseInt(target.substring(cur, cur+1));
    visited[r][c] = true;
    int nr = r+dr[dir];
    int nc = c+dc[dir];
    if(check(nr, nc) && !visited[nr][nc]) {
      filling(nr, nc, cur+1, target, dir, visited);
    } else {
      if(dir == 3) {
        filling(r+dr[0], c+dc[0], cur+1, target, 0, visited);
      } else {
        filling(r+dr[dir+1], c+dc[dir+1], cur+1, target, dir+1, visited);
      }
    }
  }
  static boolean check(int r, int c) {
    if(r>=0 && r<R && c>=0 && c<C) {
      return true;
    }
    return false;
  }
}
