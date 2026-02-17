import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String line = br.readLine();
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < line.length()/10; i++) {
      sb.append(line.substring(i*10, i*10+10));
      sb.append("\n");
    }
    sb.append(line.substring(line.length()-line.length()%10, line.length()));
    System.out.println(sb);
  }
}
