import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
  static int a, d, k;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    a = Integer.parseInt(st.nextToken());
    d = Integer.parseInt(st.nextToken());
    k = Integer.parseInt(st.nextToken());
    // 이길 확률 * 시간 + 지는 확률*(시간 + 다음번에 이길 확률의 시간 값)
    if(d>=100) {
      System.out.println(a);
      return;
    }
    System.out.println(solve(d));
  }
  static double solve(double d) {
    if(d>=100) {
      return a;
    }
    return d*0.01*a + (100-d) * 0.01 * (a + solve((d*(1+k*0.01))));
  }
}
