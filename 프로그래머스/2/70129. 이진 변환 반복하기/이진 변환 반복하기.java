class Solution {
    public int[] solution(String s) {
        int[] answer = new int[2];
        while(!s.equals("1")) {
            int pre = s.length();
            s = s.replace("0", "");
            int cur = s.length();
            answer[1] += (pre - cur);
            s = Integer.toBinaryString(cur);
            answer[0] += 1;
        }
        return answer;
    }
}