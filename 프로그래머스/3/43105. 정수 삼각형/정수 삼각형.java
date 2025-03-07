import java.util.*;
import java.util.stream.*;
class Solution {
    public int solution(int[][] triangle) {
        int answer = 0;
        int n = triangle.length;
        
        for(int i = 1; i<n; i++) {
            for(int j = 0; j<=i; j++) {
                int l = j-1;
                int r = j;
                int tmp = triangle[i][j];
                if (l>=0 && l<=i-1) {
                    triangle[i][j] = Math.max(triangle[i-1][l]+tmp, triangle[i][j]);
                }
                if (r>=0 && r<=i-1) {
                    triangle[i][j] = Math.max(triangle[i-1][r]+tmp, triangle[i][j]);
                }
            }
        }
        
        int[] candidate = triangle[n-1];
        System.out.println(Arrays.toString(candidate));
        List<Integer> list = Arrays.stream(candidate)
                           .mapToObj(x -> Integer.valueOf(x))
                           .collect(Collectors.toCollection(ArrayList<Integer>::new));

        return Collections.max(list);
    }
}