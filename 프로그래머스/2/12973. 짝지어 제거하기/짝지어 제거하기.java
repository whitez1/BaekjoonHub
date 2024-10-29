import java.util.*;
class Solution
{
    public int solution(String s)
    { 
        Stack<Character> stack = new Stack<>();
        for(char c : s.toCharArray()) {
            if (!stack.isEmpty()) {
                if (stack.peek() == c) {
                    stack.pop();
                } else {
                    stack.push(c);
                }
            } else {
                stack.push(c);
            }
        }
        int answer = 0;
        if (stack.isEmpty()) answer = 1;
        return answer;
    }
}