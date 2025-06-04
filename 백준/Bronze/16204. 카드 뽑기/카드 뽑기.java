import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(st.nextToken());
    int m = Integer.parseInt(st.nextToken());
    int k = Integer.parseInt(st.nextToken());
    // o는 m개, x는 n-m개
    // o는 k개, x는 n-k개
    // Math.max(m, k) Math.max(n-m, n-k)
    System.out.println(Math.min(m, k) + Math.min(n-m, n-k));

  }
}
