import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String input = br.readLine();
    int[] numbers = new int[input.length()];
    int idx = -1;
    for (int i = 0; i < input.length(); i++) {
      if(input.charAt(i)=='*') {
        idx = i;
        numbers[i] = -1;
      } else {
        numbers[i] = Integer.parseInt(input.charAt(i)+"");
      }
    }
    for(int i = 0; i < 10; i++) {
      numbers[idx] = i;
      int sum = 0;
      for(int j = 0; j < numbers.length; j++) {
        if(j%2==0) {
          sum+=numbers[j];
        } else {
          sum+=numbers[j]*3;
        }
      }
      if(sum%10==0) {
        System.out.println(i);
        return;
      }
    }
  }
}
