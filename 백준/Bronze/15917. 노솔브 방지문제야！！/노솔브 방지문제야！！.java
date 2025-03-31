import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int Q = Integer.parseInt(br.readLine());
    for(int i = 0; i < Q; i++) {
      int N = Integer.parseInt(br.readLine());
      String s = Integer.toBinaryString(N);
      if(N == 1<<s.length()-1) {
        System.out.println(1);
      }else {
        System.out.println(0);
      }
    }
  }
}
