import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
  static long[] f;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    f = new long[n+1];
    System.out.println(fib(n));
  }
  static long fib(int n) {
    if(n==1 || n==2 || n==3) {
      return f[n]=1;
    }
    if(f[n]==0) {
      f[n] = fib(n-1) + fib(n-3);
    }
    return f[n];
  }
}
