import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
  static int n;
  static int[][] table;
  
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    n = Integer.parseInt(br.readLine().trim());
    StringTokenizer st;
    int test = 1;
    
    while(n != 0) {
      table = new int[n][n];
      for(int i = 0; i < n; i++) {
        st = new StringTokenizer(br.readLine());
        for(int j = 0; j < n; j++) {
          table[i][j] = Integer.parseInt(st.nextToken());
        }
      }
      
      int max = Integer.MIN_VALUE;
      
      // 1. I 블록 (막대) - 2방향
      for(int i = 0; i < n; i++) {
        for(int j = 0; j <= n - 4; j++) {
          max = Math.max(max, barH(i, j));  // 가로
        }
      }
      for(int i = 0; i <= n - 4; i++) {
        for(int j = 0; j < n; j++) {
          max = Math.max(max, barV(i, j));  // 세로
        }
      }
      
      // 2. Z 블록 - 2방향
      for(int i = 0; i <= n - 2; i++) {
        for(int j = 0; j <= n - 3; j++) {
          max = Math.max(max, z1(i, j));  // 가로 Z
        }
      }
      for(int i = 0; i <= n - 3; i++) {
        for(int j = 0; j <= n - 2; j++) {
          max = Math.max(max, z2(i, j));  // 세로 Z
        }
      }
      
      // 3. L 블록 - 4방향
      for(int i = 0; i <= n - 2; i++) {
        for(int j = 0; j <= n - 3; j++) {
          max = Math.max(max, L1(i, j));
        }
      }
      for(int i = 0; i <= n - 3; i++) {
        for(int j = 0; j <= n - 2; j++) {
          max = Math.max(max, L2(i, j));
        }
      }
      for(int i = 0; i <= n - 2; i++) {
        for(int j = 0; j <= n - 3; j++) {
          max = Math.max(max, L3(i, j));
        }
      }
      for(int i = 0; i <= n - 3; i++) {
        for(int j = 0; j <= n - 2; j++) {
          max = Math.max(max, L4(i, j));
        }
      }
      
      // 4. T 블록 (ㅗ) - 4방향
      for(int i = 0; i <= n - 2; i++) {
        for(int j = 0; j <= n - 3; j++) {
          max = Math.max(max, T1(i, j));  // ㅗ
        }
      }
      for(int i = 0; i <= n - 3; i++) {
        for(int j = 0; j <= n - 2; j++) {
          max = Math.max(max, T2(i, j));  // ㅏ
        }
      }
      for(int i = 0; i <= n - 2; i++) {
        for(int j = 0; j <= n - 3; j++) {
          max = Math.max(max, T3(i, j));  // ㅜ
        }
      }
      for(int i = 0; i <= n - 3; i++) {
        for(int j = 0; j <= n - 2; j++) {
          max = Math.max(max, T4(i, j));  // ㅓ
        }
      }
      
      // 5. O 블록 (정사각형) - 1방향
      for(int i = 0; i <= n - 2; i++) {
        for(int j = 0; j <= n - 2; j++) {
          max = Math.max(max, square(i, j));
        }
      }
      
      System.out.println(test++ + ". " + max);
      n = Integer.parseInt(br.readLine().trim());
    }
  }
  
  // I 블록 - 가로
  static int barH(int i, int j) {
    return table[i][j] + table[i][j+1] + table[i][j+2] + table[i][j+3];
  }
  
  // I 블록 - 세로
  static int barV(int i, int j) {
    return table[i][j] + table[i+1][j] + table[i+2][j] + table[i+3][j];
  }
  
  // Z 블록 - 가로
  // ##
  //  ##
  static int z1(int i, int j) {
    return table[i][j] + table[i][j+1] + table[i+1][j+1] + table[i+1][j+2];
  }
  
  // Z 블록 - 세로
  //  #
  // ##
  // #
  static int z2(int i, int j) {
    return table[i][j+1] + table[i+1][j+1] + table[i+1][j] + table[i+2][j];
  }
  
  // L 블록 1 (0도)
  // #
  // #
  // ##
  static int L1(int i, int j) {
    return table[i][j] + table[i+1][j] + table[i+1][j+1] + table[i+1][j+2];
  }
  
  // L 블록 2 (90도)
  // ##
  // #
  // #
  static int L2(int i, int j) {
    return table[i][j] + table[i][j+1] + table[i+1][j] + table[i+2][j];
  }
  
  // L 블록 3 (180도)
  // ##
  //  #
  //  #
  static int L3(int i, int j) {
    return table[i][j] + table[i][j+1] + table[i][j+2] + table[i+1][j+2];
  }
  
  // L 블록 4 (270도)
  //  #
  //  #
  // ##
  static int L4(int i, int j) {
    return table[i][j+1] + table[i+1][j+1] + table[i+2][j+1] + table[i+2][j];
  }
  
  // T 블록 1 (ㅗ)
  // ###
  //  #
  static int T1(int i, int j) {
    return table[i][j] + table[i][j+1] + table[i][j+2] + table[i+1][j+1];
  }
  
  // T 블록 2 (ㅏ)
  // #
  // ##
  // #
  static int T2(int i, int j) {
    return table[i][j] + table[i+1][j] + table[i+1][j+1] + table[i+2][j];
  }
  
  // T 블록 3 (ㅜ)
  //  #
  // ###
  static int T3(int i, int j) {
    return table[i][j+1] + table[i+1][j] + table[i+1][j+1] + table[i+1][j+2];
  }
  
  // T 블록 4 (ㅓ)
  //  #
  // ##
  //  #
  static int T4(int i, int j) {
    return table[i][j+1] + table[i+1][j] + table[i+1][j+1] + table[i+2][j+1];
  }
  
  // O 블록 (정사각형)
  // ##
  // ##
  static int square(int i, int j) {
    return table[i][j] + table[i][j+1] + table[i+1][j] + table[i+1][j+1];
  }
}

/*
테트리스 5가지 블록 정리:

1. I (막대) - 2가지
   ####  or  #
             #
             #
             #

2. Z - 2가지
   ##     #
    ##   ##
          #

3. L - 4가지
   #     ##    ##     #
   #     #      #     #
   ##    #      #    ##

4. T (ㅗ) - 4가지
   ###    #     #    #
    #    ##   ###   ##
         #           #

5. O (정사각형) - 1가지
   ##
   ##

총 13가지 (2+2+4+4+1)
*/