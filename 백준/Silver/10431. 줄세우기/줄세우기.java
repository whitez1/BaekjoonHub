import java.io.*;
import java.util.*;

public class Main {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
  
        for(int i=0; i<N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            sb.append(st.nextToken()+" ");
            List<Integer> heights = new ArrayList<>();
            int answer = 0;
            for(int j=0; j<20; j++) {
                int x = Integer.parseInt(st.nextToken());
                int len = heights.size();
                for(int k=0; k<len; k++) {
                    if(heights.get(k) > x) {
                        answer += len - k;
                        heights.add(k, x);
                        break;
                    }
                } 
                if(heights.size() == len) heights.add(x);
            }
            sb.append(answer+"\n");
        }
        
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

}