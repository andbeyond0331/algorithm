import java.io.BufferedReader;
import java.io.DataOutput;
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
      long l = Long.parseLong(st.nextToken());
      long r = Long.parseLong(st.nextToken());
      long s = Long.parseLong(st.nextToken());

      long dl = s-l;
      long dr = r-s;
      long ans;
      if(dl < dr) ans = 2*dl +1;
      else ans = 2*dr;
      System.out.println(ans);
    }
  }
}
