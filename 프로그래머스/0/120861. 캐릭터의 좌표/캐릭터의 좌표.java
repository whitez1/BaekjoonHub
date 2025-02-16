import java.util.*;
class Solution {
    public int[] solution(String[] keyinput, int[] board) {
        HashMap<String, int[]> direction = new HashMap<>();
        direction.put("up", new int[]{0, 1});
        direction.put("down", new int[]{0, -1});
        direction.put("left", new int[]{-1, 0});
        direction.put("right", new int[]{1, 0});
        
        int w = (int) board[0] / 2;
        int h = (int) board[1] / 2;
        
        int x = 0, y = 0;
        for(String key : keyinput) {
            int dx = direction.get(key)[0];
            int dy = direction.get(key)[1];
            int nx = x + dx;
            int ny = y + dy;
            
            if(nx<-w || nx > w || ny<-h || ny>h) continue;
            
            x = nx;
            y = ny;
        }
        return new int[]{x, y};
    }
}