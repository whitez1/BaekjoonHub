import java.util.*;
class Solution {
    public static int[] parent;
    public static void init(int n) {
        parent = new int[n];
        for(int i = 0; i<n; i++) {
            parent[i] = i;
        }
    }
    public static int find(int x) {
        if(parent[x] == x)
            return x;
        parent[x] = find(parent[x]);
        return parent[x];
    }
    
    public static void union(int x, int y) {
        int root1 = find(x);
        int root2 = find(y);
        parent[root1] = root2;
    }
    
    public int solution(int n, int[][] costs) {
        int answer = 0;
        init(n);
        Arrays.sort(costs, (o1, o2) -> Integer.compare(o1[2], o2[2]));    
        for(int[] cost : costs) {
            if(find(cost[0]) != find(cost[1])) {
                answer += cost[2];
                union(cost[0], cost[1]);
            }
        }
        return answer;
    }
}