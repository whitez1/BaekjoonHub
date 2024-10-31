import java.util.*;
class Solution {
    public int[] solution(int n, String[] words) { 
        HashMap<String, Integer> map = new HashMap<>();
     
        int i = 0;
        int cnt = 1;
        char last = words[0].charAt(0);
        for (String word: words) {
            int first = word.charAt(0);
            if (last == first && map.get(word) == null){
                map.put(word, i);
            } else return new int[]{i+1, cnt}; 
            
            last = word.charAt(word.length()-1);
            i = (i+1)%n;
            if (i==0) cnt += 1;
        }
        
        return new int[]{0,0};
    }
}