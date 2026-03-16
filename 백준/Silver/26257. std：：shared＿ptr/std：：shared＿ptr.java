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
    StringTokenizer st = new StringTokenizer(br.readLine());
    int N = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(st.nextToken());
    int Q = Integer.parseInt(st.nextToken());
    int[] pointer = new int[M];
    for (int i = 0; i < M; i++) {
      pointer[i] = Integer.parseInt(br.readLine());
    }
    // assign x y: 포인터 x는 기존에 가리키도 있던 객체 대신 y가 가리키는 객체를 가리킨다.
    // swap x y: 포인터 x가 가리키던 객체를 포인터 y가 가리키고 포인터 y가
    for (int i = 0; i < Q; i++) {
      st = new StringTokenizer(br.readLine());
      String order = st.nextToken();
      int x = Integer.parseInt(st.nextToken());
      if(order.equals("assign")) {
        int y = Integer.parseInt(st.nextToken());
        pointer[x-1] = pointer[y-1];
      } else if(order.equals("swap")) {
        int y = Integer.parseInt(st.nextToken());
        int temp = pointer[x-1];
        pointer[x-1] = pointer[y-1];
        pointer[y-1] = temp;
      } else if(order.equals("reset")) {
        pointer[x-1] = 0;
      }
    }
    Arrays.sort(pointer);
    StringBuilder sb = new StringBuilder();
    int count = 0;
    boolean[] visited = new boolean[N+1];
    for (int i = 0; i < M; i++) {
      if(pointer[i] != 0 && !visited[pointer[i]]) {
        visited[pointer[i]] = true;
        count++;
        sb.append(pointer[i]).append("\n");
      }
    }
    System.out.println(count);
    System.out.println(sb.toString());
//    List<Integer> list = new ArrayList<>();
//    for (int i = 0; i < M; i++) {
//      if(pointer[i] != 0 && !list.contains(pointer[i])) {
//        list.add(pointer[i]);
//      }
//    }
//    list.sort(Integer::compareTo);
//    System.out.println(list.size());
//    for (int i = 0; i < list.size(); i++) {
//      System.out.println(list.get(i));
//    }
  }
}
