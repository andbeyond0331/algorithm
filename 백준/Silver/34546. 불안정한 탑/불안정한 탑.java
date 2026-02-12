import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    long[] top = new long[N];
    StringTokenizer st = new StringTokenizer(br.readLine());
    long min = 1000000001;
    for (int i = 0; i < N; i++) {
      top[i] = Long.parseLong(st.nextToken());
      min = Math.min(min, top[i]);
    }
    long ans = 0;
    for(int i = 0; i < N; i++) {
      if(top[i]>min) {
        ans+=top[i]-min;
      }
    }
    System.out.println(ans);
  }
}
