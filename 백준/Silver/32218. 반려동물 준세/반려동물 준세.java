import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    int[] arr = new int[n];
    String[] str = br.readLine().split(" ");
    for (int i = 0; i < n; i++) {
      arr[i] = Integer.parseInt(str[i]);
    }
    int[] b = new int[n];
    for(int i = 0; i < n; i++) {
      for(int j = i+1; j < n; j++) {
        if(arr[i]<arr[j]) {
          b[i]++;
        }
      }
    }
    int count = 1;
    if(check(arr, b)) {
      System.out.println(count);
      return;
    }
    while(true) {
      int[] a = Arrays.copyOf(b, b.length);
      b = new int[n];
      for(int i = 0; i < n; i++) {
        for(int j = i+1; j < n; j++) {
          if(a[i]<a[j]) {
            b[i]++;
          }
        }
      }
//      for(int i = 0; i < n; i++) {
//        System.out.print(a[i] + " ");
//      }
//      System.out.println(
//      );
//      for(int j = 0; j < n; j++) {
//        System.out.print(b[j] + " ");
//      }
      if (check(a, b)) {
        System.out.println(count+1);
        return;
      }
      if(check(arr, b)) {
        System.out.println(-1);
        return;
      }
      count++;
    }
  }
  static boolean check(int[] a, int[] b) {
    for(int i = 0; i < a.length; i++) {
      if(a[i]!=b[i]) {
        return false;
      }
    }
    return true;
  }
}
