import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
  static int m, n;
  static long[] snacks;
  static long answer;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    m = Integer.parseInt(st.nextToken()); // 조카의 수
    n = Integer.parseInt(st.nextToken()); // 과자의 수
    snacks = new long[n];
    long max = -1;
    answer = 0;
    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < n; i++) {
      snacks[i] = Long.parseLong(st.nextToken());
      max = Math.max(max, snacks[i]);
    }
    Arrays.sort(snacks);
    if(isPossible(max)) {
      answer = max;
    } else {
      divide(0, max);
    }

    System.out.println(answer);
  }
  static void divide(long l, long r) {
    if(l>r) {
      return;
    }
    long mid = l + (r - l) / 2;
    if(mid==0) {
      return;
    }
    if(isPossible(mid)) {
      answer = Math.max(answer, mid);
      divide(mid+1, r);
      return;
    }
    if(l<mid) {
      divide(l, mid);
    }
  }
  static boolean isPossible(long length) {
    long temp = 0;
    for(int i = n-1; i >= 0; i--) {

      if(snacks[i]>=length) {
        temp+= (snacks[i]/length);
      } else {
        break;
      }
      if(temp>=m) {
        return true;
      }
    }
    return temp >= m;
  }
}
// 55 -> 8 8 8 / 2 2 2 / 1 1 1 7 6 5 4
