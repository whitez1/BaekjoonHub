import java.io.*;
import java.util.*;

public class Main {

    
    private static StringBuilder sb = new StringBuilder();
    private static int n, m, v;
    private static int[][] graph;
    private static boolean[] visited;
    private static ArrayDeque<Integer> queue = new ArrayDeque<Integer>();

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st1 = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st1.nextToken());
        m = Integer.parseInt(st1.nextToken());
        v = Integer.parseInt(st1.nextToken());


        graph = new int[n+1][n+1];
        for (int i = 0; i < m; i++) {
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st2.nextToken());
            int b = Integer.parseInt(st2.nextToken());
            graph[a][b] = graph[b][a] = 1;
        }
        visited = new boolean[n+1];
        dfs(v);
        sb.append("\n");

        visited = new boolean[n+1];
        bfs(v);

        bw.write(sb.toString());
        bw.flush();

        br.close();
        bw.close();
    }

    private static void dfs(int v) {
        visited[v] = true;
        sb.append(v+" ");
        for(int i=1; i<n+1; i++) {
            if (graph[v][i] == 1 && !visited[i]) {
                dfs(i);
            }
        }    
    }

    private static void bfs(int v) {
        queue.add(v);
        visited[v] = true;
        
        while(!queue.isEmpty()) {
            int x = queue.poll();
            sb.append(x+" ");

            for(int i=1; i<n+1; i++) {
                if (graph[x][i] == 1 && !visited[i]) {
                    queue.add(i);
                    visited[i] = true;
                }
            }
        }
    }
}