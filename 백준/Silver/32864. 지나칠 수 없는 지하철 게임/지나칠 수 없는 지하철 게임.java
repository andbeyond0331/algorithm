import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    StringTokenizer st = new StringTokenizer(br.readLine());
    // 승리하기 위한 최선의 선택
    // 마지막에서 두번째 환승역을 내가 받아야 함 -> 그래야 마지막 환승역 직전에서 넘겨줌
    // N-1이 일반이면 영향 X
    // N번 앞에서 환승역이 M이라고 치면
    int[] stations = new int[N];
    StringBuilder s = new StringBuilder();
    for(int i = 0; i < N; i++) {
      stations[i] = Integer.parseInt(st.nextToken());
      s.append(stations[i]);
    }
//    while(s.contains("11")) {
//      s = s.replace("11", "");
//    }
    s = new StringBuilder(s.toString().replaceAll("11", ""));
    if(s.charAt(1) == '0') {
      System.out.println("mnx");
    } else {
      System.out.println("alsdkffhgk");
    }
  }
}
