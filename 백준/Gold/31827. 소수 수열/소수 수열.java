import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] input = br.readLine().split(" ");
    int N = Integer.parseInt(input[0]);
    int K = Integer.parseInt(input[1]);
    boolean[] visited = new boolean[1000004];
    List<Integer> primes = new ArrayList<>();
    for (int i = 3; i <= 1000000; i++) {
      if(!visited[i]) {
        primes.add(i);
        for (int j = i * 2; j <= 1000000; j+=i) {
          visited[j] = true;
        }
      }
    }
    List<Integer> ans = new ArrayList<>();
    if(K==8) {
      K/=2;
    }
    for(int val : primes) {
      if(((val - 1) / 2) % K == 0) {
        ans.add(val);
      }
      if(ans.size() == N) {
        break;
      }
    }
    for(int i : ans) {
      System.out.print(i + " ");
    }
  }
}
