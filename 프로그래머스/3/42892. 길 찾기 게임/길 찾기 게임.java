import java.util.*;
import java.util.stream.*;

class Solution {
    private static class Node {
        int num;
        int[] loc;
        Node leftChild;
        Node rightChild;

        public Node(int num, int[] loc) {
            this.num = num;
            this.loc = loc;
            this.leftChild = null;
            this.rightChild = null;
        }
    }
    
    private static Node makeTree(ArrayList<int[]> tree, HashMap<Integer,Node> nodes) {
        if(tree.isEmpty()) return null;
        
        int[] result = tree.stream()
                    .reduce(new int[]{-1, -1, -1}, (a, x) -> x[2] > a[2] ? new int[]{x[0], x[1], x[2]} : a);

        int maxNum = result[0];
        int pivotX = result[1];
        int maxY = result[2];

        Node node = nodes.get(maxNum);
        
        ArrayList<int[]> leftTree = tree.stream().filter(x -> x[1] < pivotX).collect(Collectors.toCollection(ArrayList::new));
        ArrayList<int[]> rightTree = tree.stream().filter(x -> x[1] > pivotX).collect(Collectors.toCollection(ArrayList::new));
        
        Node leftChild = makeTree(leftTree, nodes);
        Node rightChild = makeTree(rightTree, nodes);
        
        node.leftChild = leftChild;
        node.rightChild = rightChild;
        
        return node;
    }
    
    private static void preorder(Node node, ArrayList<Integer> pre_result) {
        if (node == null) return;
        pre_result.add(node.num);
        preorder(node.leftChild, pre_result);
        preorder(node.rightChild, pre_result);
    }
    
    private static void postorder(Node node, ArrayList<Integer> post_result) {
        if (node == null) return;
        postorder(node.leftChild, post_result);
        postorder(node.rightChild, post_result);
        post_result.add(node.num);
    }
    
    public int[][] solution(int[][] nodeinfo) {
        int[][] answer = new int[2][];
        
        HashMap<Integer, Node> nodes = new HashMap<>();
        ArrayList<int[]> tree = new ArrayList<>();
        int i = 0; 
        while(i < nodeinfo.length) {
            Node node = new Node(i+1, nodeinfo[i]);
            nodes.put(i+1, node);
            
            int[] numInfo = new int[3];
            numInfo[0] = i+1;
            numInfo[1] = nodeinfo[i][0];
            numInfo[2] = nodeinfo[i][1];
            tree.add(numInfo);
            i++;
        }
        
        Node root = makeTree(tree, nodes);
        
        ArrayList<Integer> pre_result = new ArrayList<>();
        ArrayList<Integer> post_result = new ArrayList<>();
        
        preorder(root, pre_result);
        postorder(root, post_result);
        
        int[] pre_array = pre_result.stream().mapToInt(Integer::intValue).toArray();
        int[] post_array = post_result.stream().mapToInt(Integer::intValue).toArray();
        
        answer[0] = pre_array;
        answer[1] = post_array;
    
        return answer;
    }
}