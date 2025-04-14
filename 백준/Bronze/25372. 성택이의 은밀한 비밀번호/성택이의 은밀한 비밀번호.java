import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    for(int i = 0; i < N; i++) {
      String line = br.readLine();
      if(line.length()>=6 && line.length()<=9) {
        System.out.println("yes");
      }else {
        System.out.println("no");
      }
    }
  }
}
