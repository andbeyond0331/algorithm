import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
  static int[] dr = {-1, 1, 0, 0};
  static int[] dc = {0, 0, -1, 1};
  static int[][] board;
  static int r, c, n;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    r = Integer.parseInt(st.nextToken());
    c = Integer.parseInt(st.nextToken());
    n = Integer.parseInt(st.nextToken());
    board = new int[r][c];
    for(int i = 0; i < r; i++) {
      String line = br.readLine();
      for(int j = 0; j < c; j++) {
        if(line.charAt(j) == '.') {
          board[i][j] = -1;
        } else {
          board[i][j] = 0;
        }
      }
    }
    if(n>=2) {
      install(2);
    }
    if(n>=3) {
      explode(0);
    }
    if(n>=4) {
      install(4);
    }
    for(int i = 5; i <= n; i++) {
      if(i%2==0) {
        install(i);
      } else {
        explode(i-3);
      }
//      System.out.println("time: " + i);
//      for(int row = 0; row < r; row++) {
//        for(int col = 0; col < c; col++) {
//          System.out.print(board[row][col] + " ");
//        }
//        System.out.println();
//      }
    }
    for(int i = 0; i < r; i++) {
      for(int j = 0; j < c; j++) {
        if(board[i][j] < 0) {
          System.out.print(".");
        } else {
          System.out.print("O");
        }
      }
      System.out.println();
    }
  }
  static void install(int num) {
    for(int i = 0; i < r; i++) {
      for(int j = 0; j < c; j++) {
        if(board[i][j] == -1) {
          board[i][j] = num;
        }
      }
    }
  }
  static void explode(int num) {
    for(int i = 0; i < r; i++) {
      for(int j = 0; j < c; j++) {
        if(board[i][j] == num) {
          for(int k = 0; k < 4; k++) {
            int nr = i + dr[k];
            int nc = j + dc[k];
            if(nr >= 0 && nr < r && nc >= 0 && nc < c) {
              if(board[nr][nc]!=num) {
                board[nr][nc] = -1;
              }
            }
          }
        }
      }
    }
    for(int i = 0; i < r; i++) {
      for(int j = 0; j < c; j++) {
        if(board[i][j] == num) {
          board[i][j] = -1;
        }
      }
    }
  }
}
