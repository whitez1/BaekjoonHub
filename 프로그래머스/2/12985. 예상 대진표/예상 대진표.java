import java.util.*;
class Solution
{
    public int solution(int n, int a, int b)
    {     
        int answer = 0;
        int k = (int) (Math.log((double)n) / Math.log(2.0));
        int plus = (int) (Math.pow(2, k+1) - Math.pow(2, k) - 1.0);
        System.out.println(plus);
        a += plus;
        b += plus;
        while(true) {
            if(a==b) {break;}
            answer++;
            if(a%2==0) {
                a = (int) a/2;
            } else {
                a = (int) (a-1)/2;
            }
            
            if(b%2==0) {
                b = (int) b/2;
            } else {
                b = (int) (b-1)/2;
            }   
        }

        return answer;
    }
}