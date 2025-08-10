import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    String pattern = br.readLine();
    StringTokenizer st = new StringTokenizer(pattern, "*");
    String head = st.nextToken();
    String tail = st.nextToken();
    String fileName;
    for(int i = 0; i < n; i++) {
      fileName = br.readLine();
      if(fileName.length() < head.length() + tail.length()) {
        System.out.println("NE");
        continue;
      }
      if(fileName.startsWith(head) && fileName.endsWith(tail)) {
        System.out.println("DA");
        continue;
      }
      System.out.println("NE");
    }
  }
}
