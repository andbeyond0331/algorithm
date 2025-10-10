import java.util.*;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];
        Map<String, Set<String>> map = new HashMap();
        Map<String, Integer> idx = new HashMap();
        for(int i = 0;i < answer.length; i++) {
            idx.put(id_list[i], i);
        }
        StringTokenizer st;
        for(int i = 0;i < report.length; i++) {
            st = new StringTokenizer(report[i], " ");
            String a = st.nextToken();
            String b = st.nextToken();
            if(!map.containsKey(b)) {
                map.put(b, new HashSet<>());
                // map.get(b).add(a);
            }
            map.get(b).add(a);
        }
        for(String s: map.keySet()) {
            if(map.get(s).size()>=k) {
                for(String name: map.get(s)) {
                    answer[idx.get(name)]++;
                }
            }
        }
        return answer;
    }
}