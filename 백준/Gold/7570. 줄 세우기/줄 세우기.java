import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
  static int N; // 어린이 수
  static int[] children;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    N = Integer.parseInt(br.readLine());
    children = new int[N];
    // 1인 경우 -> 첫번째나 마지막 앞이나 뒤로 보내기
    // 2인 경우 -> 첫번째, 두번째나 첫번째, 마지막이나 마지막에서 두번째, 마지막을 앞이나 뒤로 보내기
    // 3인 경우 ->
    String[] input = br.readLine().split(" ");
    for (int i = 0; i < N; i++) {
      children[i] = Integer.parseInt(input[i]);
    }
    int[] dp = new int[N+1];
    int max = Integer.MIN_VALUE;
    for (int i = 0; i < N; i++) {
      dp[children[i]] = dp[children[i]-1] + 1;
      max = Math.max(max, dp[children[i]]);
    }
//    for (int i = 0; i < N; i++) {
//      System.out.print(dp[i]);
//    }
    System.out.println(N-max);
  }
}
