import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int T = Integer.parseInt(br.readLine());
    for(int t = 0; t < T; t++) {
      int c = Integer.parseInt(br.readLine());
      int quarter = c/25;
      c %= 25;
      int dime = c/10;
      c %= 10;
      int nickel = c/5;
      c %= 5;
      System.out.println(quarter + " " + dime + " " + nickel + " " + c);
    }
  }

}
