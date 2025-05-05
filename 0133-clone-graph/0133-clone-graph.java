/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node source) {
        if(source ==  null) return null;
        Stack<Integer> stack = new Stack<>();
        Map<Integer,Node> mapOfOldNode = new HashMap<>();
        Map<Integer,Node> mapOfNewNode = new HashMap<>();
        mapOfOldNode.put(source.val, source);

        Node newSource =  new Node(source.val);
        mapOfNewNode.put(source.val,newSource);
        stack.push(source.val);

        while (!stack.empty()){
            int currentVal = stack.pop();
            Node oldNode = mapOfOldNode.get(currentVal);
            Node newNode = mapOfNewNode.get(currentVal);

            for (Node neighbour : oldNode.neighbors){
                Node newNeighbour;
                if(mapOfNewNode.containsKey(neighbour.val)){
                    newNeighbour = mapOfNewNode.get(neighbour.val);
                }else{
                    newNeighbour = new Node(neighbour.val);
                    mapOfNewNode.put(newNeighbour.val, newNeighbour);
                    mapOfOldNode.put(neighbour.val, neighbour);
                    stack.push(neighbour.val);
                }

                newNode.neighbors.add(newNeighbour);
            }
        }
        return newSource;
    }
}