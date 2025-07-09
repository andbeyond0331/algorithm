import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

class Points implements Comparable<Points> {
  int country;
  int student;
  int point;
  @Override
  public int compareTo(Points o) {
    return this.point - o.point;
  }
  public Points(int country, int student, int point) {
    this.country = country;
    this.student = student;
    this.point = point;
  }
}
public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    List<Points> points = new ArrayList<>();
    StringTokenizer st;
    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine());
      points.add(new Points(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
    }
    points.sort(Comparable::compareTo);
    System.out.println(points.get(points.size()-1).country + " " + points.get(points.size()-1).student);
    int gold = points.get(points.size()-1).country;
    System.out.println(points.get(points.size()-2).country + " " + points.get(points.size()-2).student);
    int silver = points.get(points.size()-2).country;
    if(gold==silver) {
      for(int i = points.size()-2; i >= 0; i--) {
        if(points.get(i).country != gold) {
          System.out.println(points.get(i).country + " " + points.get(i).student);
          break;
        }
      }
    } else {
      System.out.println(points.get(points.size()-3).country + " " + points.get(points.size()-3).student);
    }
//    StringTokenizer st;
//    for(int i = 0; i < N; i++) {
//      st = new StringTokenizer(br.readLine());
//      int countryNum = Integer.parseInt(st.nextToken());
//      int studentNum = Integer.parseInt(st.nextToken());
//      int point = Integer.parseInt(st.nextToken());
//      if(map.containsKey(countryNum)) {
//        if(map.get(countryNum)[1]<point) {
//          map.get(countryNum)[1] = point;
//          map.get(countryNum)[0] = studentNum;
//        }
//      } else {
//        map.put(countryNum, new int[]{point, studentNum});
//      }
//    }
//    int[] max = new int[3];
//    for(int i : map.keySet()) {
//      int[] arr = map.get(i);
//      if(arr[1]>max[2]) {
//        max[0] = i;
//        max[1] = arr[0];
//        max[2] = arr[1];
//      }
//    }
//    map.remove(max[0]);
//    System.out.println(max[0] + " " + max[1]);
//    max = new int[]{0, 0, 0};
//    for(int i : map.keySet()) {
//      int[] arr = map.get(i);
//      if(arr[1]>max[2]) {
//        max[0] = i;
//        max[1] = arr[0];
//        max[2] = arr[1];
//      }
//    }
//    map.remove(max[0]);
//    System.out.println(max[0] + " " + max[1]);
//    max = new int[]{0, 0, 0};
//    for(int i : map.keySet()) {
//      int[] arr = map.get(i);
//      if(arr[1]>max[2]) {
//        max[0] = i;
//        max[1] = arr[0];
//        max[2] = arr[1];
//      }
//    }
//    System.out.println(max[0] + " " + max[1]);
//  }
  }
}
