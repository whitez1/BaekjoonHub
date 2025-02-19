import java.util.*;
class Solution {
    
    char[][] map;
    int[][] time;
    int n, m;
    
    public int bfs(int[] start) {
        int[] dx = new int[]{0,0,1,-1};
        int[] dy = new int[]{1,-1,0,0};
        Queue<int[]> q = new ArrayDeque<>();
        q.add(start);
        boolean isPulled = false;
        while(!q.isEmpty()) {
            int[] now = q.poll();
            int x = now[0];
            int y = now[1];
            
            if(map[x][y] == 'L') {
                isPulled = true;
                int tmp = time[x][y];
                time = new int[n][m];
                time[x][y] = tmp;
                q.clear();
            } 
            
            if(isPulled && map[x][y] == 'E')
                return time[x][y];
            
            for(int i = 0; i<4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                
                if(nx<0 || nx>=n || ny<0 || ny>=m) continue;
                if(time[nx][ny] > 0) continue;
                if(map[nx][ny] == 'X') continue;
                q.add(new int[]{nx, ny});
                time[nx][ny] = time[x][y] + 1;
            }
        }
        return -1;
    }
    
    public int solution(String[] maps) {
        int answer = 0;
        map = Arrays.stream(maps).map(x -> x.toCharArray()).toArray(char[][] :: new);
        n = map.length;
        m = map[0].length;
        time = new int[n][m];
        
        for(int i = 0; i<n; i++) {
            for(int j = 0; j<m; j++) {
                if(map[i][j] == 'S') {
                    int[] start = new int[]{i, j};
                    return bfs(start);
                }
            }
        }
        return -1;
    }
}