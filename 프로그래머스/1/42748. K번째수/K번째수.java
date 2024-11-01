import java.util.*;
class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        
        for(int i=0; i<commands.length; i++) {
            int[] arr = commands[i];
            int[] cArray = Arrays.copyOfRange(array, arr[0]-1, arr[1]);
            Arrays.sort(cArray);
            answer[i] = cArray[arr[2]-1];
        }
        
        return answer;
    }
}