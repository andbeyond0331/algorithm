import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    String s = "";
    for(int i=n;i >0; i--) {
      for(int j = 0; j < n-i; j++) {
        s+=" ";
      }
      if(i==n) {
        for(int j = 0;j < i; j++) {
          s+="*";
        }
      } else {
        s+="*";
        for(int j = 0; j < n-2; j++) {
          s+=" ";
        }
        s+="*";
      }

      for(int j = 0;j < (i-1)+(i-2); j++) {
        s+=" ";
      }
      if(i==n) {
        for(int j = 0;j < i; j++) {
          s+="*";
        }
      } else {
        if(i!=1) {

          s+="*";
        }
        for(int j = 0; j < n-2; j++) {
          s+=" ";
        }
        s+="*";
      }
      s+="\n";
    }
    for(int i = 2; i <= n; i++) {
      for(int j = 0; j< n-i; j++) {
        s+=" ";
      }
      if(i==n) {
        for(int j = 0;j < i; j++) {
          s+="*";
        }
      } else {
        s+="*";
        for(int j = 0; j < n-2; j++) {
          s+=" ";
        }
        s+="*";
      }
      for(int j = 0;j < (i-1)+(i-2); j++) {
        s+=" ";
      }
      if(i==n) {
        for(int j = 0;j < i; j++) {
          s+="*";
        }
      } else {
        s+="*";
        for(int j = 0; j < n-2; j++) {
          s+=" ";
        }
        s+="*";
      }
      s+="\n";
    }
    System.out.println(s);
  }
}
