import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String s = br.readLine();
    StringBuilder sb = new StringBuilder();
    Stack<Character> stack = new Stack<>();
    for (int i = 0; i < s.length(); i++) {
      char c = s.charAt(i);
      if(c==' ') {
        if(!stack.isEmpty()){
          while(!stack.isEmpty()){
            sb.append(stack.pop());
          }
        }
        sb.append(' ');
      } else if(c=='<') {
        if(!stack.isEmpty()){
          while(!stack.isEmpty()){
            sb.append(stack.pop());
          }
        }
        for(int j = i; j < s.length(); j++) {
          if(s.charAt(j)=='>') {
            sb.append(s.charAt(j));
            i = j;
            break;
          }
          sb.append(s.charAt(j));
        }
      } else {
        stack.push(c);
      }
    }
    if(!stack.isEmpty()){
      while(!stack.isEmpty()){
        sb.append(stack.pop());
      }
    }
    System.out.println(sb.toString());
//    for (int i = 0; i < s.length(); i++) {
//      if(s.charAt(i)=='<') {
//        for(int j = i; j < s.length(); j++){
//          if(s.charAt(j)=='>') {
//            sb.append(s.charAt(j));
//            break;
//          } else {
//            sb.append(s.charAt(j));
//          }
//        }
//      } else if(s.charAt(i)==' ') {
//        String temp = "";
//        for(int j = i+1; j < s.length(); j++){
//          if(s.charAt(j)==' ') {
//            break;
//          } else {
//            temp += s.charAt(j);
//          }
//        }
//        sb.append(" ");
//        for(int j = temp.length()-1; j >=0; j--) {
//          sb.append(temp.charAt(j));
//        }
//        sb.append(" ");
//      }
//    }
  }
}
