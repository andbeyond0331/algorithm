import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
  static int[] numbers;
//  static boolean[] visited;
  static StringBuilder sb;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int k = Integer.parseInt(st.nextToken());
    sb = new StringBuilder();
    while(k>0) {
      numbers = new int[k];
//      visited = new boolean[k];
      for(int i = 0;i < k; i++) {
        numbers[i] = Integer.parseInt(st.nextToken());
      }
      print(0, 0, new boolean[numbers.length]);
      sb.append("\n");
      st = new StringTokenizer(br.readLine());
      k = Integer.parseInt(st.nextToken());
    }
    System.out.println(sb);
  }
  static void print(int n, int d, boolean[] visited) {
    if(n==6) {
      for(int i = 0;i < visited.length;i++) {
        if(visited[i]) {
          sb.append(numbers[i]).append(" ");
        }
      }
      sb.append("\n");
      return;
    }
    for(int i = d; i < numbers.length; i++) {
      if(!visited[i]) {
        visited[i] = true;
        print(n+1, i+1, visited);
        visited[i] = false;
      }
    }
  }
}
