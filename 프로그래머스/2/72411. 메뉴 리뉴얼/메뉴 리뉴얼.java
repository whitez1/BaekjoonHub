import java.util.*;
import java.util.stream.*;
class Solution {
    
    public void generateSubSet(int idx, String order, boolean[] isSelected, HashMap<HashSet<Character>, Integer> menuCount, HashMap<Integer, Integer> lenMaxCount) {
        if(idx == order.length()) {
            HashSet<Character> courseMenu = new HashSet<>();
            for(int i=0; i<order.length(); i++) {
                if(isSelected[i]){
                    courseMenu.add(order.charAt(i));
                }
            }
            int len = courseMenu.size();
            if(len >= 2) {
                int count = menuCount.getOrDefault(courseMenu, 0) + 1;
                menuCount.put(courseMenu, count);
                if(lenMaxCount.containsKey(len)) {
                    if(count>lenMaxCount.get(len)) {
                        lenMaxCount.put(len, count);
                    }
                } else {
                    lenMaxCount.put(len, count);
                }
            }
            return;
        }
        
        isSelected[idx] = false;
        generateSubSet(idx + 1, order, isSelected, menuCount, lenMaxCount);
        
        isSelected[idx] = true;
        generateSubSet(idx + 1, order, isSelected, menuCount, lenMaxCount);
    }
    
    
    public String[] solution(String[] orders, int[] course) {
        
        HashMap<HashSet<Character>, Integer> menuCount = new HashMap<>();
        HashMap<Integer, Integer> lenMaxCount = new HashMap<>();
        
        for(String order: orders) {
            boolean[] isSelected = new boolean[order.length()];
            generateSubSet(0, order, isSelected, menuCount, lenMaxCount);
        }
        
        HashSet<Integer> courseSet = new HashSet<>();
        for(int c: course) {
            courseSet.add(c);
        }
        
        ArrayList<String> list = new ArrayList<>();
    
        for(HashSet<Character> key: menuCount.keySet()) {
            if (menuCount.get(key) >= 2) {
                if(menuCount.get(key) == lenMaxCount.get(key.size()) && courseSet.contains(key.size())) {
                    StringBuilder sb = new StringBuilder();
                    key.stream().sorted((x, y) -> Character.compare(x,y)).forEach(x->{sb.append(x);});
                    list.add(sb.toString());
                }
            }
        }
        
        String[] answer = list.stream().sorted((x, y) -> x.compareTo(y)).toArray(String[]::new);
        return answer;
    }
}