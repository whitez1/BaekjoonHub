import java.util.*;
import java.util.stream.*;
class Solution {
    public int[] solution(String s) {
        int[] answer = {};
        s = s.replace("{", "");
        s = s.replace("}", "");
        String[] nums = s.split(",");
        HashMap<Integer, Integer> map = new HashMap<>();
        for(String e : nums) {
            int key = Integer.parseInt(e);
            map.put(key, map.getOrDefault(key, 0) + 1);
        }
        ArrayList<Integer> keys = new ArrayList<>(map.keySet());
        Collections.sort(keys, (o1, o2) -> map.get(o2).compareTo(map.get(o1)));
        
        return keys.stream().mapToInt(x->x).toArray();
    }
}