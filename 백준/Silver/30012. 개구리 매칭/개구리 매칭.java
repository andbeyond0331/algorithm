import java.util.*;
import java.io.*;

public class Main {
   public static void main(String[] args) throws IOException{
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       StringTokenizer st = new StringTokenizer(br.readLine(), " ");
       
       // s: 주호 개구리 위치, n: 개구리 수
       int s = Integer.parseInt(st.nextToken());
       int n = Integer.parseInt(st.nextToken());

       // arr: 개구리 위치
       int[] arr = new int[n];
       st = new StringTokenizer(br.readLine(), " ");
       for(int i=0; i<n; i++){
           arr[i] = Integer.parseInt(st.nextToken());
       }

       // k: 개구리 최대 점프 거리, l: 1걸을 때마다 소모되는 체력
       st = new StringTokenizer(br.readLine(), " ");
       int k = Integer.parseInt(st.nextToken());
       int l = Integer.parseInt(st.nextToken());

       // dp: i번째 개구리까지의 체력 소모량
       int[] dp = new int[n+1];

       // 각 개구리 위치 계산 
       for(int i=0; i<n; i++){
           int distance = Math.abs(arr[i] - s);
           int cost = 0;

           // 점프로 닿지 않는 거리일 때
           if(distance > 2*k){
               cost += (distance-2*k)*l;
           }
           // 점프로 닿는 거리일 때            
           else if(distance <= 2*k){
               if (distance % 2 == 0) {
                   cost += (k-distance/2)*2;
               } 
               else if (distance % 2 == 1) {
                   cost += (k-distance/2)*2 - 1;
               }
           }
           dp[i] = cost;
       }

       // 최소 체력 소모량과 인덱스 찾기       
       int min = Integer.MAX_VALUE;
       int idx = 0;
       for(int i=0; i<n; i++){
           if(min > dp[i]){
               min = dp[i];
               idx = i+1;
           }
       }

       // 출력: 서로의 체력 소모 합의 최소, 그 개구리 번호
       System.out.println(min+" "+idx);
   }
}