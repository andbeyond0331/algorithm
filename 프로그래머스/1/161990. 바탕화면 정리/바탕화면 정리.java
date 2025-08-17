class Solution {
    public int[] solution(String[] wallpaper) { // 빈칸 . 파일 #
        int[] answer = new int[4]; // lux, luy, rdx, rdy
        // x 최소최대, y최소최대 lux<rdx /luy <rdy
        answer[0] = 51;
        answer[1] = 51;
        answer[2] = -1;
        answer[3] = -1;
        for(int i = 0; i < wallpaper.length; i++) {
            String line = wallpaper[i];
            for(int j = 0; j < line.length(); j++) {
                if(line.charAt(j)=='#') {
                    answer[0] = Math.min(answer[0], i);
                    answer[1] = Math.min(answer[1], j);
                    answer[2] = Math.max(answer[2], i);
                    answer[3] = Math.max(answer[3], j);
                }
            }
        }
        answer[2]++;
        answer[3]++;
        return answer;
    }
}