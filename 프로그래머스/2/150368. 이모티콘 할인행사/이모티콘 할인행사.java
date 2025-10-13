import java.util.*;
class Solution {
    
    int[] answer = new int[]{-1, -1};
    
    public void findDiscountRate(int r, int[] result, int[][] users, int[] emoticons) {
        
        if(r == emoticons.length) {
            int emoPlus = 0;
            int emoPrice = 0;
            for(int i=0; i<users.length; i++) {
                int dis = users[i][0];
                int price = users[i][1];
                int totalPrice = 0;
                for(int j=0; j<emoticons.length; j++) {
                    if(result[j] >= dis)
                        totalPrice += emoticons[j] * (100-result[j]) / 100;
                }
                if(totalPrice >= price) {
                    emoPlus += 1;
                } else {
                    emoPrice += totalPrice;
                }
            }
                  
            if(emoPlus > answer[0]) {
                answer[0] = emoPlus;
                answer[1] = emoPrice;
            } else if (emoPlus == answer[0]) {
                if(emoPrice > answer[1]) {
                    answer[1] = emoPrice;
                }
            }
            return;
        }
        
        for(int i=40; i>=10; i-=10) {
            result[r] = i;
            findDiscountRate(r+1, result, users, emoticons);
        }
    }
    
    public int[] solution(int[][] users, int[] emoticons) {
        findDiscountRate(0, new int[emoticons.length], users, emoticons);
        return answer;
    }
}