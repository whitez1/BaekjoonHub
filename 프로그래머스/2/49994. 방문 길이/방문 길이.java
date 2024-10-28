import java.util.*;
class Solution {
    public int solution(String dirs) {
        int answer = 0;
        
        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, 1, -1}; // D U R L
        
        int x = 0;
        int y = 0;
        int d = -1;
        int nx, ny;
        int dir_idx = -1;
        
        ArrayList<Integer[]> list = new ArrayList<>();
        
        for (int i=0; i<dirs.length(); i++) {
            if (dirs.charAt(i) == 'U') {
                dir_idx = 1;
            } else if (dirs.charAt(i) == 'D') {
                dir_idx = 0;
            } else if (dirs.charAt(i) == 'R') {
                dir_idx = 2;
            } else{
                dir_idx = 3;
            }
            nx = x + dx[dir_idx];
            ny = y + dy[dir_idx];
            boolean isVisited = false;
            
            if (nx<(-5) || nx>5 || ny<(-5) || ny>5) continue;
            
            
            for (Integer[] l : list){
                if (x == l[0] && y == l[1] && nx == l[2] && ny == l[3]) {
                    isVisited = true;
                    break;
                }
            }
            if (isVisited) {
                x = nx;
                y = ny;
                continue;
            }
            Integer[] pre1 = {x, y, nx, ny};
            Integer[] pre2 = {nx, ny, x, y};
            list.add(pre1);
            list.add(pre2);
            
            answer += 1;
            
            x = nx;
            y = ny;
           
        }
        return answer;
    }
}