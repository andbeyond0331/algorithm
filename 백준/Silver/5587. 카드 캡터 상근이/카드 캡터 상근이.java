import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[][] card = new int[2][2 * n + 1];

        for (int i = 0; i < n; i++) { // 상근이 카드
            int num = Integer.parseInt(br.readLine());
            card[0][num] = num;
        }

        for (int i = 1; i <= 2*n; i++) { // 근상이 카드
            if (card[0][i] == 0) {
                card[1][i] = i;
            }
        }

        int sangCardAmount = n; // 상근이 보유 카드 수
        int geunCardAmount = n; // 근상이 보유 카드 수
        int i = 1;
        boolean sequence = true; // 상근 차례: true, 근상 차례: false
        while (true) {
            if (sangCardAmount == 0 || geunCardAmount == 0) {
                break;
            }

            if (sequence) { // 상근 차례
                if (card[0][i] != 0) {
                    card[0][i] = 0;
                    sangCardAmount--;
                    sequence = false;
                }
                i++;
            } else { // 근상 차례
                if (card[1][i] != 0) {
                    card[1][i] = 0;
                    geunCardAmount--;
                    sequence = true;
                }
                i++;
            }

            if (i == 2 * n + 1) {
                i = 1;
                sequence = !sequence;
            }
        }

        System.out.println(geunCardAmount);
        System.out.println(sangCardAmount);
    }
}