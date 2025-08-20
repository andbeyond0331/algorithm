import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(st.nextToken()); // 노드 개수
    int m = Integer.parseInt(st.nextToken()); // 질문 횟수
    int v = Integer.parseInt(st.nextToken()); // N번 노드가 가리키는 노드 번호
    v--;
    st = new StringTokenizer(br.readLine());
    int[] arr = new int[n];
    for (int i = 0; i < n; i++) {
      arr[i] = Integer.parseInt(st.nextToken());
    }
    int q;
    for(int i = 0; i < m; i++) {
      q = Integer.parseInt(br.readLine());
      if(q>=n) {
        System.out.println(arr[(q-n)%(n-v)+(v)]);
//        System.out.println(arr[(q-v)%(n-v)]);
      } else {
        System.out.println(arr[q]);
      }
    }
  }
}
// 0 1 2 3 4 5 6 7 8 9 2 3 4 5 6 7 8 9 2 3 4 5 6 7 8 9
//

// 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20
// 1 2 3 4 5 6 7 8 9 2  3  4  5  6  7  8  9  2  3  4
//
