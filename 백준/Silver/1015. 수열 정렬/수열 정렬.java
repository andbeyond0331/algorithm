import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    int[] a = new int[n];
    int[] b = new int[n];
    StringTokenizer st = new StringTokenizer(br.readLine());
    for (int i = 0; i < n; i++) {
      a[i] = Integer.parseInt(st.nextToken());
      b[i] = a[i];
    }
    Arrays.sort(b);
    List<Integer> list = new ArrayList<>();
    for(int i = 0; i < n; i++) {
      for(int j = 0; j < n; j++) {
        if(a[i] == b[j]) {
          list.add(j);
          b[j] = 0;
          break;
        }
      }
    }
    for(int i = 0; i < n; i++) {
      System.out.print(list.get(i) + " ");
    }
  }
}
