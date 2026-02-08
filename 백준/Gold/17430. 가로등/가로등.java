import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int T = Integer.parseInt(br.readLine());
    int N;
//    Map<int[][], int[][]>
    StringTokenizer st;
    Map<Integer, Set<Integer>> map;
    for (int i = 0; i < T; i++) {
      map = new HashMap<>();
      N = Integer.parseInt(br.readLine());
      for (int j = 0; j < N; j++) {
        st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        if(!map.containsKey(a)) {
          Set<Integer> set = new HashSet<>();
          set.add(b);
          map.put(a, set);
        } else {
          map.get(a).add(b);
        }
      }
      Set<Integer> set = null;
      boolean flag = false;
      for(int k : map.keySet()) {
        if(set == null) {
          set = map.get(k);
        } else {
          if(!set.equals(map.get(k))) {
            flag = true;
            break;
          }
        }
      }
      if(!flag) {
        System.out.println("BALANCED");
      } else {
        System.out.println("NOT BALANCED");
      }
    }
  }
}
