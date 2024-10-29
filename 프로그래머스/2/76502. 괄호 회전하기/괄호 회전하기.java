import java.util.*;

class Solution {
    
    private static final HashMap<Character, Character> map = new HashMap<>();
    
    private static void initHashMap() {
        map.put('(', ')');
        map.put('[', ']');
        map.put('{', '}');
    }
    
    private static Stack<Character> stack = new Stack<>();
    
    private static boolean isValidParen(String s) {
        initHashMap();
        char[] cArr = s.toCharArray();
        for (char c : cArr) {
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            } else {
                if (stack.isEmpty()) return false;
                else {
                    char left = stack.pop();
                    if (map.get(left) != c) return false; 
                }
            }
        }
        return stack.isEmpty();
    }
    
    public int solution(String s) {
        
        int answer = 0;
        StringBuilder sb = new StringBuilder(s);
        
        for (int i=0; i<s.length(); i++) {
            if (isValidParen(sb.toString())) answer += 1;
            char a = sb.charAt(0);
            sb.append(a);
            sb.deleteCharAt(0);
        }
        
        return answer;
    }
}