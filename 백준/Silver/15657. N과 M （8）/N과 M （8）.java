import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
  static int n, m;
  static int[] arr;
  static int[] ans;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());
    arr = new int[n];
    ans = new int[m];
    st = new StringTokenizer(br.readLine());
    for(int i = 0; i < n; i++) {
      arr[i] = Integer.parseInt(st.nextToken());
    }
    Arrays.sort(arr);
    choose(0, 0);
  }
  static void choose(int depth, int idx) {
    if(depth == m) {
      for(int x: ans) {
        System.out.printf("%d ", x);
      }
      System.out.println();
      return;
    }
    for(int i = idx; i < n; i++) {
      ans[depth] = arr[i];
      choose(depth+1, i);
    }
  }
}
