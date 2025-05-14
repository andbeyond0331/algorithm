import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int T = Integer.parseInt(br.readLine());
    StringTokenizer st;
    for (int i = 0; i < T; i++) {
      st = new StringTokenizer(br.readLine());
      int l = Integer.parseInt(st.nextToken());
      int r = Integer.parseInt(st.nextToken());
      int s = Integer.parseInt(st.nextToken());
      int n = 1;
      boolean pl = true;
      boolean flag = false;
      while(!flag) {
        if(s == l || s == r) {
          flag = true;
          System.out.println(n);
        } else {
          if(pl) {
            s += n++;
          } else {
            s -= n++;
          }
          pl = !pl;
        }

      }
    }
  }
}
