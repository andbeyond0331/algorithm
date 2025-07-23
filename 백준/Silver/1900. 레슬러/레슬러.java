import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    int[][] athletes = new int[n][3];
    StringTokenizer st;
    for(int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine());
      athletes[i][0] = i+1;
      athletes[i][1] = Integer.parseInt(st.nextToken());
      athletes[i][2] = Integer.parseInt(st.nextToken());
//      athletes[i][3] = (athletes[i][2]-1)/athletes[i][1];
    }
    Arrays.sort(athletes, new Comparator<int[]>() {
      @Override
      public int compare(int[] o1, int[] o2) {
        double d1 = ((double)o1[2]-1)/(double)o1[1];
        double d2 = ((double)o2[2]-1)/(double)o2[1];
        return Double.compare(d2, d1);
      }
    });
    for(int i = 0; i < n; i++) {
      System.out.println(athletes[i][0]);
    }
  }
}
// si + ri * sj > sj + rj * si
// (ri-1)/si > (rj-1)/sj
