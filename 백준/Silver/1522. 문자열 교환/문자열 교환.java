import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String s = br.readLine();
    String temp = s.replaceAll("b", ""); // a만 남음
    String target = s.substring(0, temp.length());
    target = target.replaceAll("b", "");
//    System.out.println(temp.length() + " + " + target.length());
    int a = target.length();
    int b = temp.length() - target.length();
    int min = b;
    for(int i = temp.length(); i < s.length(); i++) {
      char next = s.charAt(i);
      char prev = s.charAt(i-temp.length());
//      System.out.println("i: " + i + " next: " + next + " prev: " + prev);
      if(next == 'a') {
        a++;
      }else {
        b++;
      }
      if(prev == 'a') {
        a--;
      }else {
        b--;
      }
//      System.out.println("a: " + a + " b: " + b);
      min = Math.min(min, b);
    }
    for(int i = 0; i < temp.length(); i++) {
      if(s.charAt(i) == 'a') {
        a++;
      } else {
        b++;
      }
      if(s.charAt(s.length()-temp.length()+i) == 'a') {
        a--;
      }else{
        b--;
      }
      min = Math.min(min, b);
    }
    System.out.println(min);
  }
}
