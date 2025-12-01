import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    int[] arr = new int[n];
    int[] counts = new int[n];
    StringTokenizer st = new StringTokenizer(br.readLine());
    for (int i = 0; i < n; i++) {
      counts[i] = Integer.parseInt(st.nextToken());
    }
    for(int i = 0;i < n; i++) {
//      int idx = 0;
      for(int j = 0; j < n; j++) {
        if(counts[i]==0 && arr[j]==0) {
          arr[j] = i+1;
          break;
        }
        if(arr[j]==0) {
          counts[i]--;
        }
      }
//      while(counts[i] > 0 && arr[idx]==0) {
//        for(int j = 0; j < n; j++) {
//          System.out.print(arr[j] + " ");
//        }
//        System.out.println();
//        if(arr[idx] == 0) {
//          counts[i]--;
//        }
//        idx++;
//      }
//      arr[idx] = i+1;
    }
    for (int i = 0; i < n; i++) {
      System.out.print(arr[i] + " ");
    }
  }
}
