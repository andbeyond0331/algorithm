import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int T = Integer.parseInt(br.readLine());
    StringTokenizer st;
    int n, m, answer;
    int[] clang, eco;
    double csum, esum, cavg, eavg;
    for (int i = 0; i < T; i++) {
      br.readLine();
      st = new StringTokenizer(br.readLine());
      n = Integer.parseInt(st.nextToken());
      m = Integer.parseInt(st.nextToken());
      clang = new int[n];
      eco = new int[m];
      csum = 0;
      esum = 0;
      answer = 0;
      st = new StringTokenizer(br.readLine());
      for(int j = 0; j < n; j++) {
        clang[j] = Integer.parseInt(st.nextToken());
        csum += clang[j];
      }
      st = new StringTokenizer(br.readLine());
      for(int j = 0; j < m; j++) {
        eco[j] = Integer.parseInt(st.nextToken());
        esum += eco[j];
      }
      cavg = csum / n;
      eavg = esum / m;
      for(int j = 0; j < n; j++) {
        if((csum-clang[j])/(n-1) >cavg && (esum+clang[j])/(m+1) > eavg) {

          answer++;
        }
      }
      System.out.println(answer);
    }
  }
}
