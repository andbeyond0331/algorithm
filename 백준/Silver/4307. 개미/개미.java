import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
static int count;
static int l, n;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int T = Integer.parseInt(br.readLine());
    for(int i = 0; i < T; i++) {
      String[] input = br.readLine().split(" ");
      l = Integer.parseInt(input[0]);
      n = Integer.parseInt(input[1]);
      int min = -1;
      int max = Integer.MIN_VALUE;
      for(int j = 0; j < n; j++) {
        int temp = Integer.parseInt(br.readLine());
        min = Math.max(Math.min(temp, l-temp), min);
        max = Math.max(Math.max(temp, l-temp), max);
      }
        System.out.println(min + " " + max);
    }
  }
}