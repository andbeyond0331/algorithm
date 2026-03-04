import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String s = br.readLine();
    Set<Character> set = new HashSet<>();
    int count = 1;
    for (int i = 1; i < s.length(); i++) {
      char c = s.charAt(i);
      if(c-s.charAt(i-1)<=0) {
        count++;
      }
    }
    System.out.println(count);
  }
}
