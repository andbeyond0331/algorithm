import java.util.*;

class Solution {
    static int[] memo; // 백트래킹 기록용(할인율)
    static int n; // 이모티콘 갯수
    static int[][] user;
    static int[] emoticon;
    static int signed;// 이모티콘 플로스 가입자 수
    static int sales; // 판매액
    public int[] solution(int[][] users, int[] emoticons) {
        int[] answer = {};
        // 플러스 가입 -> 이모티콘 판매액
        // 자신의 기준에 따라 일정 비율 이상 할인 시 이모티콘 모두 구매
        // 각 사용자들은 자신의 기준에 따라 이모티콘 구매 비용의 합이 일정 가격 이상이면 이모티콘 구매 모두 취소하고 이모티콤 플러스 서비스에 가입
        // 일단 .. 이모티콘 플러스 서비스에 가입 시키려면 ..
        n = emoticons.length;
        memo = new int [n];
        user = new int [users.length][2];
        for(int i = 0; i < users.length; i++){
            user[i][0] = users[i][0];
            user[i][1] = users[i][1];
        }
        emoticon = Arrays.copyOf(emoticons, n);
        sales = -1;
        signed = -1;
        backtracking(0);
        
        return new int[]{signed, sales};
    }
    static void calculating() {
        int cnt1 = 0; // 가입자수
        int cnt2 = 0; // 판매액
        int[] saled = new int[emoticon.length];
        for(int i = 0;i < emoticon.length; i++) {
            saled[i] = emoticon[i]*(100-memo[i])/100;
        }
        for(int i = 0;i < user.length; i++) {
            int temp = 0; // 해당 유저가 이모티콘 구매한 금액
            for(int j = 0; j < emoticon.length; j++) {
                if(user[i][0]<=memo[j]) {
                    temp+=saled[j];
                }
            }
            if(temp>=user[i][1]) {
                cnt1++;
            } else {
                cnt2+=temp;
            }
        }
        if(signed>cnt1) {
            return;
        }
        if(signed==cnt1) {
            if(sales<cnt2) {
                signed = cnt1;
                sales = cnt2;
            }
        } else {
            signed = cnt1;
            sales = cnt2;
        }
    }
    static void backtracking(int depth) {
        if(depth==n) {
            calculating();
            return;
        }
        for(int i = 10; i <= 40; i+=10 ) {
            memo[depth] = i;
            backtracking(depth+1);
        }
    }
}