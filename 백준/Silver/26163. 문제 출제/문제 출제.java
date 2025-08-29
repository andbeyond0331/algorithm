import java.util.*;

public class Main {
    static int[] b = new int[6]; // 출제비 (1~5)
    static int maxFee = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        for (int i = 1; i <= 5; i++) {
            b[i] = sc.nextInt();
        }

        dfs(1, new int[6], 0, 0, 0);

        System.out.println(maxFee);
    }

    // dfs(idx, counts, 총문제수, 난이도합, 출제비합)
    static void dfs(int idx, int[] a, int totalCnt, int diffSum, int feeSum) {
        // 종료 조건: idx > 5
        if (idx > 5) {
            if (totalCnt == 0) return; // 문제 0개면 제외

            // 조건 검사
            if (totalCnt <= 3 && diffSum <= 10) {
                maxFee = Math.max(maxFee, feeSum);
            } else if (totalCnt >= 4 && diffSum <= 15) {
                maxFee = Math.max(maxFee, feeSum);
            }
            return;
        }

        // 해당 난이도 문제를 0개~최대 몇 개 출제할 수 있을지 반복
        // 제한 조건: diffSum + idx * 개수 ≤ 15 (어차피 조건 범위 벗어나면 의미 없음)
        for (int cnt = 0; diffSum + idx * cnt <= 15; cnt++) {
            dfs(idx + 1, a, totalCnt + cnt, diffSum + idx * cnt, feeSum + b[idx] * cnt);
        }
    }
}
