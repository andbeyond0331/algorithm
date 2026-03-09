import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(st.nextToken());
    int l = Integer.parseInt(st.nextToken());
    int count = 0;
    int[] arr = new int[n];
    int[] add = new int[n];
    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < n; i++) {
      arr[i] = Integer.parseInt(st.nextToken());
    }
    add[0] = arr[0];
    for (int i = 1; i < l; i++) {
      add[i] = add[i - 1] + arr[i];
    }
    for (int i = l; i < n; i++) {
      int j = i-l;
      add[i] = add[i-1] - arr[j];
      add[i] = add[i] + arr[i];
    }
    for (int i = 0; i < n; i++) {
      if(add[i] >= 129 && add[i] <=138) {
        count++;
      }
    }
    System.out.println(count);
  }
}
