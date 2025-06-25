import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String word = br.readLine();
    StringBuilder builder = new StringBuilder();
    for(int i = 0; i < word.length(); i++) {
      char ch = word.charAt(i);
      if(ch=='A' || ch=='B' || ch=='C') {
        builder.append((char)(ch+23));
      } else {
        builder.append((char)(ch-3));
      }
    }
    System.out.println(builder);
  }
}
