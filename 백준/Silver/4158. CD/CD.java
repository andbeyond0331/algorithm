import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    while(true) {
      st = new StringTokenizer(br.readLine());
      int n = Integer.parseInt(st.nextToken());
      int m = Integer.parseInt(st.nextToken());
      if(n==0 && m==0) {
        break;
      }
      int[] sg = new int[n];
      int[] sy = new int[m];
      for (int i = 0; i < n; i++) {
        sg[i] = Integer.parseInt(br.readLine());
      }
      for (int i = 0; i < m; i++) {
        sy[i] = Integer.parseInt(br.readLine());
      }
      int g = 0;
      int y = 0;
      int count = 0;
      while(g!=n && y!=m) {
        if(sg[g] == sy[y]) {
          count++;
          g++;
          y++;
        } else if(sg[g]>sy[y]) {
          y++;
        } else {
          g++;
        }
      }
      System.out.println(count);
    }

  }
}
