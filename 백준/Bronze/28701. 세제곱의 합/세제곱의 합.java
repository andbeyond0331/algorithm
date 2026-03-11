import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    int first = 0;
    int second = 0;
    for (int i = 1; i <= N; i++) {
      first+=i;
      second+=i*i*i;
    }
    System.out.println(first);
    System.out.println(first*first);
    System.out.println(second);
  }
}
