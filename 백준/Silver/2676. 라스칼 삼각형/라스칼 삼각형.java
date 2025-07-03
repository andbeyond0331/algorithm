import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int T = Integer.parseInt(br.readLine());
    StringTokenizer st;
    for(int t = 1; t <= T; t++) {
      st = new StringTokenizer(br.readLine());
      int n = Integer.parseInt(st.nextToken());
      int m = Integer.parseInt(st.nextToken());
      System.out.println(solve(n, m));
//      if(n==0||m==0) {
//        System.out.println(1);
//        continue;
//      }
//      r[i][j] = (r[i][j-1]*r[i-1][j]+1)/r[i-1][j-1];
    }
  }
  static int solve(int n, int m) {
    return 1+(n-m)*m;
  }
}
