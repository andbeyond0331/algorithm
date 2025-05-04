import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
  static int k;
  static int x, y;
  static int[][] showerRoom;
  static int length;
  static int amount;
  static boolean flag;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    k = Integer.parseInt(br.readLine());
    StringTokenizer st = new StringTokenizer(br.readLine());
    x = Integer.parseInt(st.nextToken())-1;
    y = Integer.parseInt(st.nextToken())-1;
    length = (int) Math.pow(2, k);
    amount = length * length;
    showerRoom = new int[length][length];
    showerRoom[y][x] = -1;
    flag = false;
    int[][] arr = new int[length][length];
    arr[y][x] = -1;
    tile(0, 1, arr);
    if(flag) {
      for(int i = 0; i < length; i++) {
        for(int j = 0; j < length; j++) {
          System.out.print(showerRoom[i][j] + " ");
        }
        System.out.println();
      }
    } else {
      System.out.println(-1);
    }
  }
  static void tile(int cnt, int num, int[][] room) {
    if(cnt == amount-1) {
      flag = true;
      for(int i = 0; i < length; i++) {
        for(int j = 0; j < length; j++) {
          showerRoom[i][j] = room[length-1-i][j];
        }
      }

      return;
    }
    if(flag) {
      return;
    }
    for(int i = 0; i < length; i++) {
      for(int j = 0; j < length; j++) {
        if(room[i][j] == 0) {
          if(i>0 && j>0 && room[i-1][j]==0 && room[i][j-1]==0) {
            room[i][j] = num;
            room[i-1][j] = num;
            room[i][j-1] = num;
            tile(cnt+3, num+1, room);
            room[i][j] = 0;
            room[i-1][j] = 0;
            room[i][j-1] = 0;
          } else if(i>0 && j<length-1 && room[i-1][j]==0 && room[i][j+1]==0) {
            room[i][j] = num;
            room[i-1][j] = num;
            room[i][j+1] = num;
            tile(cnt+3, num+1, room);
            room[i][j] = 0;
            room[i-1][j] = 0;
            room[i][j+1] = 0;
          } else if(i<length-1 && j>0 && room[i+1][j] == 0 && room[i][j-1]==0) {
            room[i][j] = num;
            room[i+1][j] = num;
            room[i][j-1] = num;
            tile(cnt+3, num+1, room);
            room[i][j] = 0;
            room[i+1][j] = 0;
            room[i][j-1] = 0;
          } else if(i<length-1 && j<length-1 && room[i+1][j] == 0 && room[i][j+1]==0) {
            room[i][j] = num;
            room[i+1][j] = num;
            room[i][j+1] = num;
            tile(cnt+3, num+1, room);
            room[i][j] = 0;
            room[i+1][j] = 0;
            room[i][j+1] = 0;
          }
        }
      }
    }
  }
}
