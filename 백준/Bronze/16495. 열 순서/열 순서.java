import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    // 16진법인데.. 0이 없는?
    // A
    // AA -> 26+1
    // AAA -> 26*26+1
    // AAAA -> 26*26*26+1
    String line = br.readLine().trim();
    long answer = 0;
    for(char c : line.toCharArray()) {
      answer=answer*26+(c-'A'+1);
    }
    System.out.println(answer);
  }
}
