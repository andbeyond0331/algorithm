import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int t = Integer.parseInt(br.readLine());
//    long[] arr = new long[1000_000_000];
//    arr[1] = 1;
//    for(int i = 2; i < 1000_000_000; i++) {
//      arr[i] = arr[i-1] + i;
//    }
    for(int test = 0; test < t; test++) {
      int k = Integer.parseInt(br.readLine());
//      boolean flag = false;
      while(k!=1) {
        if(k%2==1) {
          System.out.println("Gazua");
          break;
        }
        k/=2;
      }
      if(k==1) {
        System.out.println("GoHanGang");
      }
//      outer:for(int i = 1; i < k; i++) {
//        if(arr[i]==k) {
//          flag = true;
//          break;
//        }
//        if(arr[i]>k) {
//          for(int j = 1; j < i; j++) {
//            if(arr[i]-arr[j]==k) {
//              flag = true;
//              break outer;
//            } else if(arr[i]-arr[j]<k) {
//              break;
//            }
//          } //// 
//        }
//      }
//      if(flag) {
//        System.out.println("Gazua");
//      } else {
//        System.out.println("GoHanGang");
//      }
    }
  }
}
// 2
// 3 1 2
// 4
// 5 2 3
// 6 1 2 3
// 7 3 4
// 8
//
