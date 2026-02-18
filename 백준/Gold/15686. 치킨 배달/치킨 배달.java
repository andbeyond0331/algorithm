import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
  static int[][] map;
  static int answer;
  static int[][] houses;
  static int[][] chickens;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(st.nextToken());
    int m = Integer.parseInt(st.nextToken()); // 가장 수익을 많이 낼 수 있는 치킨집 수
    // 1 집 2 치킨집
    // 치킨 거리가 가장 작아야 함(치킨 거리는 집과 가장 가까운 치킨집 사이 거리)
    // 탐색하면서 이전보다 치킨거리가 더 크면 즉시 중단?
    map = new int[n][n];
    answer = Integer.MAX_VALUE;
    List<int[]> list = new ArrayList<>();
    List<int[]> chickenList = new ArrayList<>();
    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < n; j++) {
        map[i][j] = Integer.parseInt(st.nextToken());
        if(map[i][j] == 1) {
          list.add(new int[]{i, j});
        } else if(map[i][j] == 2) {
          chickenList.add(new int[]{i, j});
        }
      }
    }
    houses = new int[list.size()][2];
    for(int i = 0; i < houses.length; i++) {
      houses[i][0] = list.get(i)[0];
      houses[i][1] = list.get(i)[1];
    }
    chickens = new int[chickenList.size()][2];
    for(int i = 0; i < chickenList.size(); i++) {
      chickens[i][0] = chickenList.get(i)[0];
      chickens[i][1] = chickenList.get(i)[1];
    }
    // 일단 모든 경우의 수 고려.
    // 1군데 남기기, 2군데 남기기, 3군데 남기기, ... , m군데 남기기
    // m군데 남겼을 때 치킨거리 구하기
    for (int i = 1; i <= m; i++) {
      search(0, i, 0, new boolean[chickens.length], new int[i][2]);
    }
    System.out.println(answer);
  }
  static void chicken(int[][] stores) {
    int count = 0;
    for (int i = 0; i < houses.length; i++) {
      int min = Integer.MAX_VALUE;
      for (int j = 0; j < stores.length; j++) {
        min = Math.min(min, Math.abs(houses[i][0] - stores[j][0])+Math.abs(houses[i][1] - stores[j][1]));
      }
      count += min;
      if(count>answer) {
        return;
      }
    }
    answer = Math.min(count, answer);
  }
  static void search(int count, int remain, int depth, boolean[] visited, int[][] stores) {
    if(count == remain) {
      chicken(stores);
      return;
    }
    for(int i = depth; i < chickens.length; i++) {
      if(!visited[i]) {
        visited[i] = true;
        stores[count][0] = chickens[i][0];
        stores[count][1] = chickens[i][1];
        search(count+1, remain, i, visited, stores);
        visited[i] = false;
      }
    }
  }
}
