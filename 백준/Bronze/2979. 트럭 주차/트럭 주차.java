import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int a = Integer.parseInt(st.nextToken());
    int b = Integer.parseInt(st.nextToken());
    int c = Integer.parseInt(st.nextToken());
    int[] times = new int[101];
    for(int i = 0; i < 3; i++) {
      st = new StringTokenizer(br.readLine());
      int t1 = Integer.parseInt(st.nextToken());
      int t2 = Integer.parseInt(st.nextToken());
      for(int j = t1; j < t2; j++) {
        times[j]++;
      }
    }
    int answer = 0;
    for(int i = 1; i <=100; i++) {
      if(times[i]==1) {
        answer+=a;
      } else if(times[i]==2) {
        answer+=b*2;
      } else if(times[i]==3) {
        answer+=c*3;
      }
    }
//    for(int i = 0;i < times.length; i++) {
//      System.out.print(times[i] + " ");
//    }
    System.out.println(answer);
  }
}
