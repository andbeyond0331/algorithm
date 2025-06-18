import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    long n = Long.parseLong(st.nextToken());
    long m = Long.parseLong(st.nextToken());
    if((n-1)%(m+1)!=0) {
      System.out.println("Can win");
    } else {
      System.out.println("Can't win");
    }
  }
}
