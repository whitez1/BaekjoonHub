import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        int[] A = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        int i = 0, j = 0;
        int answer = Integer.MAX_VALUE;
        int sum = A[j];
        while(j < N) {
            if (sum >= S) {
                answer = Math.min(answer, j-i+1);
                if(j-i+1 == 1) break;
                sum -= A[i];
                i++;
            } else {
                j++;
                if(j == N) break;
                sum += A[j];
            }
        }
        if(answer == Integer.MAX_VALUE) answer = 0;

        bw.write(answer+"");
        bw.flush();
        bw.close();
        br.close();
    }

}