import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
  static int[][] times;
  static int min;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    times = new int[12][12];
    min = Integer.MAX_VALUE;
    for(int i = 0; i < 12; i++) {
      st = new StringTokenizer(br.readLine());
      for(int j = 0; j < 12; j++) {
        times[i][j] = Integer.parseInt(st.nextToken());
      }
    }
    // 0 -> 1 -> 2
    pass(1, 2, times[0][1]);
    // 0 -> 1 -> 3
    pass(1, 3, times[0][1]);
    // 1 -> 0 -> 2
    pass(0, 2, times[1][0]);
    // 1 -> 0 -> 3
    pass(0, 3, times[1][0]);
//    boolean[] visited;
//    for(int i = 0; i < 12; i++) {
//      visited = new boolean[12];
//      visited[i] = true;
//      if(i%2==0) {
//        visited[i+1] = true;
//        message(i+1, 2, visited, times[i][i+1]);
//      } else {
//        visited[i-1] = true;
//        message(i-1, 2, visited, times[i-1][i]);
//      }
//    }
    System.out.println(min);
  }
  static void pass(int prev, int cur, int time) {
    if(cur == 12 || cur == 13) {
      min = Math.min(min, time);
      return;
    }
    time+=times[prev][cur];
    if(cur%2==0) {
      time+=times[cur][cur+1];
      pass(cur+1, cur+2, time);
      pass(cur+1, cur+3, time);
    } else {
      time+=times[cur][cur-1];
      pass(cur-1, cur+1, time);
      pass(cur-1, cur+2, time);
    }
  }
  static void message(int cur, int cnt, boolean[] visited, int time) {
    if(cnt>12) {
      return;
    }
    if(cnt == 12) {
      min = Math.min(min, time);
      return;
    }
    for(int i = 0; i < 12; i++) {
      if(!visited[i] && cur!=i) {
        visited[i] = true;
        if(i%2==0) {
          visited[i+1] = true;
          message(i+1, cnt+2, visited, time+times[cur][i]+times[i][i+1]);
          visited[i+1] = false;
        }else{
          visited[i-1] = true;
          message(i-1, cnt+2, visited, time + times[cur][i] + times[i][i-1]);
          visited[i-1] = false;
        }
        visited[i] = false;
      }
    }
  }
}
