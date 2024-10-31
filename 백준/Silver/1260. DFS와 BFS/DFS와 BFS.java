import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st1 = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st1.nextToken());
        int m = Integer.parseInt(st1.nextToken());
        int v = Integer.parseInt(st1.nextToken());


        int[][] graph = new int[n+1][n+1];
        for (int i = 0; i < m; i++) {
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st2.nextToken());
            int b = Integer.parseInt(st2.nextToken());
            graph[a][b] = graph[b][a] = 1;
        }

        String answer1 = dfs(n, v, graph);
        String answer2 = bfs(n, v, graph);
        bw.write(answer1+"\n");
        bw.write(answer2+"\n");
        bw.flush();

    }

    private static String dfs(int n, int v, int[][] graph) {
        StringBuilder sb = new StringBuilder();
        ArrayDeque<Integer> stack = new ArrayDeque<Integer>();
        int[] visited = new int[n+1];
        stack.push(v);
        
        while(!stack.isEmpty()) {
            int x = stack.pop();
            if (visited[x] == 0) {
                visited[x] = 1;
                sb.append(x+" ");
            }
      
            for(int i=n; i>0; i--) {
                if (graph[x][i] == 1 && visited[i] == 0) {
                    stack.push(i);
                }
            }
        }
        return sb.toString().trim();
    }

    private static String bfs(int n, int v, int[][] graph) {
        StringBuilder sb = new StringBuilder();
        ArrayDeque<Integer> queue = new ArrayDeque<Integer>();
        int[] visited = new int[n+1];
        queue.add(v);
        visited[v] = 1;
        sb.append(v+" ");
        
        while(!queue.isEmpty()) {
            int x = queue.poll();

            for(int i=1; i<n+1; i++) {
                if (graph[x][i] == 1 && visited[i] == 0) {
                    queue.add(i);
                    visited[i] = 1;
                    sb.append(i+" ");
                }
            }
        }
        return sb.toString().trim();
    }
}