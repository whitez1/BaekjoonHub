import java.io.*;
import java.util.*;

public class Main {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        boolean[] isPrime = new boolean[N + 1];
        Arrays.fill(isPrime, true);
        isPrime[0] = isPrime[1] = false;
        for (int i = 2; i * i <= N; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j <= N; j += i) {
                    isPrime[j] = false;
                }
            }
        }

        ArrayList<Integer> primes = new ArrayList<>();
        for (int i = 2; i <= N; i++) {
            if (isPrime[i]) primes.add(i);
        }

        int count = 0;
        int start = 0, end = 0, sum = 0;

        while (true) {
            if (sum >= N) {
                if (sum == N) count++;
                sum -= primes.get(start++);
            } else {
                if (end == primes.size()) break;
                sum += primes.get(end++);
            }
        }
        
        bw.write(count+"");
        bw.flush();
        bw.close();
        br.close();
    }

}