import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    int[][] customers = new int[n][2];
    // |a-x1| + |b-y1|
    // a-x2
    List<Integer> xs = new ArrayList<>();
    List<Integer> ys = new ArrayList<>();
    StringTokenizer st;
    for(int i = 0;i < n; i++) {
      st = new StringTokenizer(br.readLine());
      customers[i][0] = Integer.parseInt(st.nextToken());
      customers[i][1] = Integer.parseInt(st.nextToken());
      xs.add(customers[i][0]);
      ys.add(customers[i][1]);
    }
    xs.sort(Integer::compareTo);
    ys.sort(Integer::compareTo);
    int x = xs.get(xs.size()/2);
    int y = ys.get(ys.size()/2);
    long answer = 0;
    for(int i = 0;i < n; i++) {
      answer+=Math.abs(x-customers[i][0])+Math.abs(y-customers[i][1]);
    }
    System.out.println(answer);
  }
}
