import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Color implements Comparable<Color> {
  int num;
  int count;
  public Color(int num, int count) {
    this.num = num;
    this.count = count;
  }
  @Override
  public int compareTo(Color o) {
    return o.count - count;
  }
}
public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(st.nextToken());
    int k = Integer.parseInt(st.nextToken());
    int[] color = new int[k];
    st = new StringTokenizer(br.readLine());
    for(int i = 0; i < k; i++) {
      color[i] = Integer.parseInt(st.nextToken());
    }
    PriorityQueue<Color> pq = new PriorityQueue<>();
    for(int i = 0; i < k; i++) {
      pq.add(new Color(i+1, color[i]));
    }
    List<Integer> ans = new ArrayList<>();
    int last = -1;
while (!pq.isEmpty()) {
  Color first = pq.poll();
  if (first.num == last) {
    // 바로 다음 후보를 꺼내고, 다시 넣어 주기
    Color second = pq.poll();
    if (second == null) {
      System.out.println(-1);
      return;
    }
    // second를 쓰고, first를 다시 PQ에 넣는다
    ans.add(second.num);
    last = second.num;
    if (second.count > 1) pq.offer(new Color(second.num, second.count - 1));
    pq.offer(first);
  } else {
    // first를 쓰면 OK
    ans.add(first.num);
    last = first.num;
    if (first.count > 1) pq.offer(new Color(first.num, first.count - 1));
  }
}
//
//    for(int i = 0;i < n; i++) {
//      Color c = pq.poll();
//      answer[i] = c.num;
//      if(i!=0) {
//        if(answer[i] == answer[i-1]) {
//          System.out.println(-1);
//          return;
//        }
//      }
//      if(c.count > 1) {
//        pq.add(new Color(c.num, c.count-1));
//      }
//    }
    for(int i = 0; i < n; i++) {
      System.out.print(ans.get(i) + " ");
    }
  }

}

