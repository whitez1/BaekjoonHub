import java.util.*;
class Solution {
    public long solution(int cap, int n, int[] deliveries, int[] pickups) {
        long answer = 0;
        
        Stack<int[]> stackd = new Stack<>();
        Stack<int[]> stackp = new Stack<>();
        
        for(int i=0; i<n; i++) {
            if(deliveries[i] > 0) {
                stackd.push(new int[]{i+1, deliveries[i]});
            }
            if(pickups[i] > 0) {
                stackp.push(new int[]{i+1, pickups[i]});
            }
        }
        
        while(!stackd.isEmpty() || !stackp.isEmpty()) {
            int maxd = 0;
            int maxp = 0;
            int dcap = cap;
            int pcap = cap;
            while(!stackd.isEmpty()) {
                int[] d = stackd.pop();
                maxd = Math.max(maxd, d[0]);
                if(dcap > d[1]) {
                    dcap -= d[1];
                } else {
                    if(d[1] > dcap) {
                        d[1] -= dcap;
                        stackd.push(d);
                    }
                    break;
                }
            }
            
            while(!stackp.isEmpty()) {
                int[] p = stackp.pop();
                maxp = Math.max(maxp, p[0]);
                if(pcap > p[1]) {
                    pcap -= p[1];
                } else {
                    if(p[1] > pcap) {
                        p[1] -= pcap;
                        stackp.push(p);
                    }
                    break;
                }
            }
            answer += Math.max(maxd, maxp)*2;
        }
        
        return answer;
    }
}