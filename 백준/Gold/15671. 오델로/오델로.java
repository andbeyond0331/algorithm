import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
  static int log;
  static int[][] locations;
  static int[][] board;
  static int[] dr = {1, 1, 1, -1, -1, -1, 0, 0};
  static int[] dc = {-1, 1, 0, -1, 1, 0, 1, -1};
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    log = Integer.parseInt(br.readLine());
    locations = new int[log][2];
    board = new int[7][7];
    StringTokenizer st;
    for (int i = 0; i < log; i++) {
      st = new StringTokenizer(br.readLine());
      locations[i][0] = Integer.parseInt(st.nextToken());
      locations[i][1] = Integer.parseInt(st.nextToken());
    }
    board[3][3] = 2;
    board[4][4] = 2;
    board[3][4] = 1;
    board[4][3] = 1;
//    boolean flag = false; // false: 흑 / true: 백
    int color = 1;
    for(int i = 0; i < log; i++) {
      if(judgingColor(locations[i][0], locations[i][1], color)) {
        play(locations[i][0], locations[i][1], color);
        color = 3-color;
      } else{
        play(locations[i][0], locations[i][1], 3-color);
      }
    }
    int blackCount = 0;
    int whiteCount = 0;
    for(int i = 1;i < 7; i++) {
      for(int j = 1;j < 7;j++) {
        if(board[i][j] == 0) {
          System.out.print(".");
        } else if(board[i][j] == 1) {
          System.out.print("B");
          blackCount++;
        } else {
          System.out.print("W");
          whiteCount++;
        }
      }
      System.out.println();
    }
    System.out.println(blackCount>whiteCount?"Black":"White");
  }
  // color: 1은 흑 2는 백
  static boolean judgingColor(int r, int c, int color) { // 놓일 돌이 흑인지 백인지 판단
    boolean flag = false;
    for(int i = 0; i < 8; i++) {
      int nr = r + dr[i];
      int nc = c + dc[i];
      if(nr>0 && nr < 7 && nc>0 && nc < 7) {
        if(board[nr][nc]==3-color) {
          int nnr = nr;
          int nnc = nc;
          while(true) {
//            System.out.println("jc while");
            nnr += dr[i];
            nnc += dc[i];
            if(nnr>0 && nnr<7 && nnc>0 && nnc < 7 && board[nnr][nnc]>0) {
              if(board[nnr][nnc]==color) {
                return true;
              }
            } else {
              break;
            }
          }
        }
      }
    }
    return flag;
  }
  static void play(int r, int c, int color) {
    board[r][c] = color;

    for (int d = 0; d < 8; d++) {
      int nr = r + dr[d];
      int nc = c + dc[d];

      // 인접칸이 상대 돌인지 확인
      if (inRange(nr, nc) && board[nr][nc] == 3 - color) {
        int nnr = nr, nnc = nc;

        // 같은 색 돌 나올 때까지 전진
        while (inRange(nnr, nnc) && board[nnr][nnc] == 3 - color) {
          nnr += dr[d];
          nnc += dc[d];
        }

        // 같은 색 돌 만나면 → r,c ~ nnr,nnc 사이 전부 뒤집기
        if (inRange(nnr, nnc) && board[nnr][nnc] == color) {
          int fr = nr, fc = nc;
          while (!(fr == nnr && fc == nnc)) {
            board[fr][fc] = color;
            fr += dr[d];
            fc += dc[d];
          }
        }
      }
    }
  }

  static boolean inRange(int r, int c) {
    return r > 0 && r < 7 && c > 0 && c < 7;
  }

//  static void play(int r, int c, int color) {
////    System.out.println(r + " " + c + " " + color);
//
//    board[r][c] = color;
//    for(int i = 0; i < 8; i++) {
//      int nr = r + dr[i];
//      int nc = c + dc[i];
//      if(nr>0 && nr < 7 && nc>0 && nc < 7) {
//        if(board[nr][nc] == 3-color) {
//          int nnr = nr;
//          int nnc = nc;
//          while(true) {
////            System.out.println("p while");
//            nnr += dr[i];
//            nnc += dc[i];
//            if(nnr>0 && nnr<7 && nnc>0 && nnc < 7 && board[nnr][nnc]>0) {
//              if(board[nnr][nnc] == color) {
////                for(int x = Math.min(nr, nnr); x <= Math.max(nr, nnc); x++) {
////                  for(int y = Math.min(nc, nnc); y <= Math.max(nc, nnc); y++) {
////                    board[x][y] = color;
////                  }
////                }
//                if(nnr==nr) {
//                  for(int x = Math.min(nc, nnc); x <= Math.max(nc, nnc); x++) {
//                    board[nr][x] = color;
//                  }
//                } else if (nnc == nc) {
//                  for(int x = Math.min(nr, nnr); x <= Math.max(nr, nnr); x++) {
//                    board[x][nc] = color;
//                  }
//                } else {
//                  for(int x = 0; x <= Math.max(nr, nnr) - Math.min(nr, nnr); x++) {
//                    board[nr+(x*dr[i])][nc+(x*dc[i])] = color;
//                  }
//                }
//              }
//            } else {
//              break;
//            }
//          }
//        }
//      }
//    }
////    for(int i = 1;i < 7; i++) {
////      for(int j = 1;j < 7;j++) {
////        if(board[i][j] == 0) {
////          System.out.print(".");
////        } else if(board[i][j] == 1) {
////          System.out.print("B");
////        } else {
////          System.out.print("W");
////        }
////      }
////      System.out.println();
////    }
//  }
}
