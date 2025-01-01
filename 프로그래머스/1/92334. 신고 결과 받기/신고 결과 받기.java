import java.util.*;
import java.util.stream.*;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        
        List<String[]> distinct_report = Arrays.stream(report).distinct().map(x -> x.split(" ")).collect(Collectors.toList());
        
        HashMap<String, Integer> reported_users = new HashMap<>();
        
        for(String[] users: distinct_report) {
            reported_users.put(users[1], reported_users.getOrDefault(users[1], 0) + 1);
        }
        
        HashMap<String, Integer> reporting_users = new HashMap<>();
        
        for(String user: id_list) {
            reporting_users.put(user, 0);
        }
        
        for(String[] users: distinct_report) {
            if(reported_users.get(users[1]) >= k) {
                reporting_users.put(users[0], reporting_users.get(users[0]) + 1);
            }
        }
        
        int len = id_list.length;
        int[] answer = new int[len];
        for(int i=0 ; i<len; i++) {
            answer[i] = reporting_users.get(id_list[i]).intValue();
        }
        
        return answer;
    }
}