import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    int idx = 0;
    int fin = 0;
    if (N == 0) {
      System.out.println("NO");
      return;
    }
    while (true) {
      long l = (long) Math.pow(3, idx);
      if (l < N) {
        idx++;
      } else {
        if(l>Integer.MAX_VALUE) {
          idx--;
        }
        fin = (int) Math.pow(3, idx);
        break;
      }
    }
    for (int i = fin; i > 0; i /= 3) {
      if (N >= i)
        N -= i;
      if (N == 0) {
        System.out.println("YES");
        return;
      }
    }
    System.out.println("NO");
  }
}
