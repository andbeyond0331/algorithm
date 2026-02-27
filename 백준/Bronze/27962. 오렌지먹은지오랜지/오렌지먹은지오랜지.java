import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    String s = br.readLine();
    for (int i = 1; i <= N; i++) {
      String a = s.substring(0, i);
      String b = s.substring(N-a.length(), N);
//      System.out.println("a: " + a + " b: " + b);
      int count = 0;
      for(int j = 0; j < b.length(); j++) {
        if(a.charAt(j) != b.charAt(j)) {
          count++;
        }
        if(count > 1) {
          break;
        }
      }
      if(count == 1) {
        System.out.println("YES");
        return;
      }
    }
    System.out.println("NO");
  }
}
