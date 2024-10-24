class Solution {
    public int[][] solution(int[][] arr1, int[][] arr2) {
        int[][] answer = new int[arr1.length][arr2[0].length];
        int e;
        for(int i=0; i<arr1.length; i++){
            
            for(int k=0; k<arr2[0].length; k++){
                e = 0;
                for(int j=0; j<arr1[0].length; j++){
                    e += arr1[i][j] * arr2[j][k];
                }
                answer[i][k] = e;
            }
        }
        return answer;
    }
}