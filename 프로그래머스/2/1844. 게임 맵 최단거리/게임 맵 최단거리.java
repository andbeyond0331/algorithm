import java.util.*;

class Solution {
    static int[] dr = {1, -1, 0, 0};
    static int[] dc = {0, 0, 1, -1};
    public int solution(int[][] maps) {
        int answer = 0;
        int n = maps.length;
        int m = maps[0].length;
        boolean[][] visited = new boolean[n][m];
        Queue<int[]> q = new LinkedList();
        q.add(new int[]{0, 0, 1});
        visited[0][0] = true;
        while(!q.isEmpty()) {
            int[] current = q.poll();
            int r = current[0];
            int c = current[1];
            if(r==n-1 && c==m-1) {
                return current[2];
            }
            for(int i = 0;i < dr.length; i++) {
                int nr = r + dr[i];
                int nc = c + dc[i];
                if(nr>=0 && nr < n && nc >= 0 && nc < m && maps[nr][nc] == 1 && !visited[nr][nc]) {
                    visited[nr][nc] = true;
                    q.add(new int[]{nr, nc, current[2]+1});
                }
            }
        }
        return -1;
    }
}