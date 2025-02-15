import java.util.*;
class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        int total = brown + yellow;
        int rt = (int) Math.sqrt(total);
        int width = total/rt;
        int height = rt;
        while(total%rt != 0 || (width-2)*(height-2)!=yellow) {
            rt -= 1;
            width = total/rt;
            height = rt;
        } 
        answer[0] = width;
        answer[1] = height;
       
        return answer;
    }
}