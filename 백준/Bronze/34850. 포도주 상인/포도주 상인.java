import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
  static int x, y, p, a, b;
  static long answer;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    x = Integer.parseInt(st.nextToken()); // 포도주 병 수
    y = Integer.parseInt(st.nextToken()); // 판매일
    p = Integer.parseInt(st.nextToken()); // 1일차 포도주 한 병 가격
    a = Integer.parseInt(st.nextToken()); // 한 병 판매할 때마다 감소하는 가격
    b = Integer.parseInt(st.nextToken()); // 하루마다 증가하는 가격
    // 첫 날 다 파는 거..
    // 둘째날 하나 파는거..
    // x개
    // p + (p-a) + (p-2*a) + (p-3*a) + (p-4*a) ... (p-(x-1)*a)
    // (2*p + (x-1)*a)*x/2
    // 일단 a는 언제 사든 계속 감소..
    // 그럼 날짜가 중요함
    // 지금까지 몇 병 팔았는지, 몇일차인지, 지금까지 얼마 나왔는지
//    answer = Integer.MIN_VALUE;
    long first = p+(y-1)*b;
    answer = (2*first - (x-1)*a)*x/2;
//    selling(1, 0, 0);
    System.out.println(answer);
  }
//  static void selling(int day, int sold, int count) {
//    if(day>y) {
//      return;
//    }
//    if(sold == x) {
//      answer = Math.max(answer, count);
//      return;
//    }
//
//    selling(day+1, sold, count);
//    int first = p-(sold*a)+(day*b);
//    for(int i = 1; i <= x-sold; i++) {
//      int today = (2*first - (i-1)*a)*i/2;
//      selling(day+1, sold+i, count+today);
//    }
//  }
}
