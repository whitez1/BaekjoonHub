import java.util.*;
class Solution {
    public long solution(long n) {
        long answer = 0;
        
        String[] sarr = String.valueOf(n).split("");
       
        Arrays.sort(sarr, Collections.reverseOrder());
        
        answer = Long.parseLong(String.join("", sarr));
        
        return answer;
    }
}