import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    N--;
    int ans = 1;
    while(N-- > 0) {
      ans*=3;
    }
    System.out.println(ans*2);
  }
}
