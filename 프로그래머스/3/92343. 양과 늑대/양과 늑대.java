import java.util.*;
class Solution {
    int maxS;
    int[] nodes;
    ArrayList<Integer>[] graph = new ArrayList[17];
    boolean[][][] visited = new boolean[17][18][18];

    public void dfs(int pos, int s, int w) {
        if(visited[pos][s][w]) return;
        visited[pos][s][w] = true;
        
        int backupS = s;
        int backupW = w;
        int backupNode = nodes[pos];
        
        if(nodes[pos] == 0) s++;
        else if(nodes[pos] == 1) w++;
        
        nodes[pos] = -1;
        
        if(w < s) {
            maxS = Math.max(maxS, s);
            for(int next: graph[pos]) {
                dfs(next, s, w);
            }
        }
        
        nodes[pos] = backupNode;
        visited[pos][backupS][backupW] = false;
        
    }
    
    public int solution(int[] info, int[][] edges) {
        nodes = info;
        
        for(int i=0; i<nodes.length; i++) {
            graph[i] = new ArrayList<>();
        }
        
        for(int[] edge: edges) {
            graph[edge[0]].add(edge[1]);
            graph[edge[1]].add(edge[0]);
        }
        
        maxS = 0;
        dfs(0, 0, 0);
        
        return maxS;
    }
}