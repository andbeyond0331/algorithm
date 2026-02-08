import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String line = br.readLine().trim();
    long answer = 0;
    for (char c : line.toCharArray()) {
      answer = answer*26 + (c-'A'+1);
    }
    System.out.println(answer);
  }
}
