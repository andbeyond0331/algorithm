import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String a = br.readLine();
    String b = br.readLine();
    if(a.equals("null")) {
      System.out.println("NullPointerException");
      System.out.println("NullPointerException");
      return;
    } else if(b.equals("null")) {
      System.out.println("false");
      System.out.println("false");
      return;
    }
    if(a.equals(b)) {
      System.out.println("true");
    } else {
      System.out.println("false");
    }
    if(a.equalsIgnoreCase(b)) {
      System.out.println("true");
    } else {
      System.out.println("false");
    }

  }
}
