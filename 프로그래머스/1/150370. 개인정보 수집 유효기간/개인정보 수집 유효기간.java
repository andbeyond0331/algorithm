import java.util.*;

class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {
        int[] answer = {};
        // 고객의 약관 동의 수집 1~n번으로 분류되는 개인 정보 n개
        // 약관 종류 여러가지. 유효기간 전까지 보관 가능
        // 파기해야 할 개인정보 번호들 구하기
        List<Integer> list = new ArrayList<>();
        Map<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < terms.length; i++) {
            String[] temp = terms[i].split(" ");
            map.put(temp[0].charAt(0), Integer.parseInt(temp[1]));
        }
        
        int tYear = Integer.parseInt(today.substring(0, 4));
        int tMonth = Integer.parseInt(today.substring(5, 7));
        int tDay = Integer.parseInt(today.substring(8));
        int days = tYear*12*28 + tMonth*28 + tDay;
        
        String[] p;
        int year, month, day, tempDay;
        char term;
        for(int i = 0; i < privacies.length; i++) {
            p = privacies[i].split(" ");
            year = Integer.parseInt(p[0].substring(0, 4));
            month = Integer.parseInt(p[0].substring(5, 7));
            day = Integer.parseInt(p[0].substring(8));
            term = p[1].charAt(0);
            tempDay = year*12*28 + month*28 + day + 28*map.get(term);
            if(days>=tempDay) {
                list.add(i+1);
            }
            // day += 28*map.get(term)-1;
            // month += day/28;
            // day = day%28==0?28:day%28;
            // year += month/12;
            // if(month%12==0) {
            //     year--;
            // }
            // month = month%12==0?(day==28?11:12):day==28?month%12-1:month%12;
            // // System.out.println(year+"."+month+"."+day);
            // if(year<tYear) {
            //     list.add(i+1);
            //     continue;
            // } else if(year == tYear && month<tMonth) {
            //     list.add(i+1);
            //     continue;
            // } else if(month == tMonth && day<tDay){
            //     list.add(i+1);
            //     continue;
            // }
        }
        answer = new int[list.size()];
        for(int i = 0;i < list.size(); i++) {
            answer[i] = list.get(i);
        }
        return answer;
    }
}