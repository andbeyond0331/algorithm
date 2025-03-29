import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(st.nextToken()); // 주차공간수
    int m = Integer.parseInt(st.nextToken()); // 차량들
    int[] parkingLots = new int[n];
    boolean[] visited = new boolean[n];
    Integer[][] cars = new Integer[m+1][2]; // 0: 무게 1: 주차장 번호
    for(int i = 0; i < n; i++) {
      parkingLots[i] = Integer.parseInt(br.readLine());
    }
    for(int i = 1; i <= m; i++) {
      cars[i][0] = Integer.parseInt(br.readLine());
    }

    Queue<Integer> waitingCars = new LinkedList<>();
    int parked = 0; // 현재 주차된 차량
    int income = 0; // 수입
    for(int i = 0; i < 2*m; i++) {
      int car = Integer.parseInt(br.readLine());
      if(car > 0) { // 들어오는 차량

        if(parked == n) { // 만차라면 기다려
          waitingCars.add(car);
        }else { // 만차 아니면
          for(int j = 0;j < n; j++) {
            if(!visited[j]) {
              cars[car][1] = j;
              visited[j] = true;
              parked++;
              income += cars[car][0] * parkingLots[j];
              break;
            }
          }
        }
      } else { // 나가는 차량
        car*= -1;
        visited[cars[car][1]] = false;
        parked--;
        if(!waitingCars.isEmpty()) {
          parked++;
          int temp = waitingCars.poll();
          cars[temp][1] = cars[car][1];
          visited[cars[car][1]] = true;
          income += cars[temp][0] * parkingLots[cars[car][1]];
        }
        cars[car][1] = 0;

      }
    }
    System.out.println(income);
  }
}
