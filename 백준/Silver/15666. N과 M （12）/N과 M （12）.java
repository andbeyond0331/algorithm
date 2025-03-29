import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.*;

public class Main {
  static int N, M;
  static int[] arr, selected;
  static StringBuilder sb = new StringBuilder();

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
    arr = new int[N];
    selected = new int[M];

    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < N; i++) {
      arr[i] = Integer.parseInt(st.nextToken());
    }

    // 중복 제거 + 정렬
    Set<Integer> set = new TreeSet<>();
    for (int num : arr) {
      set.add(num);
    }

    arr = new int[set.size()];
    int idx = 0;
    for (int num : set) {
      arr[idx++] = num;
    }

    backtrack(0, 0);
    System.out.println(sb);
  }

  static void backtrack(int depth, int start) {
    if (depth == M) {
      for (int i = 0; i < M; i++) {
        sb.append(selected[i]).append(" ");
      }
      sb.append("\n");
      return;
    }

    for (int i = start; i < arr.length; i++) {
      selected[depth] = arr[i];
      backtrack(depth + 1, i); // 같은 수 선택 가능
    }
  }
}
