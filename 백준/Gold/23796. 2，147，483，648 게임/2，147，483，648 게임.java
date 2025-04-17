import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    long[][] board = new long[8][8];
    long[][] ans = new long[8][8];
    StringTokenizer st;
    for(int i = 0; i < 8; i++) {
      st = new StringTokenizer(br.readLine());
      for(int j = 0; j < 8; j++) {
        board[i][j] = Integer.parseInt(st.nextToken());
      }
    }
    // 아래쪽 -> 아래에서 위=> r이 증가하고 가끔 c 변함
    // 위쪽 -> 위에서 아래 => r이 감소하고 가끔 c 변함
    // 왼쪽 -> 왼쪽에서 오른쪽 => c가 증가하고 가끔 r 변화
    // 오른쪽 -> 오른쪽에서 왼쪽 => c가 감소하고 가끔 r 변화
    char dir = br.readLine().charAt(0);
    if(dir == 'L') {
      int r = 0;
      int c = 0;
      long prev = 0;
      for(int i = 0; i < 8; i++) {
        List<Long> temp = new ArrayList<>();
        for(int j = 0; j < 8; j++) {
          if(board[i][j] != 0) {
            temp.add(board[i][j]);
          }
        }
        boolean flag = false;
        for(int j = 0; j < temp.size(); j++) {
          if(j==0) {
            ans[i][c++] = temp.get(j);
          } else if(Objects.equals(temp.get(j), temp.get(j - 1))) {
            if(!flag) {

              ans[i][c-1] += temp.get(j);
              flag = true;
            } else {
              ans[i][c++] = temp.get(j);
              flag = false;
            }
          } else {
            ans[i][c++] = temp.get(j);
            flag = false;
          }
        }
//        for(int j = 0; j < 8; j++) {
//          if(board[i][j]!=0) { // 숫자가 있으면
//            if(prev==0) { // 이전에 합칠만한 게 없을 때
//              ans[i][c++] = board[i][j]; // 현재 c 자리에 블록을 두고 c에 1을 더한다.
//              prev = board[i][j]; // 합쳐질 후보에 해당 숫자 두기
//            } else if(prev==board[i][j]) { // 만약 숫자가 합쳐질 후보와 같다면
//              ans[i][c-1] = prev*2; // 이전에 합치고
//              prev = 0; // 초기화
//            } else { // 숫자가 합쳐질 후보와 다르면
//              ans[i][c++] = board[i][j];
//              prev = board[i][j];
//            }
//          }
//        }
        c = 0;
        prev = 0;
      }
    } else if(dir == 'R') {
      int c = 7;
      for(int i = 0; i < 8; i++) {
        List<Long> temp = new ArrayList<>();
        for(int j = 0; j < 8; j++) {
          if(board[i][j]!=0) {
            temp.add(board[i][j]);
          }
        }
        boolean flag = false;
        for(int j = temp.size()-1; j >= 0; j--) {
          if(j == temp.size()-1) {
            ans[i][c--] = temp.get(j);
          } else if(Objects.equals(temp.get(j), temp.get(j+1))) {
            if(!flag) {
              ans[i][c+1] += temp.get(j);
              flag = true;
            } else {
              ans[i][c--] = temp.get(j);
              flag = false;
            }
          } else {
            ans[i][c--] = temp.get(j);
            flag = false;
          }
        }
        c = 7;
      }
//      int r = 0;
//      int c = 7;
//      long prev = 0;
//      for(int i = 0; i < 8; i++) {
//        for(int j = 7; j >= 0; j--) {
//          if(board[i][j]!=0) {
//            if(prev==0) {
//              ans[i][c--] = board[i][j];
//              prev = board[i][j];
//            } else if(prev==board[i][j]) {
//              ans[i][c+1] = prev*2;
//              prev = 0;
//            } else {
//              ans[i][c--] = board[i][j];
//              prev = board[i][j];
//            }
//          }
//        }
//        c = 7;
//        prev = 0;
//      }
    } else if(dir == 'U') {
      int r = 0;
      long prev = 0;
      for(int j = 0; j < 8; j++) {
        List<Long> temp = new ArrayList<>();
        for(int i = 0; i < 8; i++) {
          if(board[i][j] != 0) {
            temp.add(board[i][j]);
          }
        }
        boolean flag = false;
        for(int i = 0; i < temp.size(); i++) {
          if(i==0) {
            ans[r++][j] = temp.get(i);
          }else if(Objects.equals(temp.get(i), temp.get(i - 1))) {
            if(!flag) {
              ans[r-1][j] = temp.get(i) + temp.get(i-1);
              flag = true;
            } else {
              ans[r++][j] = temp.get(i);
              flag = false;
            }
          } else {
            ans[r++][j] = temp.get(i);
            flag = false;
          }
        }
        r = 0;
      }
//      int r = 0;
//      int c = 0;
//      long prev = 0;
//      for(int j = 0; j < 8; j++) {
//        for(int i = 0; i < 8; i++) {
//          if(board[i][j]!=0) {
//            if(prev==0) {
//              ans[r++][j] = board[i][j];
//              prev = board[i][j];
//            } else if(prev==board[i][j]) {
//              ans[r-1][j] = prev*2;
//              prev = 0;
//            } else {
//              ans[r++][j] = board[i][j];
//              prev = board[i][j];
//            }
//          }
//        }
//        r = 0;
//        prev = 0;
//      }

    } else if(dir == 'D') {
      int r = 7;
      for(int j = 0; j < 8; j++) {
        List<Long> temp = new ArrayList<>();
        for(int i = 0; i < 8; i++) {
          if(board[i][j] != 0) {
            temp.add(board[i][j]);
          }
        }
        boolean flag = false;
        for(int i = temp.size()-1; i >= 0; i--) {
          if(i==temp.size()-1) {
            ans[r--][j] = temp.get(i);
          } else if(Objects.equals(temp.get(i), temp.get(i + 1))) {
            if(!flag) {
              ans[r+1][j] += temp.get(i);
              flag = true;
            } else {
              ans[r--][j] = temp.get(i);
              flag = false;
            }
          } else {
            ans[r--][j] = temp.get(i);
            flag = false;
          }
        }
        r = 7;
      }
//      int r = 7;
//      int c = 0;
//      long prev = 0;
//      for(int i = 0; i < 8; i++) {
//        for(int j = 7; j >= 0; j--) {
//          if(board[i][j]!=0) {
//            if(prev==0) {
//              ans[r--][j] = board[i][j];
//              prev = board[i][j];
//            } else if(prev==board[i][j]) {
//              ans[r+1][j] = prev*2;
//              prev = 0;
//            } else {
//              ans[r--][j] = board[i][j];
//              prev = board[i][j];
//            }
//          }
//        }
//        r = 7;
//        prev = 0;
//      }
    }
    for(int i = 0; i < 8; i++) {
      for(int j = 0; j < 8; j++) {
        System.out.print(ans[i][j] + " ");
      }
      System.out.println();
    }
  }
}
