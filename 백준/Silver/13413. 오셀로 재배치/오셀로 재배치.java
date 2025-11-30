import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int T = Integer.parseInt(br.readLine());
    int N;
    String input, goal;
    int bwCount;
    int wbCount;
    int answer = 0;
    for (int i = 0; i < T; i++) {
      N = Integer.parseInt(br.readLine());
      // 바꿀 수 있는 상황: 다른 게 짝수일 때 && 위치가 반대일 때
      // B에서 W로 바꿔야 하는 횟수
      // W에서 B로 바꿔야 하는 횟수
      input = br.readLine();
      goal = br.readLine();
      bwCount = 0;
      wbCount = 0;
      answer = 0;
      for (int j = 0; j < N; j++) {
        if(input.charAt(j)!=goal.charAt(j)){
          if(input.charAt(j)=='B') {
            bwCount++;
          } else {
            wbCount++;
          }
        }
      }
      if(bwCount>wbCount){
        answer = wbCount;
        bwCount-=wbCount;
        wbCount=0;
      } else {
        answer = bwCount;
        wbCount-=bwCount;
        bwCount=0;
      }
      if(bwCount+wbCount==0) {
        System.out.println(answer);
      } else {
        System.out.println(answer+Math.max(bwCount, wbCount));
      }
    }
  }
}
