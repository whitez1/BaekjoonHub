import java.util.*;
import java.util.stream.*;
class Solution {
    public String solution(int[] numbers) {
        String[] strNumbers = Arrays.stream(numbers).mapToObj(x -> String.valueOf(x)).toArray(String[]::new);
        Arrays.sort(strNumbers, (o1, o2) -> {
            int a = Integer.parseInt(o1 + o2);
            int b = Integer.parseInt(o2 + o1);
            return b-a;
        });
        
        String strNumber = String.join("", strNumbers);
        return strNumber.charAt(0) == '0' ? "0" : strNumber;
    }
}