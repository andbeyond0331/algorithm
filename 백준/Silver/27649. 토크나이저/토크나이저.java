import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String input = br.readLine();
    StringBuilder sb = new StringBuilder();
    for(int i = 0; i < input.length(); i++) {
      if(input.charAt(i) == '<') {
        sb.append(" ").append(input.charAt(i)).append(" ");
      } else if(input.charAt(i) == '>') {
        sb.append(" ").append(input.charAt(i)).append(" ");
      } else if(input.charAt(i) == '&') {
        sb.append(" ").append("&&").append(" ");
        i++;
      } else if(input.charAt(i) == '|') {
        sb.append(" ").append("||").append(" ");
        i++;
      } else if(input.charAt(i) == '(') {
        sb.append(" ").append(input.charAt(i)).append(" ");
      } else if(input.charAt(i) == ')') {
        sb.append(" ").append(input.charAt(i)).append(" ");
      } else {
        sb.append(input.charAt(i));
      }
    }
    StringBuilder out = new StringBuilder();
    for(int i = 0; i < sb.length(); i++) {
      if(sb.charAt(i) == ' ') {
        if(i!=0 && sb.charAt(i-1) == ' ') {
          continue;
        }
      }
      out.append(sb.charAt(i));
    }
    System.out.println(out.toString().trim());
  }
}
