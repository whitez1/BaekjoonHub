import java.util.*;
class Solution {
    public String[] solution(String[] record) {
        List<String> answer = new ArrayList<>();
        HashMap<String, String> map = new HashMap<>();
        
        for (String r : record) {
            String[] message = r.split(" ");
            if (!r.startsWith("Leave")) {
                map.put(message[1], message[2]);
            }
        }
        
        for (String r : record) {
            String[] message = r.split(" ");
            if (r.startsWith("Enter")) {
                answer.add(map.get(message[1])+"님이 들어왔습니다.");
            } else if (r.startsWith("Leave")) {
                answer.add(map.get(message[1])+"님이 나갔습니다.");
            }
        }
        return answer.toArray(new String[answer.size()]);
    }
}