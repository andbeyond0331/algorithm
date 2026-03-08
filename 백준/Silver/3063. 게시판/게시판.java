import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int T = Integer.parseInt(br.readLine());
    for (int i = 0; i < T; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      int x1 = Integer.parseInt(st.nextToken());
      int y1 = Integer.parseInt(st.nextToken());
      int x2 = Integer.parseInt(st.nextToken());
      int y2 = Integer.parseInt(st.nextToken());
      int x3 = Integer.parseInt(st.nextToken());
      int y3 = Integer.parseInt(st.nextToken());
      int x4 = Integer.parseInt(st.nextToken());
      int y4 = Integer.parseInt(st.nextToken());
      // 왼쪽 아래 오른쪽 위
      // 경우의 수 생각
      // 1. 안 겹칠 때
//      if(x4<=x1 || x2<=x3 || y1>=y4 || y3<=y2) {
//        System.out.println(0);
//        continue;
//      }
      int origin = (x2-x1)*(y2-y1);
      int row = Math.max(Math.min(x2, x4)-Math.max(x1, x3), 0);
      int col = Math.max(Math.min(y2, y4)-Math.max(y1, y3), 0);
      System.out.println(origin-row*col);
    }

  }
}
