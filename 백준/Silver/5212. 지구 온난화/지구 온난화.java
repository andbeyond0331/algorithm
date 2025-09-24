import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
  static int[] dr = {-1, 1, 0, 0};
  static int[] dc = {0, 0, -1, 1};
  static char[][] map;
  static int R, C;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] input = br.readLine().split(" ");
    R = Integer.parseInt(input[0]);
    C = Integer.parseInt(input[1]);
    map = new char[R][C];
    for (int i = 0; i < R; i++) {
      String line = br.readLine();
      for (int j = 0; j < C; j++) {
        map[i][j] = line.charAt(j);
      }
    }
    int minR = Integer.MAX_VALUE;
    int minC = Integer.MAX_VALUE;
    int maxR = Integer.MIN_VALUE;
    int maxC = Integer.MIN_VALUE;
    char[][] futureMap = new char[R][C];
    for (int i = 0; i < R; i++) {
      for (int j = 0; j < C; j++) {
        if(map[i][j] == 'X') {
          if(check(i, j)) {
            futureMap[i][j] = '.';
          } else {
            futureMap[i][j] = 'X';
            minR = Math.min(minR, i);
            minC = Math.min(minC, j);
            maxR = Math.max(maxR, i);
            maxC = Math.max(maxC, j);
          }
        } else {
          futureMap[i][j] = map[i][j];
        }
      }
    }
    for(int i = minR; i <= maxR; i++) {
      for(int j = minC; j <= maxC; j++) {
        System.out.print(futureMap[i][j]);
      }
      System.out.println();
    }
//    for (int i = 0; i < R; i++) {
//      for (int j = 0; j < C; j++) {
//        System.out.print(map[i][j] + " ");
//      }
//      System.out.println();
//    }
  }
  static boolean check(int r, int c) {
    int count = 0;
    for (int i = 0; i < 4; i++) {
      int nr = r + dr[i];
      int nc = c + dc[i];
      if(nr < 0 || nr >= R || nc < 0 || nc >= C || map[nr][nc] != 'X') {
        count++;
      }
    }
    if(count>2) {
      return true;
    }
    return false;
  }
}
