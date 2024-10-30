import java.util.*;

class Node {
    public String name;
    public int proceeds;
    public Node parent;
    
    public Node(String name, int proceeds, Node parent) {
        this.name = name;
        this.proceeds = proceeds;
        this.parent = parent;
    }
}

class Solution {
    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        int[] answer = new int[enroll.length];
        HashMap<String, Node> map = new HashMap<>();
        
        Node root = new Node("-", 0, null);
        map.put("-", root);
        
        for (int i=0; i<amount.length; i++) amount[i] *= 100;
        
        for (int i = 0; i<enroll.length; i++) {
            Node node = new Node(enroll[i], 0, null);
            map.put(enroll[i], node);
        }
        
        for (int i = 0; i<enroll.length; i++) {
            Node node = map.get(enroll[i]);
            node.parent = map.get(referral[i]);
        }
        
        for (int i = 0; i<seller.length; i++) {
            Node node = map.get(seller[i]);
            
            while (node != root) {
                
                int share = (int) (amount[i]*0.1);
                node.proceeds += (amount[i] - share);
                if (share < 1) break;
                amount[i] = share;
                node = node.parent;
            }
        }
        
        for (int i=0; i<enroll.length; i++) {
            answer[i] = map.get(enroll[i]).proceeds;
        }
        
        return answer;
    }
}