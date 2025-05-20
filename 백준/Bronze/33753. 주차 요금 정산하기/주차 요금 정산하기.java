import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int a = Integer.parseInt(st.nextToken());
    int b = Integer.parseInt(st.nextToken());
    int c = Integer.parseInt(st.nextToken());
    int t = Integer.parseInt(br.readLine());
    if(t<=30) {
      System.out.println(a);
    } else {
      if((t-30)%b==0) {
        System.out.println(a + ((t-30)/b)*c);
      } else {
        System.out.println(a + (((t-30)/b + 1)*c));
      }
    }
  }
}
