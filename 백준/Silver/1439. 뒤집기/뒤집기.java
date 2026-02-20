import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String s = br.readLine();
//    int answer = 0;
    int zero = 0;
    int one = 0;
    char first = s.charAt(0);
    if(first == '0') {
      zero++;
    } else {
      one++;
    }
    for (int i = 1; i < s.length(); i++) {
      if(first != s.charAt(i)) {
        first = s.charAt(i);
        if(first == '0') {
          zero++;
        } else {
          one++;
        }

      }
    }
    System.out.println(Math.min(zero, one));
  }
}
