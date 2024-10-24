import java.util.*;
class Solution {
    public int[] solution(int N, int[] stages) {
        
        int[] stageCnt = new int[N+2];
        for(int i=0; i<stages.length; i++){
            stageCnt[stages[i]] += 1; 
        }
        
        int total = stages.length;
        HashMap<Integer, Double> map = new HashMap<>();
        for(int i=1; i<N+1; i++){
            if (stageCnt[i] == 0) {
                map.put(i, 0.);
            }
            else{
                map.put(i, (double) stageCnt[i]/total);
            }
            total -= stageCnt[i];
        }
        
        return map.entrySet().stream().sorted((o1, o2) -> Double.compare(o2.getValue(), o1.getValue())).mapToInt(x -> x.getKey()).toArray();
    }
}