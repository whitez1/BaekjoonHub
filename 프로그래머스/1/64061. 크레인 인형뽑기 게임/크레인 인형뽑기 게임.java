import java.util.*;
class Solution {
    
    static public int grabDoll(int[][] board, int move, int n){
        int doll = 0;
        for(int i=0; i<n; i++){
            doll = board[i][move-1];
            if (doll > 0) {
                board[i][move-1] = 0;
                break;
            }
        }
        return doll;
    }
    
    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        
        Stack<Integer> bascket = new Stack<>();
        int n = board.length;
        
        for(int move: moves){
            int doll = grabDoll(board, move, n);
            
            if (doll == 0)
                continue;
            
            int top = -1;
            if(!bascket.isEmpty()) 
                top = bascket.peek();
    
            if (top == doll) {
                bascket.pop();
                answer += 2;
            } else {
                bascket.push(doll);
            }    
                
        }
        return answer;
    }
}