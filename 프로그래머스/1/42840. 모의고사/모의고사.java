import java.util.*;
class Solution {
    public int[] solution(int[] answers) {
       
        int[] person1 = {1, 2, 3, 4, 5};
        int[] person2 = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] person3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        
        int[] scores = new int[3];
        for (int i = 0; i < answers.length; i++){
            if (answers[i] == person1[i%person1.length]) {scores[0]++;}
            if (answers[i] == person2[i%person2.length]) {scores[1]++;}
            if (answers[i] == person3[i%person3.length]) {scores[2]++;}
        }
        
        int max_score = Arrays.stream(scores).max().getAsInt();
        
        ArrayList<Integer> answer = new ArrayList<>();
        for(int j=0; j<scores.length; j++){
            if (scores[j] == max_score){
                answer.add(j+1); 
            }
        }
        
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}