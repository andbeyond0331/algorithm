import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    long[] anger = new long[N];
    StringTokenizer st = new StringTokenizer(br.readLine());
    for(int i = 0; i < N; i++) {
      long temp = Long.parseLong(st.nextToken());
      if(temp == 0) {
        anger[i] = -1;
      } else {
        anger[i] = 1;
      }
    }
    for(int i =1; i < N; i++) {
      anger[i] = anger[i-1] + anger[i];
    }
    for(int i = 1; i < N; i++) {
      anger[i] = anger[i-1] + anger[i];
    }
    System.out.println(anger[N-1]);

  }
}
