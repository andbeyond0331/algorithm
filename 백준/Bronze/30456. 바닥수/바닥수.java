import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int N = Integer.parseInt(st.nextToken());
    int L = Integer.parseInt(st.nextToken());
    String s = "";
      for(int i=1;i<L;i++) {
        s+="1";
      }
      s+=String.valueOf(N);
      System.out.println(s);


  }// 1238 -> 48 -> 32 -> 6 4\
}
