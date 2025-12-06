import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String s = br.readLine();
    int[] count = new int[10];
    for(int i = 0;i < s.length();i++){
      int val = s.charAt(i) - '0';
      count[val]++;
    }
    int sets = (count[6]+count[9])%2==0?(count[6]+count[9])/2:(count[6]+count[9])/2+1;
//    System.out.println(sets);
    if(sets==0) {
      sets = Math.max(count[6], count[9]);
    }
    for(int i = 0; i < count.length; i++){
      if(i==6||i==9) {
        continue;
      }
      sets = Math.max(sets, count[i]);
    }
    System.out.println(sets);
  }
}
