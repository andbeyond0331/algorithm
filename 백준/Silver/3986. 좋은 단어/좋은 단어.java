import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    Stack<Character> stack;
    int answer = 0;
    outer: for (int i = 0; i < n; i++) {
      String s = br.readLine();
      stack = new Stack<>();
      stack.push(s.charAt(0));
      for(int j = 1; j < s.length(); j++) {
        char c = s.charAt(j);
        if(stack.isEmpty()) {
          stack.push(c);
        } else {
          if(c == stack.peek()) {
            stack.pop();
          } else {
            stack.push(c);
          }
        }
      }
      if(stack.isEmpty()) {
        answer++;
      }
    }
    System.out.println(answer);
  }
}
