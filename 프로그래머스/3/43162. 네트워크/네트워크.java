import java.util.*;
class Solution {
    int[] parent;
    
    int find(int x) {
        if(x == parent[x])
            return x;
        parent[x] = find(parent[x]);
        return parent[x];
    }
    
    void union(int x, int y) {
        int root1 = find(x);
        int root2 = find(y);
        parent[root1] = root2;
    }
    
    public int solution(int n, int[][] computers) {
        int answer = 0;
        parent = new int[n];
        for(int i = 0; i<n; i++) {
            parent[i] = i;
        }
        for(int i = 0; i<n; i++) {
            for(int j = 0; j<n; j++) {
                if(i==j) continue;
                if(computers[i][j] == 1 && find(i) != find(j))
                    union(i, j);
            }
        }
        HashSet<Integer> candidates = new HashSet<>();
        for(int i = 0; i<n; i++) {
            candidates.add(find(i));
        }
        return candidates.size();
    }
}