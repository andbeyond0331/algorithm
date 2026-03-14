import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int r = Integer.parseInt(st.nextToken());
    int c = Integer.parseInt(st.nextToken());
    st = new StringTokenizer(br.readLine());
    int a = Integer.parseInt(st.nextToken());
    int b = Integer.parseInt(st.nextToken());
//    char[][] board = new char[r*a][c*b];
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < r*a; i++) {
      for (int j = 0; j < c*b; j++) {
        int row = i/a%2;
        int col = j/b%2;
        if((row==0&&col==0)|| (row==1&&col==1)) {
          sb.append("X");
        } else {
          sb.append(".");
        }
      }
      sb.append('\n');
    }
    System.out.println(sb.toString());
  }

}

// 01 23 45 67
// 0 1 2 3
// 00 02

// 0~14
// 012 345 678 91011 121314
// 0 1 2 3 4
// 00 02 04
// 11 13
