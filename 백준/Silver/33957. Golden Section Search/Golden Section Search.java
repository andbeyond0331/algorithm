import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    // 분할 시 난이도 합이 겹치는 구간이 있으면 가능.
    int[] L = new int[N];
    int[] R = new int[N];
    StringTokenizer st;
    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine());
      L[i] = Integer.parseInt(st.nextToken());
      R[i] = Integer.parseInt(st.nextToken());
    }
    for(int i = 1; i < N; i++) {
      L[i] += L[i - 1];
      R[i] += R[i - 1];
    }
    int answer = 0;
    for(int i = 1; i < N; i++) {
      int oneMin = L[i-1];
      int oneMax = R[i-1];
      int twoMin = L[N-1]-L[i-1];
      int twoMax = R[N-1]-R[i-1];
      if(oneMin==twoMin) {
        answer++;
      } else {
        if(oneMin<twoMin) {
          if(oneMax>=twoMin) {
            answer++;
          }
        } else {
          if(twoMax>=oneMin) {
            answer++;
          }
        }
      }
    }
    System.out.println(answer);
  }
}
