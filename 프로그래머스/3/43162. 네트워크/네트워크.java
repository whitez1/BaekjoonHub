import java.util.*;
class Solution {
    boolean[] visited;
    void dfs(int x, int n, int[][] computers) {
        visited[x] = true;
        for(int i = 0; i<n; i++){
            if(x == i) continue;
            if(visited[i]) continue;
            if(computers[x][i] == 0) continue;
            dfs(i, n, computers);
        }
            
    }
    
    public int solution(int n, int[][] computers) {
        int answer = 0;
        visited = new boolean[n];
        
        for(int i = 0; i<n; i++) {
            if(!visited[i]){
                dfs(i, n, computers);
                answer++;
            }
        }
        
        return answer;
    }
}