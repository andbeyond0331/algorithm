import java.util.*;

class Solution {
    public int solution(String[] friends, String[] gifts) {
        int answer = 0;
        // 친구들에게 준 선물 - 받은 선물
        // 둘 다 같으면 선물 x
        int len = friends.length;
        Map<String, Integer> idxMap = new HashMap<>();
        int[][] records = new int[len][len]; // 선물 준 친구 / 받은 친구
        int[] scores = new int[len];
        for(int i = 0; i < len; i++) {
            idxMap.put(friends[i], i);
        }
        String[] names;
        for(int i = 0; i < gifts.length; i++) {
            names = gifts[i].split(" ");
            int given = idxMap.get(names[0]);
            int taken = idxMap.get(names[1]);
            records[given][taken]++;
            scores[given]++;
            scores[taken]--;
        }
        int[] presents = new int[len]; // 받을 선물
        for(int i = 0; i < len; i++) {
            for(int j = 0; j < len; j++) {
                if(i==j) {
                    continue;
                }
                if(records[i][j]>records[j][i]) {
                    presents[i]++;
                } else if(records[i][j]==records[j][i]) {
                    if(scores[i] > scores[j]) {
                        presents[i]++;
                    }
                }
            }
        }
        int max = -1;
        for(int i = 0;i < len; i++) {
            max = Math.max(max, presents[i]);
        }
        return max;
    }
}