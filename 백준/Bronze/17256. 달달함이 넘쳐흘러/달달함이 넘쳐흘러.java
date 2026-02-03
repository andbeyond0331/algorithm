import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int x1 = Integer.parseInt(st.nextToken());
    int y1 = Integer.parseInt(st.nextToken());
    int z1 = Integer.parseInt(st.nextToken());
    st = new StringTokenizer(br.readLine());
    int x2 = Integer.parseInt(st.nextToken());
    int y2 = Integer.parseInt(st.nextToken());
    int z2 = Integer.parseInt(st.nextToken());
    System.out.println((x2-z1) + " " + (y2/y1) + " " + (z2-x1));
  }
}
