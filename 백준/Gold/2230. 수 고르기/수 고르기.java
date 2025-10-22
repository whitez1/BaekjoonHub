import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] A = new int[N];
        for(int i=0; i<N; i++) {
            A[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(A);

        int i = 0, j = 0;
        int answer = Integer.MAX_VALUE;
        while(j < N) {
            int diff = A[j] - A[i];
            if (diff == M) {
                answer = M;
                break;
            }
            else if (diff < M) {
                j++;
            } else {
                i++;
                answer = Math.min(answer, diff);
            }
        }

        bw.write(answer+"");
        bw.flush();
        bw.close();
        br.close();
    }

}