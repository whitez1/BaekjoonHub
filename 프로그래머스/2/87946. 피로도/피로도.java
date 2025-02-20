import java.util.*;
class Solution {
    int n, answer;
    boolean visited[];
    int[][] dungeon;
    
    void backtrack(int cnt, int k) {
        if(cnt == n || k < dungeon[cnt][0] ) {
            answer = Math.max(cnt, answer);
        }
        
        for(int i = 0; i<n; i++) {
            if(k >= dungeon[i][0]) {
               if(!visited[i]){
                    visited[i] = true;
                    backtrack(cnt+1, k-dungeon[i][1]);
                    visited[i] = false;
                } 
            }
        }
    }
    
    public int solution(int k, int[][] dungeons) {
        answer = -1;
        n = dungeons.length;
        visited = new boolean[n];
        dungeon = dungeons;
        backtrack(0, k);
        return answer;
    }
}