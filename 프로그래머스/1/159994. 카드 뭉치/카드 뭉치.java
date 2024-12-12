import java.util.*;
class Solution {
    public String solution(String[] cards1, String[] cards2, String[] goal) {
          
        Queue<String> q1 = new ArrayDeque<>();
        Arrays.stream(cards1).forEach(x -> q1.add(x));
        
        Queue<String> q2 = new ArrayDeque<>();
        Arrays.stream(cards2).forEach(x -> q2.add(x));
        
        String card1 = q1.poll();
        String card2 = q2.poll();
        for (String word : goal) {
            if (card1.equals(word)) {
                if (!q1.isEmpty())
                    card1 = q1.poll();
            } 
            else if (card2.equals(word)) {
                if (!q2.isEmpty())
                    card2 = q2.poll();
            }                
            else {
                return "No";
            }   
        }
                
        return "Yes";

        
    }
}