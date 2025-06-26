import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(st.nextToken());
    int m = Integer.parseInt(st.nextToken());
    char[][] painting = new char[n][m];
    boolean[][] visited = new boolean[n][m];
    for(int i = 0; i < n; i++) {
      String line = br.readLine();
      for(int j = 0; j < m; j++) {
        if(!visited[i][j]) {

          if(line.charAt(j)!='.') {
//            System.out.println(line.charAt(j));
            visited[i][m-j-1] = true;
            painting[i][m-j-1] = line.charAt(j);
//            System.out.println(m-j-1);
          }
          painting[i][j] = line.charAt(j);
          visited[i][j] = true;
        }
      }
    }
    for(int i = 0; i < n; i++) {
      for(int j = 0; j < m; j++) {
        System.out.print(painting[i][j]);
      }
      System.out.println();
    }
  }
}
