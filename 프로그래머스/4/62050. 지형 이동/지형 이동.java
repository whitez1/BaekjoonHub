import java.util.*;
class Solution {
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    
    public static class Node{
        int x, y, cost;
        public Node(int x, int y, int cost) {
            this.x = x;
            this.y = y;
            this.cost = cost;
        }
    }
    
    public int solution(int[][] land, int height) {
        int answer = 0;
        boolean[][] visited = new boolean[land.length][land.length];
        PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> Integer.compare(o1.cost, o2.cost));
        pq.add(new Node(0, 0, 0));
        
        while(!pq.isEmpty()) {
            Node node = pq.poll();
            if(visited[node.x][node.y]) continue;
            visited[node.x][node.y] = true;
            answer += node.cost;
            for(int i = 0; i<4; i++) {
                int nx = node.x + dx[i];
                int ny = node.y + dy[i];
                
                if(nx < 0 || nx > land.length-1 || ny < 0 || ny > land.length-1) continue;
                
                int tmpCost = Math.abs(land[nx][ny] - land[node.x][node.y]);
                int newCost = tmpCost > height ? tmpCost : 0;
                
                pq.add(new Node(nx, ny, newCost));
            }
        }
        
        return answer;
    }
}