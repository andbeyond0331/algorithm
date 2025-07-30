import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        int N = Integer.parseInt(input.substring(0, input.indexOf(' ')));
        int K = Integer.parseInt(input.substring(input.indexOf(' ') + 1));

        int[] name_len = new int[N];
        int[] name_len_count = new int[21];

        for (int i = 0; i < N; i++) {
            name_len[i] = br.readLine().length();
            if (i <= K) {
                name_len_count[name_len[i]]++;
            }
        }
        long pair = --name_len_count[name_len[0]];

        for (int i = 1; i < N; i++) {
            if (i + K < N) name_len_count[name_len[i + K]]++;
            pair += --name_len_count[name_len[i]];
        }

        System.out.print(pair);
    }
}