import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<N; i++) {
            int oScore = 0;
            int answer = 0;
            for(char re : br.readLine().toCharArray()) {
                if(re == 'O') {
                    oScore += 1;
                    answer += oScore;
                } 
                else if (re == 'X') {
                    oScore = 0;
                }
            }
            sb.append(answer+"\n"); 
        }

        bw.write(sb.toString()+"");
        bw.flush();
        bw.close();
        br.close();
    }

}