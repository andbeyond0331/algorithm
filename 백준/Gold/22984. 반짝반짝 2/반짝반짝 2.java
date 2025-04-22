import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    double[] p = new double[N];
    StringTokenizer st = new StringTokenizer(br.readLine());
    for(int i = 0; i < N; i++) {
      p[i] = Double.parseDouble(st.nextToken());
    }
    double ordinarySum = 0;
    for(int i = 0; i < N; i++) {
      ordinarySum += p[i];
    }
    for(int i = 0; i < N-1; i++) {
      ordinarySum += p[i] * (1-p[i+1]) + (1-p[i]) * p[i+1];
    }
    System.out.println(ordinarySum);
  }
}
