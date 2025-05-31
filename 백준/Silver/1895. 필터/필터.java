import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int r = Integer.parseInt(st.nextToken());
    int c = Integer.parseInt(st.nextToken());
    int[][] image = new int[r][c];
    for(int i = 0; i < r; i++) {
      st = new StringTokenizer(br.readLine());
      for(int j = 0; j < c; j++) {
        image[i][j] = Integer.parseInt(st.nextToken());
      }
    }
    int T = Integer.parseInt(br.readLine());
    int count = 0;
    List<Integer> list;
    for(int i = 0; i < r-2; i++) {
      for(int j = 0; j < c-2; j++) {
        list = new ArrayList<>();
        for(int k = i; k <= i+2; k++) {
          for(int l = j; l <= j+2; l++) {
            list.add(image[k][l]);
          }
        }
        list.sort(Integer::compareTo);
        if(list.get(4)>=T) {
          count++;
        }
      }
    }
    System.out.println(count);
  }
}
