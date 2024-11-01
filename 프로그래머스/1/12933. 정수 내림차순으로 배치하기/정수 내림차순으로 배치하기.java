import java.util.*;
class Solution {
    public long solution(long n) {
        long answer = 0;
        
        String s = Long.toString(n);
        String[] arr = new String[s.length()];
        
        for(int i=0; i<s.length(); i++) {
            arr[i] = s.charAt(i)+"";
        }
        Arrays.sort(arr, Collections.reverseOrder());
        
        answer = Long.parseLong(String.join("", arr));
        
        return answer;
    }
}