import java.util.*;
class Solution {
    public String solution(String[] cards1, String[] cards2, String[] goal) {
          
        ArrayDeque<String> cq1 = new ArrayDeque<>(Arrays.asList(cards1));   
        ArrayDeque<String> cq2 = new ArrayDeque<>(Arrays.asList(cards2));
        ArrayDeque<String> gq = new ArrayDeque<>(Arrays.asList(goal));
        
       
    
        while (!gq.isEmpty()) {
            
            if (!cq1.isEmpty() && gq.peekFirst().equals(cq1.peekFirst())) {
                cq1.pollFirst();
                gq.pollFirst();
            } 
            else if (!cq2.isEmpty() && gq.peekFirst().equals(cq2.peekFirst())) {
                cq2.pollFirst();
                gq.pollFirst();
            }                
            else {
                return "No";
            }   
        }
                
        return "Yes";
  
    }
}