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
    if(b>=a || a>b*2) {
      System.out.println("NO");
    } else {
      int hamburgers = a-b;
      System.out.println("YES");
      System.out.println(hamburgers);
      for(int i=0; i<hamburgers; i++) {
        if(i<hamburgers-1) {
          System.out.println("aba");
          a-=2;
          b-=1;
        } else {
          for(int j = 0; j < b; j++) {
            System.out.print("ab");
          }
          System.out.print("a");
        }
      }
    }
  }
}
