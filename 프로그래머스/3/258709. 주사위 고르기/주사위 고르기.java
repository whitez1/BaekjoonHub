import java.util.*;

class Solution {
    
    int n;
    boolean[] visited;
       
    int[] answer;
    int maxNumOfWin = -1; 
    public void numOfCasesAfterRollDice(int p, int[] pickedDice, int[][] dice, PriorityQueue<Integer> pq, int sum){
        
        if(p == pickedDice.length) {
            pq.add(sum);
            return;
        }
        
        for(int i=0; i<6; i++) {
            numOfCasesAfterRollDice(p+1, pickedDice, dice, pq, sum + dice[pickedDice[p]-1][i]);
        }
    }
    
    
    public void combination(int p, int start, int[] result, int[][] dice) {
        
        if(p == n / 2) {
            Set<Integer> set = new HashSet<>();
            for(int i=1; i<=n; i++) {
                set.add(i);
            }
            for(int r : result) {
                set.remove(r);
            }
            PriorityQueue<Integer> qa = new PriorityQueue<>();
            PriorityQueue<Integer> qb = new PriorityQueue<>();
            int[] bdices = set.stream().mapToInt(Integer::intValue).toArray();
            
            numOfCasesAfterRollDice(0, result, dice, qa, 0);
            numOfCasesAfterRollDice(0, bdices, dice, qb, 0);
            
            int pre = 0;
            int[] csum = new int[501];
            int x = 0;
            while(!qb.isEmpty()) {
                x = qb.poll();
                if(pre != x) {
                    for(int i=pre+1; i<=x; i++)
                        csum[i] += csum[pre];
                }
                csum[x] += 1;
                pre = x;
            }
        
            int sum = 0;
            while(!qa.isEmpty()) {
                int y = qa.poll();
                if(y-1 > x) sum += csum[x];
                else sum += csum[y-1];
            }
               
            if(sum > maxNumOfWin) {
                answer = Arrays.copyOf(result, result.length);
                maxNumOfWin = sum;
            }
            return;
        }
        
        for(int i=start; i<n; i++) {
            if(!visited[i]) {
                visited[i] = true;
                result[p] = i+1;
                combination(p+1, i+1, result, dice);
                visited[i] = false;
            }
        }
    }
    
    public int[] solution(int[][] dice) {
        n = dice.length;
        visited = new boolean[n];
        answer = new int[n/2];
        combination(0, 0, new int[n/2], dice);
        return answer;
    }
}