import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    int stones = 1;
    while(N>=stones) {
      N-=stones;
      stones++;
    }
    if(stones%2==0) {
      System.out.println(0);
    } else {
      System.out.println(stones-N);
    }
  }
}
