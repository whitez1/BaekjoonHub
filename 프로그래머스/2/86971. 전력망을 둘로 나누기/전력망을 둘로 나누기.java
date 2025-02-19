import java.util.*;
class Solution {
    
    ArrayList<Integer>[] adjList;
    boolean[] visited;
    int N;
    
    int dfs(int start) {
        Stack<Integer> stack = new Stack<>();
        stack.push(start);
        visited = new boolean[N+1];
        int cnt = 0;
        while(!stack.isEmpty()) {
            int now = stack.pop();
            visited[now] = true;
            cnt += 1;
            for(int next : adjList[now]){
                if(!visited[next]){
                    stack.push(next);
                }  
            }
        }
        return cnt;
    }
    
    public int solution(int n, int[][] wires) {
        N = n;
        int answer = n;
        adjList = new ArrayList[n+1];
        for(int i = 0; i<n+1; i++) {
            adjList[i] = new ArrayList<>();
        }
        
        for(int[] edge : wires) {
            adjList[edge[0]].add(edge[1]);
            adjList[edge[1]].add(edge[0]);
        }
        
        for(int[] edge : wires) {
            adjList[edge[0]].remove(Integer.valueOf(edge[1]));
            adjList[edge[1]].remove(Integer.valueOf(edge[0]));
            
            int num1 = dfs(edge[0]);
            int num2 = dfs(edge[1]);
            answer = Math.min(Math.abs(num1-num2), answer);
            
            adjList[edge[0]].add(edge[1]);
            adjList[edge[1]].add(edge[0]);
        }
        return answer;
    }
}