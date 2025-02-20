import java.util.*;
class Solution {
    int[] Info;
    int maxSum;
    int[] answer;
    void backtrack(int cnt, int start, int[] lion, int num) {
        if(num == 0) {
            int sum = 0;
            for(int i = 0; i<Info.length; i++) {
                if(lion[i]>Info[i]) {
                    sum += 10-i;
                } else if(Info[i]>=lion[i] && !(Info[i]==0 && lion[i]==0)){
                    sum -= (10-i);
                }
            }
            if(sum > 0 && sum >= maxSum) {
                if(sum == maxSum) {
                    for(int i=Info.length-1; i>=0; i--){
                        if(lion[i]>answer[i]){
                            answer = Arrays.copyOf(lion, lion.length);
                            break;
                        } else if(answer[i]>lion[i]){
                            break;
                        }
                    }
                } else {
                    maxSum = sum;
                    answer = Arrays.copyOf(lion, lion.length);
                } 
            }
            return;
        }
        
        for(int i = start; i<Info.length; i++) {
            if(num > Info[i]) {
                lion[i] = Info[i]+1;
                backtrack(cnt+1, i+1, lion, num-(Info[i]+1));
                lion[i] = 0;
            } else if(i==10 && num>0) {
                lion[i] = num;
                backtrack(cnt+1, i+1, lion, 0);
                lion[i] = 0;
            }
        }
    }
    
    public int[] solution(int n, int[] info) {
        Info = info;
        maxSum = -1;
        answer = new int[]{-1};
        backtrack(0, 0, new int[info.length], n);
        return answer;
    }
}