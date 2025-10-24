import java.io.*;
import java.util.*;

public class Main {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[][] records = new int[N][4];
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<4; j++) {
                records[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        Arrays.sort(records, (x, y) -> {
            if(x[1] == y[1]) {
                if(x[2] == y[2]) {
                    if(x[3] == y[3]) {
                        return x[0] - y[0];
                    } else {
                        return y[3] - x[3];
                    }
                } else {
                    return y[2] - x[2];
                }
            } else {
                return y[1] - x[1];
            }
        });

        int cnt = 0;
        int[] pre = new int[4];
        int answer = 0;
        for(int i=0; i<N; i++) {
            if(!(records[i][1] == pre[1] && records[i][2] == pre[2] && records[i][3] == pre[3])) 
                cnt++;
            
            if(records[i][0] == K) {
                answer = cnt;
                break;
            }
            pre = records[i];
        }
        
        bw.write(answer+"\n");
        bw.flush();
        bw.close();
        br.close();
    }

}