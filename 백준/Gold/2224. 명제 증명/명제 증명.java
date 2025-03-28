import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    StringBuilder sb = new StringBuilder();
    boolean[][] arr = new boolean[52][52];
    int sum = 0;
    for (int i = 0; i < n; i++) {
      String s = br.readLine();
      int a = s.charAt(0);
      int b = s.charAt(5);
      if(a >= 97 && a<= 122) {
        a = a - 'a' + 26;
      } else {
        a = a - 'A';
      }
      if(b >= 65 && b <= 90) {
        b = b - 'A';
      }else {
        b = b - 'a' + 26;
      }
//      System.out.println(a + ", " + b);
      arr[a][b] = true;
    }
//    for(int i = 0; i < 52; i++) {
//      for(int j = 0; j < 52; j++) {
//          for(int k = 0; k < 52; k++) {
//            if(arr[j][k] && arr[i][j]) {
//              arr[i][k] = true;
//            }
//
//        }
//      }
//    }
    for (int k = 0; k < 52; k++) {
      for (int i = 0; i < 52; i++) {
        for (int j = 0; j < 52; j++) {
          if (arr[i][k] && arr[k][j]) {
            arr[i][j] = true;
          }
        }
      }
    }
    for(int i = 0; i < 26; i++) {
      for(int j = 0; j < 26; j++) {
        if(i!=j && arr[i][j]) {
          sum++;
          sb.append((char)(i+'A')).append(" => ").append((char)(j+'A')).append("\n");
        }
      }
      for(int j = 26; j < 52; j++) {
        if(i!=j && arr[i][j]) {
          sum++;
          sb.append((char)(i+'A')).append(" => ").append((char)(j+'a'-26)).append("\n");
        }
      }
    }
    for(int i = 26; i < 52; i++) {
      for(int j = 0; j < 26; j++) {
        if(i!=j && arr[i][j]) {
          sum++;
          sb.append((char)(i+'a'-26)).append(" => ").append((char)(j+'A')).append("\n");
        }
      }
      for(int j = 26; j < 52; j++) {
        if(i!=j && arr[i][j]) {
          sum++;
          sb.append((char)(i+'a'-26)).append(" => ").append((char)(j+'a'-26)).append("\n");
        }
      }
    }
    System.out.println(sum);
    System.out.println(sb);
  }
}
