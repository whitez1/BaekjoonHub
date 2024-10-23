import java.util.*;
class Solution {
    public int[] solution(int[] answers) {
        ArrayList<Integer> answer = new ArrayList<>();
        int[] person1 = {1, 2, 3, 4, 5};
        int[] person2 = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] person3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        
        int[] cnt = new int[3];
        for (int i = 0; i < answers.length; i++){
            if (answers[i] == person1[i%person1.length]) {cnt[0]++;}
            if (answers[i] == person2[i%person2.length]) {cnt[1]++;}
            if (answers[i] == person3[i%person3.length]) {cnt[2]++;}
        }
        
        int max_cnt = 0;
        for(int k=0; k<cnt.length; k++){
            if (cnt[k]>max_cnt){
                max_cnt = cnt[k];
            }
        }
        
        for(int j=0; j<cnt.length; j++){
            if (cnt[j] == max_cnt){
                answer.add(j+1); 
            }
        }
        
        return answer.stream().sorted().mapToInt(Integer::intValue).toArray();
    }
}