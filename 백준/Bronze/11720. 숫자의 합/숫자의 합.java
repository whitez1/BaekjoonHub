import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        char[] numbers = br.readLine().toCharArray();

        int answer = 0;
        for(char number : numbers) {
            int i = Character.getNumericValue(number);
            answer += i;
        }

        bw.write(answer+"");
        bw.flush();
        bw.close();
        br.close();
    }

}