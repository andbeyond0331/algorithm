import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int L = Integer.parseInt(st.nextToken());
    int R = Integer.parseInt(st.nextToken());
    // L부터 R까지 8이 가장 적게 들어있는
    int count = Integer.MAX_VALUE;
    int add = 0;
    String sl = String.valueOf(L);
    String sr = String.valueOf(R);
    if(sl.length() == sr.length()) {
      if(sl.charAt(0) == '8' && sr.charAt(0) == '8') {
        while(true) {
          if(sl.length()>0 && sl.charAt(0) == '8' && sr.charAt(0) == '8') {
            sl = sl.substring(1);
            sr = sr.substring(1);
            add++;
          } else {
            break;
          }
        }
        sl = "1" + sl;
        sr = "1" + sr;
        int l = Integer.parseInt(sl);
        int r = Integer.parseInt(sr);
//        System.out.println(l + " " + r);
        for(int i = l; i <= r; i++) {
          String stan = String.valueOf(i);
          if(stan.contains("8")) {
            String s = String.valueOf(i);
            s = s.replaceAll("8", "");
            count = Math.min(count, stan.length() - s.length());
          }else {
            count = 0;
            break;
          }
        }
        if(count == Integer.MAX_VALUE) {
          count = 0;
        }
//        System.out.println(add + " " + count);
        count += add;
      } else {
        String same = "";
        for(int i = 0; i < sl.length(); i++) {
          if(sl.charAt(i) == sr.charAt(i)) {
            same+=sl.charAt(i);
          }else {
            break;
          }
        }
        String change = same;
        change = change.replaceAll("8", "");
        count = Math.min(count, same.length() - change.length());
      }
    }else {
      count = 0;
    }
//    for(int i = L; i <= R; i++) {
//      if(count == 0) {
//        break;
//      }
//      String stan = String.valueOf(i);
//
//      if(stan.contains("8")) {
//        String s = String.valueOf(i);
//        s = s.replaceAll("8", "");
//        count = Math.min(count, stan.length() - s.length());
//      } else {
//        count = 0;
//        break;
//      }
//
//    }
    System.out.println(count);
  }
}
