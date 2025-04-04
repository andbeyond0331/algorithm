import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String prev = br.readLine();
    String next = br.readLine();
    int minLength = Math.min(prev.length(), next.length());
    // 경우의 수 나누기
    // 제거만 하는 경우
    // 대체한 길이가 더 긴 경우
    // 대체한 길이가 더 짧은 경우
    int s = 0;
    while (s<minLength && prev.charAt(s) == next.charAt(s)) {
      s++;
    }
    int e = 0;
    while(e < minLength && prev.charAt(prev.length()-1-e) == next.charAt(next.length()-1-e)) {
      e++;
    }
    // 만약 대체한 길이가 더 긴 경우?
    if(s>=minLength - e) {
      if(prev.length() > next.length()) {
        System.out.println(0);
      } else {
        System.out.println(next.length() - prev.length());
      }
    } else {
      System.out.println(next.length() - s - e);
    }
  }
}
