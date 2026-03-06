import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String first = br.readLine();
    String second = br.readLine();
    String third = br.readLine();
    if(first.equals("Fizz") || first.equals("Buzz") || first.equals("FizzBuzz")) {
      if(second.equals("Fizz") || second.equals("Buzz") || second.equals("FizzBuzz")) {
        if(third.equals("Fizz") || third.equals("Buzz") || third.equals("FizzBuzz")) {
          System.out.println("Don't know");
        } else {
          int answer = Integer.parseInt(third)+1;
          if(answer % 3 == 0 && answer % 5 == 0) {
            System.out.println("FizzBuzz");
          } else if(answer % 3 == 0) {
            System.out.println("Fizz");
          } else if(answer % 5 == 0) {
            System.out.println("Buzz");
          } else {
            System.out.println(answer);
          }
        }
      } else {
        int answer = Integer.parseInt(second)+2;
        if(answer % 3 == 0 && answer % 5 == 0) {
          System.out.println("FizzBuzz");
        } else if(answer % 3 == 0) {
          System.out.println("Fizz");
        } else if(answer % 5 == 0) {
          System.out.println("Buzz");
        } else {
          System.out.println(answer);
        }
      }
    } else {
      int answer = Integer.parseInt(first)+3;
      if(answer % 3 == 0 && answer % 5 == 0) {
        System.out.println("FizzBuzz");
      } else if(answer % 3 == 0) {
        System.out.println("Fizz");
      } else if(answer % 5 == 0) {
        System.out.println("Buzz");
      } else {
        System.out.println(answer);
      }
    }
  }
}
