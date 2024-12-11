import java.util.*;
class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        
        Queue<Integer> q = new ArrayDeque<>();
        
        for (int i = 0; i < progresses.length; i++) {
            int day = (int) Math.ceil((double)(100 - progresses[i]) / speeds[i]);
            q.add(day);
        }
        
        int key = q.poll();
        List<Integer> list = new ArrayList<>();
        int num = 1;
        while(!q.isEmpty()) {
            int day = q.poll();
            if (day <= key) {
                num++;
                
            } else {
                list.add(num);
                key = day;
                num = 1;
            }
        }
        list.add(num);
        
        int[] answer = new int[list.size()];
        for(int i=0; i<list.size(); i++) {
            answer[i] = list.get(i);
        }
    
        return answer;
    }
}