import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Main {
  static int n, m;
  static int[] arr;
  static List<String> list;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());
    arr = new int[n];
    list = new ArrayList<>();
    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < n; i++) {
      arr[i] = Integer.parseInt(st.nextToken());
    }
    Arrays.sort(arr);
    pick(0, 0, "");
    for (String s : list) {
      System.out.println(s);
    }
  }
  static void pick(int cnt, int depth, String s) {
    if(cnt == m) {
      if(!list.contains(s)) {
        list.add(s);
      }
      return;
    }
    if(cnt > m || depth >= n) {
      return;
    }
    for(int i = depth; i < n; i++) {
      if(s.isEmpty()) {
        pick(cnt+1, i+1, s+arr[i]);
      }else {

        pick(cnt+1, i+1, s+" "+arr[i]);
      }
    }
  }
}
