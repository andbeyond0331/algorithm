import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int T = Integer.parseInt(br.readLine());
    StringTokenizer st;
    for(int i = 0; i < T; i++) {
      st = new StringTokenizer(br.readLine());
      int b = Integer.parseInt(st.nextToken());
      String d = st.nextToken();
      int temp = 0;
     for(int j = 0; j < d.length(); j++) {
        temp+= Integer.parseInt(d.charAt(j)+"");
      }
      System.out.println(temp%(b-1));

    }
  }
}
