import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = 0;
        Stack<Character> stack;
        for(int idx = 0; idx < s.length(); idx++) {
            stack = new Stack();
            for(int i = 0;i < s.length(); i++) {
                char c = s.charAt(i);
                if(c=='(' || c=='[' || c=='{') {
                    stack.add(c);
                    
                } else if(c==')') {
                    if(stack.isEmpty()) {
                        stack.add(c);
                        break;
                    } else if(stack.peek() == '(') {
                        stack.pop();
                    }
                } else if(c==']') {
                    if(stack.isEmpty()) {
                        stack.add(c);
                        break;
                    }else if(stack.peek() == '[') {
                        stack.pop();
                    }
                } else if(c=='}') {
                    if(stack.isEmpty()) {
                        stack.add(c);
                        break;
                    }else if(stack.peek() == '{') {
                        stack.pop();
                    }
                }
            }
            if(stack.isEmpty()) {
                answer++;
            }
            s = s.substring(1) + s.substring(0, 1);
        }
        return answer;
    }
}