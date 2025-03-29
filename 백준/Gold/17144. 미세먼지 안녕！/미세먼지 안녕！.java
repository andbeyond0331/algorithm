import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
  static int R, C, T;
  static int[][] room;
  static int up, down;
  static int[] dr = {-1, 1, 0, 0};
  static int[] dc = {0, 0, -1, 1};
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    R = Integer.parseInt(st.nextToken());
    C = Integer.parseInt(st.nextToken());
    T = Integer.parseInt(st.nextToken());
    room = new int[R][C];
    up = -1;
    down = -1;
    for(int i = 0;i < R; i++) {
      st = new StringTokenizer(br.readLine());
      for(int j = 0;j < C;j++) {

        room[i][j] = Integer.parseInt(st.nextToken());
        if(j==0 && room[i][j] == -1) {
          if(up == -1) {
            up = i;
          } else {
            down = i;
          }
        }
      }
    }
    for(int i = 0; i < T; i++) {
//      System.out.println("----------");
      flow();
//      for(int j = 0; j < R; j++) {
//        for(int k = 0; k < C; k++) {
//          System.out.print(room[j][k] + " ");
//        }
//        System.out.println();
//      }
    }
    int count = 0;
    for(int i = 0;i < R;i++) {
      for(int j = 0;j < C;j++) {
        if(room[i][j] != -1) {
          count+= room[i][j];
        }
      }
    }
    System.out.println(count);
//    for(int i = 0;i < R;i++) {
//      for(int j = 0;j < C;j++) {
//        System.out.print(room[i][j] + " ");
//      }
//      System.out.println();
//    }
//    System.out.println("up: " + up + " down: " + down);
  }
  static void flow() {
    // 확산
    room = spread();
//    for(int i = 0;i < R;i++) {
//      for(int j = 0;j < C;j++) {
//        System.out.print(room[i][j] + " ");
//      }
//      System.out.println();
//    }
//    System.out.println("--------!!!");
    // 공기청정기 위에서 들어오기
    for(int i = up-1; i >=0; i--) {
      if(i == 0) {
        room[i][0] = 0;
      } else {
        room[i][0] = room[i-1][0];
      }
    }
    // 공청기 아래서 올라가기
    for(int i = down+1; i < R; i++) {
      if(i == R-1) {
        room[i][0] = 0;
      } else {
        room[i][0] = room[i+1][0];
      }
    }
    // 맨 윗 줄 맨 아랫 줄
    for(int i = 0; i < C-1; i++) {
      if(i == C-1) {
        room[0][i] = 0;
        room[R-1][i] = 0;
      } else {
        room[0][i] = room[0][i+1];
        room[R-1][i] = room[R-1][i+1];
      }
    }
    // 맨 오른쪽
    for(int i = 0; i <= up; i++) {
      if(i == up) {
        room[i][C-1] = 0;
      }else{
        room[i][C-1] = room[i+1][C-1];
      }
    }
    for(int i = R-1; i >= down; i--) {
      if(i == down) {
        room[i][C-1] = 0;
      } else {
        room[i][C-1] = room[i-1][C-1];
      }
    }
    // 가운데
    for(int i = C-1; i > 0; i--) {
      if(i == 1) {
        room[up][i] = 0;
        room[down][i] = 0;
      } else {
        room[up][i] = room[up][i-1];
        room[down][i] = room[down][i-1];
      }
    }

  }
  static int[][] spread() {
    int[][] res = new int[R][C];
    for(int i = 0;i < R;i++) {
      for(int j = 0;j < C;j++) {
        if(room[i][j] == -1) {
          res[i][j] = -1;
        }
        if(room[i][j] > 0) {
          int temp = room[i][j];
          int cnt = 0;
          for(int k = 0; k < dr.length; k++) {
            int r = i + dr[k];
            int c = j + dc[k];
            if(check(r, c)) {
              res[r][c] += temp/5;
              cnt++;
            }
          }
          int p = temp/5;
          res[i][j] += room[i][j] - (p*cnt);
        }
      }
    }
    return res;
  }
  static boolean check(int r, int c) {
    if(r>=0 && r < R && c>=0 && c < C) {
      return room[r][c] != -1;
    }
    return false;
  }
}
