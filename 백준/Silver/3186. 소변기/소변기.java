import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int K = Integer.parseInt(st.nextToken()); // 사용중으로 기록되는 최소 시간
        int L = Integer.parseInt(st.nextToken()); // 완료로 기록되는 빈 시간
        int N = Integer.parseInt(st.nextToken()); // 수열의 길이
        
        String sequence = br.readLine();
        
        List<Integer> flushTimes = new ArrayList<>();
        
        boolean isUsing = false;        // 현재 사용중 상태인지
        int continuousOnes = 0;         // 연속된 1의 개수
        int emptyCountAfterUse = 0;     // 사용중 상태가 된 후 연속된 0의 개수
        
        for (int i = 0; i < N; i++) {
            char c = sequence.charAt(i);
            
            if (c == '1') {
                // 사람이 있는 경우
                continuousOnes++;
                emptyCountAfterUse = 0; // 0 카운트 리셋
                
                // K초 이상 연속으로 있으면 "사용중"으로 기록
                if (!isUsing && continuousOnes >= K) {
                    isUsing = true;
                }
            } else {
                // 사람이 없는 경우 (0)
                if (isUsing) {
                    // 사용중 상태에서만 빈 시간 카운트
                    emptyCountAfterUse++;
                    
                    // L초 동안 비어있으면 "완료" 처리 및 플러시
                    if (emptyCountAfterUse == L) {
                        // 플러시는 L초가 완료된 다음 시점 (i+1)
                        flushTimes.add(i + 1);
                        isUsing = false;
                        emptyCountAfterUse = 0;
                    }
                }
                continuousOnes = 0; // 1 카운트 리셋
            }
        }
        
        // 수열이 끝난 후에도 사용중 상태라면
        if (isUsing && emptyCountAfterUse >= L) {
            // 이미 처리됨
        } else if (isUsing) {
            // 수열 끝 이후 L초가 더 지나야 플러시
            // 마지막 인덱스는 N-1이므로, 끝난 시점은 N
            int remainingEmpty = L - emptyCountAfterUse;
            if (remainingEmpty > 0) {
                flushTimes.add(N + remainingEmpty);
            }
        }
        
        // 출력
        if (flushTimes.isEmpty()) {
            System.out.println("NIKAD");
        } else {
            for (int time : flushTimes) {
                System.out.println(time);
            }
        }
    }
}