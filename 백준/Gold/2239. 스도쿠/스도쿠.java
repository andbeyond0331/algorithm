import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
  static int[][] sudoku;
  static boolean[][] visited;
  static List<int[]> location;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    sudoku = new int[9][9];
    visited = new boolean[9][9];
    location = new ArrayList<>();
    for(int i = 0; i < 9; i++) {
      String line = br.readLine();
      for(int j = 0; j < 9; j++) {
        sudoku[i][j] = line.charAt(j) - '0';
        if(sudoku[i][j] == 0) {
          location.add(new int[]{i, j});
        }
      }
    }

    go(0);

    for(int i = 0; i < 9; i++) {
      for(int j = 0; j < 9; j++) {
        System.out.print(sudoku[i][j]);
      }
      System.out.println();
    }


  }
  static boolean go(int cnt) {
    if(cnt == location.size()) {
      return true;
    }
    int y = location.get(cnt)[0];
    int x = location.get(cnt)[1];
    for(int i = 1; i < 10; i++) {
      sudoku[y][x] = i;
      if(isValid(y, x) && go(cnt+1)) return true;
    }
    sudoku[y][x] = 0;
    return false;
  }

  static boolean isValid(int i, int j) {
    for(int k = 0; k < 9; k++) {
      if(i!=k && sudoku[k][j] == sudoku[i][j]) return false;
      if(j!=k && sudoku[i][k] == sudoku[i][j]) return false;

    }
    for(int ni=(i/3)*3, k=0; k<3; k++, ni++) {
      for(int nj=(j/3)*3, l=0; l<3; l++, nj++) {
        if(ni!=i && nj!=j && sudoku[ni][nj] == sudoku[i][j]) return false;
      }
    }
    return true;
  }

}
