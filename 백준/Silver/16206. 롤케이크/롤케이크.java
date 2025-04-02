import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    // 10의 배수 모아
    List<Integer> ten = new ArrayList<>();
    List<Integer> last = new ArrayList<>();
    st = new StringTokenizer(br.readLine());
    int N = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(st.nextToken());
    st = new StringTokenizer(br.readLine());
    for(int i = 0; i < N; i++) {
      int a = Integer.parseInt(st.nextToken());
      if(a%10==0) {
        ten.add(a);
      } else {
        last.add(a);
      }
    }
    int count = 0;
    ten.sort(Integer::compareTo);
    while(!ten.isEmpty() && M>0) {
      if(ten.get(0)/10-1<=M) {
        count+=ten.get(0)/10;
        M-=ten.get(0)/10-1;
        ten.remove(0);
      } else {
        count+=M;
        M = 0;
      }
    }
    if(M==0) {
      System.out.println(count);
    }else {
      while(!last.isEmpty() && M>0) {
        if(last.get(0)/10<=M) {
          count+=last.get(0)/10;
          M-=last.get(0)/10;
          last.remove(0);
        }else {
          count+=M;
          M = 0;
        }
      }
      System.out.println(count);
    }

  }
}
