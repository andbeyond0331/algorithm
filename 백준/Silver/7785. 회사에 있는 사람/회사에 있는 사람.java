import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    Set<String> set = new HashSet<>();
    StringTokenizer st;
    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine());
      String name = st.nextToken();
      String el = st.nextToken();
      if(el.equals("enter")) {
        set.add(name);
      } else {
        set.remove(name);
      }
    }
    List<String> list = new ArrayList<>(set);
    list.sort(String::compareTo);
    for(int i = list.size() - 1; i >= 0; i--) {
      System.out.println(list.get(i));
    }
  }
}
