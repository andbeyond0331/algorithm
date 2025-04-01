import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
  static String s;
  static Integer[][] count;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    s = br.readLine();
    count = new Integer[s.length()][26];
    count[0][s.charAt(0) - 'a'] = 1;
//    counter(s.length()-1, 25);
    for(int i = 0; i < s.length(); i++) {
      for(int j = 0; j < 26; j++) {
        counter(i, j);
      }
    } // 1 2 3 4 -> 1 3 6 10
//    for(int i = 0; i < 26; i++) {
//      for(int j = 1; j < s.length(); j++) {
//        char c = s.charAt(j);
//        if(i==c-'a') {
//          count[j][i] = count[j-1][i] + 1;
//        }else {
//          count[j][i] = count[j-1][j];
//        }
//      }
//    }

//    for(int i = 1; i < s.length(); i++) {
//      char c = s.charAt(i);
//      for(int j = 0; j < 26; j++) {
//        if(j == c - 'a') {
//          count[i][j] = count[i - 1][j] + 1;
//        } else {
//          count[i][j] = count[i -1][j];
//        }
//      }
//    }
//    for(int i = 0; i < s.length(); i++) {
//      for(int j = 0; j < 26; j++) {
//        System.out.print(count[i][j] + " ");
//      }
//      System.out.println();
//    }
    StringBuilder sb = new StringBuilder();
    int q = Integer.parseInt(br.readLine());
    StringTokenizer st;
    for (int i = 0; i < q; i++) {
      st = new StringTokenizer(br.readLine());
      char a = st.nextToken().charAt(0);
      int l = Integer.parseInt(st.nextToken());
      int r = Integer.parseInt(st.nextToken());
//      System.out.println(count[r][a - 'a'] - (l==0 ? 0 : count[l-1][a - 'a']));
      sb.append(count[r][a - 'a'] - (l==0 ? 0 : count[l-1][a - 'a'])).append("\n");
    }
    System.out.println(sb.toString());
  }
  static int counter(int i, int j) {
    if(count[i][j] == null) {
      if(i==0) {
        if(j==s.charAt(i) - 'a') {
          count[i][j] = 1;
        } else {
          count[i][j] = 0;
        }
      } else {

        if(j == s.charAt(i) - 'a') {
          count[i][j] = counter(i-1, j) + 1;
        } else {
          count[i][j] = counter(i-1, j);
        }
      }
    }
    return count[i][j];
  }
}
