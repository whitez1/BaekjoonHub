import java.util.*;
import java.util.stream.*;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        
        HashMap<String, HashSet<String>> reportedUser = new HashMap<>();
        HashMap<String, Integer> count = new HashMap<>();
        
        for(String r: report) {
            String[] s = r.split(" ");
            
            if(!reportedUser.containsKey(s[1])) {
                reportedUser.put(s[1], new HashSet<>());
            } 
            reportedUser.get(s[1]).add(s[0]);
        }
        
        for(Map.Entry<String, HashSet<String>> entry: reportedUser.entrySet()) {
            if(entry.getValue().size() >= k) {
                for (String uid: entry.getValue()) {
                    count.put(uid, count.getOrDefault(uid, 0) + 1);
                }
            } 
        }
        
        int len = id_list.length;
        int[] answer = new int[len];
        for(int i=0 ; i<len; i++) {
            answer[i] = count.getOrDefault(id_list[i], 0);
        }
        
        return answer;
    }
}