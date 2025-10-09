import java.util.*;

class Solution {
    public int[] solution(int[] fees, String[] records) {
        // 입출차 관리 map
        // 누적 시간 관리 map
        // 요금 관리 map
        Map<Integer, Integer> come = new HashMap<>(); // 입출차 관리 map (key: 차량번호, value: 입차 시간)
        Map<Integer, Integer> time = new HashMap<>(); // 누적 시간 관리 map (key: 차량번호, value: 누적 시간)
        // Map<Integer, Integer> pay = new HashMap<>(); // 요금 관리 map (key: 차량번호, value: 누적 요금)
        // 입출차 기록으로 입차마다 come에 넣음
        String[] record;
        int car, t;
        String io;
        for(int i = 0;i < records.length; i++) {
            record = records[i].split(" ");
            t = Integer.parseInt(record[0].substring(0, 2))*60 + Integer.parseInt(record[0].substring(3));
            car = Integer.parseInt(record[1]);
            io = record[2];
            // System.out.println("t: " + t + ", car: " + car);
            if(io.equals("IN")) {
                come.put(car, t);
            } else {
                if(time.containsKey(car)) {
                    time.put(car, time.get(car) + (t-come.get(car)));
                    come.remove(car);
                } else {
                    time.put(car, t-come.get(car));
                    come.remove(car);
                }
            }
        }
        // 출차 시 time에 누적 시간 넣고 come에 있는 기록 뺌
        // 다 돌고 나면 come에 남은 애들은 11:59에 나온 걸로 누적 시간 time에 더함
        for(int i : come.keySet()) {
            if(time.containsKey(i)) {
                // System.out.println(i);
                time.put(i, time.get(i) + (23*60+59-come.get(i)));
                // System.out.println(time.get(i));
            } else {
                time.put(i, 23*60+59-come.get(i));
            }
        }
        // time keyset list에 넣어서 오름차순 정렬
        List<Integer> list = new ArrayList<>();
        for(int i: time.keySet()) {
            list.add(i);
        }
        list.sort(Comparator.naturalOrder());
        // map에서 하나씩 빼면서 정산해서 return
        int[] answer = new int[list.size()];
        for(int i = 0; i < answer.length; i++) {
            int t2 = time.get(list.get(i));
            int payment = fees[1];
            t2-=fees[0];
            if(t2>0) {
                payment+= t2%fees[2]==0?t2/fees[2]*fees[3]:(t2/fees[2]+1)*fees[3];
            }
            answer[i] = payment;
        }
        return answer;
    }
}