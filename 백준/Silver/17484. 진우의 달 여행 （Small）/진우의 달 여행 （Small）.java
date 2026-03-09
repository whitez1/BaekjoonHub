import java.io.*;
import java.util.*;

public class Main {

    static int answer = Integer.MAX_VALUE;
    static int[] dy = {-1,0,1};

    public static void dfs(int[][] arr, int n, int m, int i, int j, int diff, int sum) {
        if(sum >= answer) return;
        
        if(i==n) {
            answer = Math.min(answer, sum);
            return;
        }
         
        for(int k=0; k<dy.length; k++) {
            int nextj = j + dy[k];
            if (nextj < 0 || nextj >= m) continue;
            
            int dir = nextj - j;
            if(dir == diff) continue;
            
            dfs(arr, n, m, i+1, nextj, dir, sum+arr[i][nextj]);
        }
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] arr = new int[N][M];
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        for(int j=0; j<M; j++) {
            dfs(arr, N, M, 1, j, -2, arr[0][j]);
        }
        
        bw.write(answer+"\n");
        bw.flush();
        bw.close();
        br.close();
    }
}