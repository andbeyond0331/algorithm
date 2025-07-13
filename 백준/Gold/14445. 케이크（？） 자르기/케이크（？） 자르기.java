import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    long n = Long.parseLong(br.readLine());
    if(n<=1) {
      System.out.println(0);
    } else {
      if(n%2==0) {
        System.out.println(n/2);
      }else {
        System.out.println((n/2)+1);
      }
    }
  }
}
