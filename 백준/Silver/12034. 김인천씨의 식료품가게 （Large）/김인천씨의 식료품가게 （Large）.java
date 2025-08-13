import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int T = Integer.parseInt(br.readLine());
    int n;
    int[] prices;
    boolean[] visited;
    int[] discounted;
    int idx;
    StringTokenizer st;
    for (int t = 1; t <= T; t++) {
      n = Integer.parseInt(br.readLine());
      prices = new int[n*2];
      discounted = new int[n];
      st = new StringTokenizer(br.readLine());
      for (int i = 0; i < n*2; i++) {
        prices[i] = Integer.parseInt(st.nextToken());
      }
//      for(int i = 0; i < n*2; i++) {
//        System.out.print(prices[i] + " ");
//      }
      visited = new boolean[n*2];
      idx = 0;
      for (int i = 0; i < n*2; i++) {
        if(!visited[i]) {
          visited[i] = true;
          for(int j = i+1; j < n*2; j++) {
            if(!visited[j] && prices[i]/3*4 == prices[j]) {
              visited[j] = true;
              discounted[idx++] = prices[i];
              break;
            }
          }
        }

      }
      System.out.printf("Case #%d:", t);
      for(int i = 0; i < discounted.length; i++) {
        System.out.print(" " + discounted[i]);
      }
      System.out.println();
    }

  }

}
