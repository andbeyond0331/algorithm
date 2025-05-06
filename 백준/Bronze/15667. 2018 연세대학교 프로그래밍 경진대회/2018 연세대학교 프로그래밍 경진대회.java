import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    int k = N/2;
    outer: while(k < N) {
      int temp = 1;
      int firework = k;
      while(temp<=N) {
        if(temp==N) {
          break outer;
        }
        temp+= firework;
        firework*=k;
      }
      k--;
    }
    System.out.println(k);
  }
}
