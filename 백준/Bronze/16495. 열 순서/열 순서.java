import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String line = br.readLine().trim();
    long answer = 0;
    for (char c : line.toCharArray()) {
//      int number = line.charAt(i)-'A'+1;
//      answe r+= (line.length()-1-i)*(number)*26;
      answer = answer * 26 + (c-'A'+1);
    }
//    answer+=line.charAt(line.length()-1)-'A'+1;
    System.out.println(answer);
    // AAA-> 26*26 + 26 + 1
    //
  }
}
