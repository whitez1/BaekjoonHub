import java.util.*;
import static java.util.stream.Collectors.*;
class Solution {
    public String solution(String[] participant, String[] completion) {
        
        String answer = "";
        Map<String, Long> comMap = Arrays.stream(completion)
                                            .collect(
                                            groupingBy(d -> d, counting()));
        
        for (String par : participant) {
            if (!comMap.containsKey(par)) {
                answer = par;
                break;
            }
            comMap.put(par, comMap.get(par)-1);
            if (comMap.get(par) == 0) 
                comMap.remove(par);
        }
        return answer;
    }
}