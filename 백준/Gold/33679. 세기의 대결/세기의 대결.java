import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static List<Integer> yj, hg;
    static int maxYJ, maxHG;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        
        yj = new ArrayList<>();
        hg = new ArrayList<>();
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            yj.add(Integer.parseInt(st.nextToken()));
        }
        
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            hg.add(Integer.parseInt(st.nextToken()));
        }
        
        // 모든 시작 위치를 시도
        for (int i = 0; i < n; i++) {
            // LIS 길이 구하기
            int yjLIS = findLISLength(yj);
            int hgLIS = findLISLength(hg);
            
            maxYJ = Math.max(maxYJ, yjLIS);
            maxHG = Math.max(maxHG, hgLIS);
            
            // 배열을 한 칸 회전 (첫 번째 원소를 맨 뒤로)
            yj.add(yj.remove(0));
            hg.add(hg.remove(0));
        }
        
        // 결과 출력
        if (maxYJ > maxHG) {
            System.out.println("YJ Win!");
        } else if (maxYJ < maxHG) {
            System.out.println("HG Win!");
        } else {
            System.out.println("Both Win!");
        }
    }
    
    /**
     * LIS (Longest Increasing Subsequence) 길이를 구하는 함수
     * 이진 탐색을 이용한 O(N log N) 알고리즘
     */
    static int findLISLength(List<Integer> arr) {
        List<Integer> dp = new ArrayList<>();
        
        for (int num : arr) {
            // lower_bound: num 이상인 첫 번째 위치 찾기
            int pos = lowerBound(dp, num);
            
            if (pos == dp.size()) {
                // num이 dp의 모든 원소보다 크면 추가
                dp.add(num);
            } else {
                // 해당 위치의 값을 num으로 교체
                dp.set(pos, num);
            }
        }
        
        return dp.size();
    }
    
    /**
     * lower_bound 구현: target 이상인 첫 번째 위치 반환
     */
    static int lowerBound(List<Integer> list, int target) {
        int left = 0;
        int right = list.size();
        
        while (left < right) {
            int mid = (left + right) / 2;
            if (list.get(mid) < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        
        return left;
    }
}
