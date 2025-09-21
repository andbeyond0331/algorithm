import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    long n = Long.parseLong(br.readLine());
    // a/n=p1...q1 b/n=p2...q2
    // n*p+p = a
    // n*q+q = b
    // 1 -> 0
    // 2 -> 3
    // 3 -> 4, 8   4 8
    // 4 -> 5, 10, 15
    long sum = 0;
    for(int i = 0; i < n; i++) {
      sum+=(n+1)*i;
    }
    System.out.println(sum);
  }
}
