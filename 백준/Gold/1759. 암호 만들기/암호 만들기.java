import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
  static int L, C;
  static char[] code;
  static StringBuilder sb;
  static String mo = "aeiou";
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    L = Integer.parseInt(st.nextToken()); // 서로 다른 L개의 알파벳 소문자
    C = Integer.parseInt(st.nextToken()); // 사용했을법한 문자의 종류
    code = new char[C];
    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < C; i++) {
      code[i] = st.nextToken().charAt(0);
    }
    sb = new StringBuilder();
    Arrays.sort(code);
//    for(int i = 0; i < C; i++) {
//      System.out.println(code[i]);
//    }
    solve(0, 0, new boolean[C]);
    System.out.println(sb.toString());
  }
  static void solve(int n, int depth, boolean[] visited) {
    if(n==L) {
      StringBuilder temp = new StringBuilder();
      int moCount = 0;
      for(int i=0; i<C; i++){
        if(visited[i]){
//          sb.append(code[i]);
          if(mo.contains(String.valueOf(code[i]))) {
            moCount++;
          }
          temp.append(String.valueOf(code[i]));
        }
      }
      if(moCount>0 && n-moCount>1) {
        sb.append(temp);
        sb.append("\n");
      }
      return;
    }
    for(int i = depth; i < C; i++) {
      if(!visited[i]){
        visited[i] = true;
        solve(n+1, i+1, visited);
        visited[i] = false;
      }
    }
  }
}
