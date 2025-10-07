import java.util.*;
class Solution {
    
    public int[] splitDate(String date) {
        int[] result = new int[3];
        result[0] = Integer.parseInt(date.substring(0, 4));
        result[1] = Integer.parseInt(date.substring(5, 7));
        result[2] = Integer.parseInt(date.substring(8, 10));
        return result;
    }
    
    public int[] solution(String today, String[] terms, String[] privacies) {
        int[] answer = {};
        List<Integer> answerList = new ArrayList<>();
        int[] t = splitDate(today);
        
        Map<String, Integer> map = new HashMap<>();
        for(String term : terms) {
            String[] te = term.split(" ");
            map.put(te[0], Integer.parseInt(te[1]));
        }
        
        for(int i=0; i<privacies.length; i++) {
            String[] pri = privacies[i].split(" ");
            int[] pt = splitDate(pri[0]);
            int term = map.get(pri[1]);
            
            int cy = pt[0];
            int cm = pt[1];
            int cd = pt[2];
            
            int totalDays = term * 28 - 1;
            cd += totalDays;
       
            cm += (cd / 28);
            if(cd%28 == 0) {cd = 28; cm -= 1;}
            else cd %= 28;
                
            cy += (cm / 12);
            if(cm%12 == 0) {cm = 12; cy -=1;}
            else cm %= 12;
                        
            if(cy<t[0] || (cy==t[0] && cm<t[1]) || (cy==t[0] && cm==t[1] && cd<t[2])) {
                answerList.add(i+1);
            }
        }
        
        return answerList.stream().mapToInt(Integer::valueOf).toArray();
    }
}