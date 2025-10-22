import java.io.*;
import java.util.*;

public class Main {

    public static boolean isPrime(int x) {
        for(int i=2; i<(int) Math.sqrt(x) + 1; i++) {
            if(x % i == 0) return false;
        }
        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        List<Integer> primes = new ArrayList<>();
        for(int i=2; i<=N; i++) {
            if(isPrime(i)) {
                primes.add(i);
            }
        }

        int answer = 0;
        if(primes.size() > 0) {
            int start = 0, end = 0;
            int sum = 0;
            primes.add(0);
            while(end < primes.size()) {
                if(sum == N) {
                    answer += 1;
                    sum += primes.get(end++);
                }else if(sum < N) {
                    sum += primes.get(end++);
                } else {
                    sum -= primes.get(start++);
                }
            }
        }

        bw.write(answer+"");
        bw.flush();
        bw.close();
        br.close();
    }

}