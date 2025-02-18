import java.util.*;
class Solution {
    int[][] graph;
    int n, m;
    void bfs(int[][] maps) {
        int[] dx = new int[]{0, 0, 1, -1};
        int[] dy = new int[]{1, -1, 0, 0};
        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[]{0,0});
        graph[0][0] = 1;
        while(!q.isEmpty()) {
            int[] now = q.poll();
            int x = now[0];
            int y = now[1];
            
            if(x == (n-1) && y == (m-1))
                return;
            
            for(int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                
                if(nx<0 || nx>=n || ny<0 || ny>=m) continue;
                if(maps[nx][ny] == 0) continue;
                if(graph[nx][ny] > 0) continue;
                
                graph[nx][ny] = graph[x][y] + 1;
                q.add(new int[]{nx, ny});
            }
        }
    }
    
    public int solution(int[][] maps) {
        n = maps.length;
        m = maps[0].length;
        graph = new int[n][m];
        bfs(maps);
        
        return graph[n-1][m-1] != 0 ? graph[n-1][m-1] : -1;
    }
}