import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    PriorityQueue<String> pq = new PriorityQueue<>();
    StringTokenizer st;
    for(int i = 0;i < N; i++) {
      st = new StringTokenizer(br.readLine());
      pq.add(st.nextToken() + "B");
      pq.add(st.nextToken() + "A");
    }
    int bus = 0;
    int max = -1;
    while(!pq.isEmpty()) {
      max = Math.max(bus, max);
//      System.out.println(bus);
      String s = pq.poll();
      if(s.charAt(s.length() - 1) == 'A') {
        bus--;
      } else {
        bus++;
      }
    }
    System.out.println(max);
  }
}
