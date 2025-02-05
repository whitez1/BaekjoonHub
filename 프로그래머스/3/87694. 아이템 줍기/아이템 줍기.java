import java.util.*;

class Solution {
    static ArrayList<Integer> candidate = new ArrayList<>();
    static int[] dx = new int[]{0, 1, 0, -1};
    static int[] dy = new int[]{1, 0, -1, 0};
    
    public static boolean isInsideSquare(double nx, double ny, int[] coord) {
        return (coord[0] < nx && nx < coord[2]) && (coord[1] < ny && ny < coord[3]);
    }
      
    public static void dfs(int x, int y, int cnt, int[][] rectangle, boolean[][] visited, int itemX, int itemY) {
        if (x == itemX && y == itemY) {
            candidate.add(cnt);
            return;
        }
        visited[x][y] = true;
        
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            
            if (visited[nx][ny]) continue;
            
            boolean isInside = false;
            for(int[] coord: rectangle) {
               if (isInsideSquare(nx, ny, coord)) {
                   isInside = true;
                   break;
               }
            }
            if (isInside) continue;
            
            boolean isLine = false;
            for(int[] coord: rectangle) {
                int x1 = coord[0];
                int y1 = coord[1];
                int x2 = coord[2];
                int y2 = coord[3];
                if (i%2 == 0) {
                    if ((nx == x1 || nx == x2) && (y1 <= ny && ny <= y2)) {
                        isLine = true;
                        break;
                    }
                } else {
                    if ((ny == y1 || ny == y2) && (x1 <= nx && nx <= x2)) {
                        isLine = true;
                        break;
                    }
                }
            }
            if (!isLine) continue;   
            
            cnt += 1;
            dfs(nx, ny, cnt, rectangle, visited, itemX, itemY);
            cnt -= 1;
        }
    }
    
    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        boolean[][] visited = new boolean[102][102];
        for(int[] coord: rectangle) {
            coord[0] *= 2;
            coord[1] *= 2;
            coord[2] *= 2;
            coord[3] *= 2;
        }
        characterX *= 2;
        characterY *= 2;
        itemX *= 2;
        itemY *= 2;
        
        dfs(characterX, characterY, 0, rectangle, visited, itemX, itemY);
        
        return Collections.min(candidate) / 2;
    }
}