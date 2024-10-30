import java.util.*;
class Solution {
    
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        
        HashMap<String, Integer> want_map = new HashMap<>();
        for (int i=0; i<want.length; i++) {
            want_map.put(want[i], number[i]);
        }
        
        int cnt = 1;
        for (int i=0; i<discount.length-9; i++) {
            HashMap<String, Integer> dis_map = new HashMap<>();
            
            for (int j=i; j<i+10; j++) {
                String s = discount[j];
                if (want_map.containsKey(s)) 
                    dis_map.put(s, dis_map.getOrDefault(s, 0)+1);
            }
            
            if (want_map.equals(dis_map)) 
                answer += 1;
        }
        return answer;
    }
}