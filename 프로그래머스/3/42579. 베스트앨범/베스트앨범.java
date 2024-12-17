import java.util.*;
import java.util.stream.*;
class Solution {
    public int[] solution(String[] genres, int[] plays) {
        
        HashMap<String, ArrayList<int[]>> playByGenre = new HashMap<>();
        HashMap<Integer, String> genreByNum = new HashMap<>();
        
        
        for (int i=0; i<genres.length; i++) {
            ArrayList<int[]> list = playByGenre.getOrDefault(genres[i], new ArrayList<>());
            list.add(new int[]{i, plays[i]});
            playByGenre.put(genres[i], list);
        }
        
        for (String key : playByGenre.keySet()) {
            Integer total = playByGenre.get(key).stream().mapToInt(x -> x[1]).sum();
            genreByNum.put(total, key);
        }
        
        HashMap<String, List<Integer>> playByGenre1 = new HashMap<>();
        for (String key : playByGenre.keySet()) {
            List<Integer> list = playByGenre.get(key).stream().sorted((x, y) -> {
                if (x[1] != y[1])
                    return y[1] - x[1];
                else
                    return x[0] - y[0];
            }).map(x -> x[0]).limit(2).collect(Collectors.toList());
            
            playByGenre1.put(key, list);
        }
        
        
        List<Integer> playBacks = genreByNum.keySet().stream().sorted((x,y)-> y-x).collect(Collectors.toList());
        List<Integer> answer = new ArrayList<>();
        for (Integer playBack : playBacks) {
            String genre = genreByNum.get(playBack);
            answer.addAll(playByGenre1.get(genre));
        }
        
        return answer.stream().mapToInt(i->i).toArray();
    }
}