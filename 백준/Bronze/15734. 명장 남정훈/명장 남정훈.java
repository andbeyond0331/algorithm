import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int L = Integer.parseInt(st.nextToken());
    int R = Integer.parseInt(st.nextToken());
    int A = Integer.parseInt(st.nextToken());
    if(L>R) {
      R+=A;
      if(R>L) {
        if((R-L)%2==0) {
          System.out.println(R+L);
        } else {
          System.out.println(R+L-1);
        }
//        System.out.println(2*L);
      } else {
        System.out.println(2*R);
      }
    } else if(L==R) {
      if(A%2==0) {
        System.out.println(A+R+L);
      } else {
        System.out.println(A+R+L-1);
      }
    } else {
      L+=A;
      if(L>R) {
        if((L-R)%2==0) {
          System.out.println(R+L);
        } else {
          System.out.println(R+L-1);
        }
//        System.out.println(2*R);
      } else {
        System.out.println(2*L);
      }
    }
  }
}
