import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        ArrayDeque<Integer> trucks = new ArrayDeque<>();
        for(int i=0; i<n; i++) {
            trucks.addLast(Integer.parseInt(st.nextToken()));
        }

        ArrayDeque<Integer> bridge = new ArrayDeque<>();
        for(int i=0; i<w; i++) {
            bridge.addLast(0);
        }

        int time = 0;
        int sum_weight = 0;

        while(!bridge.isEmpty()) {
            time++;
            sum_weight -= bridge.pollFirst();
            if(!trucks.isEmpty()){
                if (trucks.peek() + sum_weight <= L) {
                    sum_weight += trucks.peek();
                    bridge.addLast(trucks.pollFirst());
                   
                } else {
                    bridge.addLast(0);
                }
            }
        }

        bw.write(time+"");
        bw.flush();
        bw.close();
        br.close();
    }
}