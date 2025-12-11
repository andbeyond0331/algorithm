import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

class Assignment {
  int time;
  int score;
  Assignment(int time, int score) {
    this.time = time;
    this.score = score;
  }

  public void setScore(int score) {
    this.score = score;
  }

  public void setTime(int time) {
    this.time = time;
  }
}
public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    Stack<Assignment> stack = new Stack<>();
    StringTokenizer st;
    int answer = 0;
    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine());
      int t = Integer.parseInt(st.nextToken());
      if(t==1) {
        int score = Integer.parseInt(st.nextToken());
        int time = Integer.parseInt(st.nextToken());
        Assignment assignment = new Assignment(time-1, score);
        stack.push(assignment);
      } else {
        if(!stack.isEmpty()) {
          Assignment assignment = stack.pop();
          assignment.setTime(assignment.time-1);
          stack.push(assignment);
        }
      }
      if(!stack.isEmpty()) {
        Assignment assignment = stack.pop();
        if(assignment.time==0) {
          answer+=assignment.score;
        } else {
          stack.push(assignment);
        }
      }
    }
    System.out.println(answer);
  }

}
