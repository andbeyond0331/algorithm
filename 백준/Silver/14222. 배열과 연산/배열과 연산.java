import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
  static int n, k;
  static int[] arr;
  static boolean flag;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    k = Integer.parseInt(st.nextToken());
    arr = new int[n];
    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < n; i++) {
      arr[i] = Integer.parseInt(st.nextToken());
    }
    Arrays.sort(arr);
    flag = false;
    check(1, new boolean[n]);
    if(flag) {
      System.out.println(1);
    } else {
      System.out.println(0);
    }
  }
  static void check(int num, boolean[] visited) {
    if(flag) {
      return;
    }
    if(num == n+1) {

      flag = true;
      return;
    }
    for (int i = 0; i < arr.length; i++) {
      if(!visited[i] && arr[i] <= num) {
        if(num == arr[i] || (num-arr[i]) % k == 0) {
          visited[i] = true;
          check(num+1, visited);
          visited[i] = false;
        }
      }
    }
  }
}
