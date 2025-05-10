import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int m = Integer.parseInt(br.readLine());
    String[] input = br.readLine().split(" ");
//    double[] b = new double[input.length];
    int[] nums = new int[input.length];
    for (int i = 0; i < input.length; i++) {
      String s = input[i];      // e.g. "0.333333"
      String dec = s.substring(2);       // "333333"
      while (dec.length() < 6) dec += '0';
      nums[i] = Integer.parseInt(dec);  // 333333

//      double temp = Double.parseDouble(input[i]) + 1e-7;
//      double temp = Double.parseDouble(input[i]);
//      nums[i] = (int) (1000000 * temp);
    }
//    for(int i = 0; i < nums.length; i++) {
//      System.out.print(nums[i] + " ");
//    }
    int[] counts = new int[m];
    int l = 1000000/m;
    for (int i = 0; i < input.length; i++) {
      int idx = (int)((long)nums[i] * m / 1_000_000);
      if (idx >= m) idx = m - 1;
      counts[idx]++;
//      int temp = nums[i];
//      for(int j = 0; j < m; j++) {
////        if(temp>=j*l && temp<(j+1)*l) {
//////          System.out.println(l*(double)j + "~" + l*(double)(j+1) + "~" + temp);
////          counts[j]++;
////          break;
////        }
//        if (j < m-1) {
//          if (temp >= j*l && temp < (j+1)*l) {
//            counts[j]++;
//            break;
//          }
//        } else {
//          // 마지막 구간은 오른쪽 끝 포함
//          if (temp >= j*l && temp <= (j+1)*l) {
//            counts[j]++;
//            break;
//          }
//        }
//      }
    }
    for (int i = 0; i < m; i++) {
      System.out.print(counts[i] + " ");
    }
  }

}
