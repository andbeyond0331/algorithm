import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    String line = br.readLine();
    int rCount = 0, rLCount = 0, bCount = 0, bLCount = 0;
    boolean previousR = false;
    boolean previousB = false;
    for(int i = 0; i < N; i++) {
      if(i == 0) {
        if(line.charAt(i) == 'R') {
          previousR = true;
          previousB = false;
        } else {
          previousR = false;
          previousB = true;
        }
      } else {
        if(line.charAt(i) == 'B') {
          if(previousR) {
            bLCount++;
          }
          previousB = true;
        } else {
          if(previousB) {
            rLCount++;
          }
          previousR = true;
        }
      }
    }
    for(int i = N-1; i >= 0; i--) {
      if(i == N-1) {
        if(line.charAt(i) == 'R') {
          previousR = true;
          previousB = false;
        } else {
          previousR = false;
          previousB = true;
        }
      } else {
        if(line.charAt(i) == 'B') {
          if(previousR) {
            bCount++;
          }
          previousB = true;
        } else {
          if(previousB) {
            rCount++;
          }
          previousR = true;
        }
      }

    }
    System.out.println(Math.min(rCount, Math.min(rLCount, Math.min(bCount, bLCount))));
  }

}
