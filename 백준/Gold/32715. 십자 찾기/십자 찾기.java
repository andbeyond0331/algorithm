import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
  static int n, m, k;
  static int[][] paper;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());
    k = Integer.parseInt(br.readLine());
    paper = new int[n][m];
    for(int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine());
      for(int j = 0; j < m; j++) {
        paper[i][j] = Integer.parseInt(st.nextToken());
      }
    }
    int[][] rSums = new int[n][m];
    int[][] cSums = new int[n][m];
    for(int i = 0; i < n; i++) {
      for(int j = 0; j < m; j++) {
        if(paper[i][j] == 0) {
          rSums[i][j] = 0;
          cSums[i][j] = 0;
          continue;
        }
        if(i==0) {
          cSums[i][j] = paper[i][j];
        } else {
          cSums[i][j] = cSums[i-1][j] + paper[i][j];
        }
        if(j==0) {
          rSums[i][j] = paper[i][j];
        } else {
          rSums[i][j] = rSums[i][j-1] + paper[i][j];
        }
      }
    }
    int count = 0;
    for(int i = k; i < n-k; i++) {
      for(int j = k; j < m-k; j++) {
        if(rSums[i][j+k]>2*k && cSums[i+k][j]>2*k) {
          count++;
        }
      }
    }
    System.out.println(count);
//    for(int i = 0; i < n; i++) {
//      for(int j = 0; j < m; j++) {
//        System.out.print(rSums[i][j] + " ");
//      }
//      System.out.println();
//    }
//    for(int i = 0; i < n; i++) {
//      for(int j = 0; j < m; j++) {
//        System.out.print(cSums[i][j] + " ");
//      }
//      System.out.println();
//    }
  }
}
