import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String string = br.readLine();
    if(string.contains("M") && string.contains("O") && string.contains("B") && string.contains("I") && string.contains("S")) {
      System.out.println("YES");
    } else {
      System.out.println("NO");
    }
  }
}
