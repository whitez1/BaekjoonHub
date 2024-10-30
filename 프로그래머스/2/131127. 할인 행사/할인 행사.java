import java.util.*;
class Solution {
    
    private static final HashMap<String, Integer> want_map = new HashMap<>();
    private static HashMap<String, Integer> dis_map = new HashMap<>();
    
    private static boolean isValidDate(String[] want) {
        for (String key : want) {
            if (want_map.get(key) > dis_map.get(key)) return false;
        }
        return true;
    }
    
    private static void init_dis_map(String[] want) {
        for (int i=0; i<want.length; i++) {
            dis_map.put(want[i], 0);
        }
    }
    
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        for (int i=0; i<want.length; i++) {
            want_map.put(want[i], number[i]);
            dis_map.put(want[i], 0);
        }
        
        int cnt = 1;
        for (int i=0; i<discount.length; i++) {
            init_dis_map(want);
            int end = (i+10)<discount.length? (i+10):discount.length;
            
            for (int j=i; j<end; j++) {
                String s = discount[j];
                if (want_map.containsKey(s)) {
                    dis_map.put(s, dis_map.get(s)+1);
                }
            }
            
            if (isValidDate(want)) {
                answer += 1;
            }
           
        }
        return answer;
    }
}