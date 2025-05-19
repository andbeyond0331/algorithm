import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine().trim());
    StringTokenizer st;
    int[][] matrix = new int[n][n];
    int[][] forward = new int[n][n];
    int[][] backward = new int[n][n];
    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < n; j++) {
        matrix[i][j] = Integer.parseInt(st.nextToken());
      }
    }
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        if(i==0 || j==0) {
          forward[i][j] = matrix[i][j];
        } else {
          forward[i][j] = forward[i-1][j-1] + matrix[i][j];
        }
        if(i==0 || j==n-1) {
          backward[i][j] = matrix[i][j];
        } else {
          backward[i][j] = backward[i-1][j+1] + matrix[i][j];
        }
      }
    }
    int max = Integer.MIN_VALUE;
    for(int i = 0; i < n-1; i++) {
      for(int j = 0; j < n-1; j++) {
        int temp = Math.min(n-i, n-j);
        for(int k = 0; k < temp; k++) {
          int a = forward[i+k][j+k];
          int b = backward[i+k][j];
          if(i!=0 && j != 0) {
            a -= forward[i-1][j-1];
          }
          if(i!=0 && j+k != n-1) {
            b-= backward[i-1][j+k+1];
          }
          max = Math.max(max, a - b);
//          if(i==0 || j==0) {
//            max = Math.max(max, forward[i+k][j+k] - backward[i+k][j]);
//          } else {
//            if(j+k == n-1) {
//              max = Math.max(max, forward[i+k][j+k]-forward[i-1][j-1] - backward[i+k][j]);
//            } else {
//              max = Math.max(max, forward[i+k][j+k]-forward[i-1][j-1] - (backward[i+k][j] - backward[i-1][j+k+1]));
//            }
//          }
//          if(max == 3) {
//            System.out.println("i: " + i + " j: " + j + " k: " + k + " " + forward[i+k][j+k] + " " + forward[i-1][j-1] + " " + backward[i+k][j] + " " + backward[i-1][j+1]);
//          }
        }
      }
    }
    System.out.println(Math.max(max, 0));
//    for (int i = 0; i < n; i++) {
//      for (int j = 0; j < n; j++) {
//        System.out.print(backward[i][j] + " ");
//      }
//      System.out.println();
//    }
  }
}
