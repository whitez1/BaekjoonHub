import java.util.*;
class Solution {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        Stack<Integer> stack = new Stack<>();
       
        for (int i = 0; i<prices.length; i++) {
            while (true) {
                
                if (!stack.isEmpty() && prices[i] < prices[stack.peek()]) {
                    int top = stack.peek();
                    answer[top] = i-top;
                    stack.pop();
                } else break;
            }
            stack.push(i);
        }
        
        int top = stack.pop();
        while (!stack.isEmpty()) {
            int k = stack.pop();
            answer[k] = top - k;
        }
        
        return answer;
    }
}