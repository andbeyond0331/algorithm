import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for(int i = 0; i < T; i++){
            int N = sc.nextInt();
            int K = sc.nextInt();
            int result = 0;

            int[] arr = new int[N];
            ArrayList<Integer> list = new ArrayList<>(); // 구매한 주식 리스트

            for(int j = 0; j < N; j++) {
                arr[j] = sc.nextInt();
            }

            list.add(arr[0]);
            for(int j = 1; j < N; j++) {
                if (list.get(list.size()-1) < arr[j]){
                    list.add(arr[j]); // 이전 주식 보다 올랐으므로 구매함
                }
                else {
                    int left = 0;
                    int right = list.size() - 1; //리스트는 0부터 시작하므로 -1
                    while ( left <= right){
                        int mid = (left + right) / 2;
                        if (list.get(mid) < arr[j])
                            left = mid + 1;
                        else
                            right = mid - 1;
                    }
                    list.set(left, arr[j]);
                }
            }
            if (list.size() >= K)
                result = 1;
            System.out.println("Case #"+(i+1));
            System.out.println(result);
        }
    }
}
