import java.io.*;
import java.util.*;

public class Main {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
    

        String answer = (N / 3 +  N % 3) % 2 != 0 ? "SK" : "CY";
        
        bw.write(answer+"");
        bw.flush();
        bw.close();
        br.close();
    }

}