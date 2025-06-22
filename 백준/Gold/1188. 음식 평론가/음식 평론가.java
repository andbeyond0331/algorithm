import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] input = br.readLine().split(" ");
    int n = Integer.parseInt(input[0]);
    int m = Integer.parseInt(input[1]);
    if(m>n) {
      int count = 0;
      for(int i = 1; i <= m; i++) {
        if(i*n%m!=0) {
          count++;
        }
      }
      System.out.println(count);
    }else if(m==n) {
      System.out.println(0);
    } else {
      int count = 0;
      for(int i = 1; i <= m; i++) {
        if(i*n%m!=0) {
          count++;
        }
      }
      System.out.println(count);
    }
  }
}
