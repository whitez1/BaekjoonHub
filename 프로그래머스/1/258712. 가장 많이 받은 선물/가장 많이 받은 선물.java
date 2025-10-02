import java.util.*;
class Solution {
    public int solution(String[] friends, String[] gifts) {
        Map<String, Integer> map = new HashMap<>();
        int n = friends.length;
        for(int i=0; i<n; i++) {
            map.put(friends[i], i);
        }
    
        int[][] table = new int[n][n];
        
        for(String rel : gifts) {
            String[] ab = rel.split(" ");
            table[map.get(ab[0])][map.get(ab[1])] += 1;
        }
        
        int[] numOfgifts = new int[n];
        for(int i=0; i<n; i++) {
            int giv = 0;
            int rec = 0;
            for(int j=0; j<n; j++) {
                giv += table[i][j];
                rec += table[j][i];
            }
            numOfgifts[i] = giv - rec;
        }
        int[] results = new int[n];
        
        for(int i=0; i<n; i++) {
            for(int j=i+1; j<n; j++) {
                if(table[i][j] < table[j][i]) results[j] += 1;
                else if(table[i][j] > table[j][i]) results[i] += 1;
                else {
                    if(numOfgifts[i] > numOfgifts[j]) results[i] += 1;
                    else if(numOfgifts[i] < numOfgifts[j]) results[j] += 1;
                }
            }
        }
        int answer = 0;
        for(int i=0; i<n; i++) {
            answer = Math.max(results[i], answer);
        }
        
        return answer;
    }
}