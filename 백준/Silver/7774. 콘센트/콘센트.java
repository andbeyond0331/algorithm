import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
  public static void main(String[] args) throws IOException {
    // 입력 준비
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    // 입력 받기
    st = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(st.nextToken()); // A→B 멀티탭 개수
    int m = Integer.parseInt(st.nextToken()); // B→A 멀티탭 개수

    Integer[] a = new Integer[n]; // A→B 멀티탭 콘센트 수
    Integer[] b = new Integer[m]; // B→A 멀티탭 콘센트 수

    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < n; i++) a[i] = Integer.parseInt(st.nextToken());

    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < m; i++) b[i] = Integer.parseInt(st.nextToken());

    // 내림차순 정렬
    Arrays.sort(a, Collections.reverseOrder());
    Arrays.sort(b, Collections.reverseOrder());

    int ia = 0, ib = 0;     // 포인터
    int hole = 0;           // B 콘센트 남은 수
    int result = 1;         // 시작 A 콘센트 1개

    while (ia < n && ib < m) {
      // A 콘센트가 없으면 A→B 멀티탭 하나 연결
      if (hole == 0) {
        hole += a[ia]; // B 콘센트 확보
        ia++;
        result--;      // A 콘센트 1개 사용
      }

      // 확보한 B 콘센트로 B→A 멀티탭 연결
      while (ib < m && hole > 0) {
        result += b[ib]; // A 콘센트 확보
        ib++;
        hole--;          // B 콘센트 하나 소모
      }
    }

    System.out.println(result);
  }
}
