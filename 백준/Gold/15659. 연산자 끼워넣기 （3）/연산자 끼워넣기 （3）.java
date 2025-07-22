import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
  static int n;
  static int[] nums;
//  static int[] operators;
  static int[] countOperators;
  static int min;
  static int max;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    // 덧셈 배치, 뺄셈 배치, 곱셈 배치, 나눗셈 배치
    // 11000 / 10100 / 10010 / 10001
    // 01100 / 01010 / 01001
    // 00110 / 00101 / 00011
    // 5*4/2
    // 3
    // 2
    // 덧셈 1 뺄셈 2 곱셈 3 나눗셈 4
    n = Integer.parseInt(br.readLine());
    StringTokenizer st = new StringTokenizer(br.readLine());
    nums = new int[n];
    for (int i = 0; i < n; i++) {
      nums[i] = Integer.parseInt(st.nextToken());
    }
//    operators = new int[n-1];
    countOperators = new int[4];
    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < 4; i++) {
      countOperators[i] = Integer.parseInt(st.nextToken());
    }
    min = Integer.MAX_VALUE;
    max = Integer.MIN_VALUE;
    calculate(1, 0, new int[n-1]);
//    for (int i = 0; i < 4; i++) {
//      System.out.print(countOperators[i] + " ");
//    }
    System.out.println(max);
    System.out.println(min);
  }
  static void calculate(int operator, int count, int[] operators) { // 현재 넣고 있는 연산자, 이미 넣은 연산자 수
    if (operator == 4 && countOperators[operator-1] <= count) {
//      for(int i = 0; i < operators.length; i++) {
//        System.out.print("연산자: " + operators[i] + " ");
//      }
//      System.out.println();
      List<Integer> op = new ArrayList<>();
      List<Integer> ns = new ArrayList<>();
      ns.add(nums[0]);
      for(int i = 1; i < nums.length; i++) {
        if(operators[i-1]==3) {
          ns.add(ns.remove(ns.size()-1)*nums[i]);
        } else if(operators[i-1]==4) {
          ns.add(ns.remove(ns.size()-1)/nums[i]);
        } else {
          ns.add(nums[i]);
          op.add(operators[i-1]);
        }
      }
//      System.out.println(ns.get(0));
      int res = ns.get(0);
      for(int i = 0; i < op.size(); i++) {
        if(op.get(i)==1) {
          res += ns.get(i+1);
        } else {
          res -= ns.get(i+1);
        }
      }
      min = Math.min(min, res);
      max = Math.max(max, res);
      return;
    } else if(operator < 4 && countOperators[operator-1] <= count) {
      calculate(operator+1, 0, operators);
      return;
    }
//    System.out.println("00000");
    for(int i = 0; i < operators.length; i++) {
      if(operators[i] == 0) {
        operators[i] = operator;
        calculate(operator, count+1, operators);
        operators[i] = 0;
      }
    }

  }
}
