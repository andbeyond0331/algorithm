class Solution {
    public String solution(String new_id) {
        String answer = "";
        // 3~15
        // - _ . 소문자, 숫자
        // .: 처음, 끝 안됨. 연속 안됨
        // 1단계 new_id의 모든 대문자를 대응되는 소문자로 치환합니다.
        int len = new_id.length();
        for(int i = 0; i < len; i++) {
            char c = new_id.charAt(i);
            if(c>='A' && c<='Z') {
                answer+=new_id.substring(i, i+1).toLowerCase();
            } else {
                answer+=new_id.substring(i, i+1);
            }
        }
        // 2단계 new_id에서 알파벳 소문자, 숫자, 빼기(-), 밑줄(_), 마침표(.)를 제외한 모든 문자를 제거합니다.
        new_id = "";
        for(int i = 0; i < answer.length(); i++) {
            char c = answer.charAt(i);
            if((c>='a' && c<='z') || (c>='0' && c<='9') || c=='-' || c=='_' || c=='.') {
                new_id+=answer.substring(i, i+1);
            }
        }
        // 3단계 new_id에서 마침표(.)가 2번 이상 연속된 부분을 하나의 마침표(.)로 치환합니다.
        answer = "";
        outer: for(int i = 0;i < new_id.length(); i++) {
            char c = new_id.charAt(i);
            if(answer.length()>0) {
                if(answer.charAt(answer.length()-1)=='.') {
                    if(c!='.') {
                        answer+=new_id.substring(i, i+1);
                    }
                } else {
                    answer+=new_id.substring(i, i+1);
                }
            } else {
                answer+=new_id.substring(i, i+1);
            }
            // if(c=='.') {
            //     if(answer.length()>0) {
            //         if(answer.charAt(answer.length()-1)!='.') {
            //             System.out.println(answer.charAt(answer.length()-1));
            //             answer+=new_id.substring(i, i+1);
            //         } else {
            //             answer+=new_id.substring(i, i+1);
            //         }
            //     } else {
            //         answer+=new_id.substring(i, i+1);
            //     }
            // }  else {
            //     answer+=new_id.substring(i, i+1);
            // }
            
        }
        System.out.println(answer);
        // 4단계 new_id에서 마침표(.)가 처음이나 끝에 위치한다면 제거합니다.
        if(answer.length()>0 && answer.charAt(0)=='.') {
            answer = answer.substring(1);
        }
        if(answer.length()>0 && answer.charAt(answer.length()-1)=='.') {
            answer = answer.substring(0, answer.length()-1);
        }
        // 5단계 new_id가 빈 문자열이라면, new_id에 "a"를 대입합니다.
        if(answer.length()==0) {
            answer = "a";
        }
        // 6단계 new_id의 길이가 16자 이상이면, new_id의 첫 15개의 문자를 제외한 나머지 문자들을 모두 제거합니다.
        if(answer.length()>=16) {
            answer = answer.substring(0, 15);
        }
        //      만약 제거 후 마침표(.)가 new_id의 끝에 위치한다면 끝에 위치한 마침표(.) 문자를 제거합니다.
        if(answer.charAt(answer.length()-1)=='.') {
            answer = answer.substring(0, answer.length()-1);
        }
        // 7단계 new_id의 길이가 2자 이하라면, new_id의 마지막 문자를 new_id의 길이가 3이 될 때까지 반복해서 끝에 붙입니다.
        if(answer.length()<=2) {
            answer = String.format("%-3s", answer).replace(" ", answer.substring(answer.length()-1));
        }
        return answer;
    }
}