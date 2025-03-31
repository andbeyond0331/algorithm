import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
  static List<Integer>[] trees;
  static int[] parents;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    StringTokenizer st;
    trees = new ArrayList[N + 1];
    for(int i = 1; i < N; i++) {
      st = new StringTokenizer(br.readLine());
      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());
      if(trees[a] == null) {
        trees[a] = new ArrayList<>();
      }
      trees[a].add(b);
      if(trees[b] == null) {
        trees[b] = new ArrayList<>();
      }
      trees[b].add(a);
    }
    parents = new int[N + 1];
    find(1);
    for(int i = 2; i <=N; i++) {
      System.out.println(parents[i]);
    }
  }
  static void find(int node) {
    List<Integer> list = trees[node];
    if(list != null) {
      for(int i = 0;i < list.size(); i++) {
        if(parents[list.get(i)] == 0) {
          parents[list.get(i)] = node;
          find(list.get(i));
        }
      }
    }
  }
}
