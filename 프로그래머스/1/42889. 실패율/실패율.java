import java.util.*;
class Solution {
    public int[] solution(int N, int[] stages) {
        int[] answer = new int[N];
        int[] user_num = new int[N];
        double[][] idx_fail = new double[N][2];
        
        for(int i=0; i<stages.length; i++){
            if (stages[i]>N){continue;}
            user_num[stages[i]-1] += 1; 
        }
        
        double fail;
        int s = stages.length;
        int p = 0;
      
        for(int i=0; i<N; i++){
            if (s-p == 0) {
                fail = 0;
            }    
            else{
                fail = (double) user_num[i]/(s-p);
            }
            
            p += user_num[i];
            idx_fail[i][0] = i+1;
            idx_fail[i][1] = fail;
        }
      
        Arrays.sort(idx_fail, (o1, o2) -> {return Double.compare(o2[1], o1[1]);});
        
        for(int i=0; i<N; i++){
            answer[i] = (int) idx_fail[i][0];
        }
        
        return answer;
    }
}