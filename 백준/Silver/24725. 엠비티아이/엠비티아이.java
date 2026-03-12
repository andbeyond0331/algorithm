import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int N = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(st.nextToken());
    char[][] mbti = new char[N][M];
    for (int i = 0; i < N; i++) {
      String line = br.readLine();
      for (int j = 0; j < M; j++) {
        mbti[i][j] = line.charAt(j);
      }
    }
    int count = 0;
    char a, b, c, d;
    for(int i = 0;i < N;i++) {
      for(int j = 0;j < M;j++) {
        a = mbti[i][j];
        // 가로
        if(j<=M-4) {
          b = mbti[i][j+1];
          c = mbti[i][j+2];
          d = mbti[i][j+3];
          if(check(a, b, c, d)) {
//            System.out.println("a : " + a + " b : " + b + " c : " + c + " d : " + d);
            count++;
          }
          if(check(d, c, b, a)) {
//            System.out.println("a : " + a + " b : " + b + " c : " + c + " d : " + d);
            count++;
          }
        }
        if(i<=N-4) {

          b = mbti[i+1][j];
          c = mbti[i+2][j];
          d = mbti[i+3][j];
          if(check(a, b, c, d)) {
//            System.out.println("a : " + a + " b : " + b + " c : " + c + " d : " + d);
            count++;
          }
          if(check(d, c, b, a)) {
//            System.out.println("a : " + a + " b : " + b + " c : " + c + " d : " + d);
            count++;
          }
        }

        if(i<=N-4 && j<=M-4) {

          b = mbti[i + 1][j + 1];
          c = mbti[i + 2][j + 2];
          d = mbti[i + 3][j + 3];
          if (check(a, b, c, d)) {
//            System.out.println("a : " + a + " b : " + b + " c : " + c + " d : " + d);
            count++;
          }
          if (check(d, c, b, a)) {
//            System.out.println("a : " + a + " b : " + b + " c : " + c + " d : " + d);
            count++;
          }
        }
        if(i<=N-4 && j>2) {
            b = mbti[i+1][j-1];
            c = mbti[i+2][j-2];
            d = mbti[i+3][j-3];
            if(check(a, b, c, d)) {
//              System.out.println("a : " + a + " b : " + b + " c : " + c + " d : " + d);
              count++;
            }
            if(check(d, c, b, a)) {
//              System.out.println("a : " + a + " b : " + b + " c : " + c + " d : " + d);
              count++;
            }
          }
//          if(i>2 && j>2) {
//            b = mbti[i-1][j-1];
//            c = mbti[i-2][j-2];
//            d = mbti[i-3][j-3];
//            if(check(a, b, c, d)) {
//              count++;
//            }
//            if(check(d, c, b, a)) {
//              count++;
//            }
//          }
//        else if(i>2 && j>2) {
//          b = mbti[i-1][j-1];
//          c = mbti[i-2][j-2];
//          d = mbti[i-3][j-3];
//          if(check(a, b, c, d)) {
//            count++;
//          }
//          if(check(d, c, b, a)) {
//            count++;
//          }
//        }
      }
    }
    System.out.println(count);
    // 가로

    // 세로

    // 대각선
  }
  static boolean check(char a, char b, char c, char d) {
    if(a=='E' || a=='I') {
      if(b=='N' || b=='S') {
        if(c=='T' || c=='F') {
          if(d=='P' || d=='J') {
            return true;
          }
        }
      }
    }
    return false;
  }
}
