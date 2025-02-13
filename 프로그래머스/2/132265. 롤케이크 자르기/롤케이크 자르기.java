import java.util.*;
class Solution {
    public int solution(int[] topping) {
        int answer = 0;
        int n = topping.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int t : topping) {
            map.put(t, map.getOrDefault(t, 0) + 1);
        }
        HashSet<Integer> set = new HashSet<>();
        for(int i=0; i<n; i++) {
            int key = topping[i];
            set.add(key);
            map.put(key, map.get(key)-1);
            if(map.get(key) == 0) {
                map.remove(key);    
            }
            if(set.size() == map.size()) {
                    answer++;
            }
        }
        
        return answer;
    }
}