import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    // 36+4+25+1+49+1 -> 40+26+50 ->
    StringTokenizer st = new StringTokenizer(br.readLine());
    int[] arr = new int[n];
    for (int i = 0; i < n; i++) {
      arr[i] = Integer.parseInt(st.nextToken());
    }
    int answer = 0;
    for(int i = 1;i < n; i++) {
      answer+=Math.pow((arr[i]+arr[i-1]), 2) + Math.pow(Math.max(arr[i], arr[i-1])-Math.min(arr[i], arr[i-1]), 2);
    }
    System.out.println(answer);
  }
}
