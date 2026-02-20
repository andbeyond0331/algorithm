import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    Map<String, Integer> books = new HashMap<>();
    int max = -1;
    for (int i = 0; i < n; i++) {
      String line = br.readLine();
      if(books.containsKey(line)) {
        books.put(line, books.get(line) + 1);
      } else {
        books.put(line, 1);
      }
    }
    for (String key : books.keySet()) {
      max = Math.max(max, books.get(key));
    }
    List<String> list = new ArrayList<>();
    for (String key : books.keySet()) {
      if(books.get(key)==max) {
        list.add(key);
      }
    }
    list.sort(String::compareTo);
    System.out.println(list.get(0));
  }
}
