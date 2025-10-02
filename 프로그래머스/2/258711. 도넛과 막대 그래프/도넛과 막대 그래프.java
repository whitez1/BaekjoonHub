import java.util.*;

class Solution {
    public int[] solution(int[][] edges) {
        int[] answer = new int[4];

        Map<Integer, Integer> indegree = new HashMap<>();
        Map<Integer, Integer> outdegree = new HashMap<>();
        Map<Integer, List<Integer>> graph = new HashMap<>();
        Set<Integer> nodes = new HashSet<>();

        for (int[] e : edges) {
            int a = e[0], b = e[1];
            outdegree.put(a, outdegree.getOrDefault(a, 0) + 1);
            indegree.put(b, indegree.getOrDefault(b, 0) + 1);
            graph.computeIfAbsent(a, k -> new ArrayList<>()).add(b);
            nodes.add(a);
            nodes.add(b);
        }

        int gv = -1;
        for (int node : nodes) {
            if (indegree.getOrDefault(node, 0) == 0 && outdegree.getOrDefault(node, 0) >= 2) {
                gv = node;
                break;
            }
        }
        answer[0] = gv;

        if (gv == -1) return answer;

        Set<Integer> visited = new HashSet<>();

        List<Integer> entries = graph.getOrDefault(gv, new ArrayList<>());

        for (int entry : entries) {
            if (visited.contains(entry)) continue;

            Set<Integer> comp = new HashSet<>();
            Queue<Integer> q = new LinkedList<>();
            q.add(entry);
            visited.add(entry);
            comp.add(entry);

            while (!q.isEmpty()) {
                int cur = q.poll();
                for (int nei : graph.getOrDefault(cur, Collections.emptyList())) {
                    if (!visited.contains(nei)) {
                        visited.add(nei);
                        q.add(nei);
                        comp.add(nei);
                    }
                }
            }

            boolean hasIn2Out2 = false;
            boolean hasOut0 = false;    

            for (int v : comp) {
                int inGlobal = indegree.getOrDefault(v, 0);
                int inInternal = inGlobal - (v == entry ? 1 : 0);
                int out = outdegree.getOrDefault(v, 0);

                if (inInternal == 2 && out == 2) hasIn2Out2 = true;
                if (out == 0) hasOut0 = true;
            }

            if (hasIn2Out2) {
                answer[3]++; 
            } else if (hasOut0) {
                answer[2]++; 
            } else {
                answer[1]++; 
            }
        }

        return answer;
    }
}
