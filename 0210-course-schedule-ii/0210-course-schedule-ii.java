class Solution {
    public class TopologicalSort {
    int [][] edges;
    int [] visited; // 0 not visited ; 1 visited(still processing); 2 (visited and process)
    boolean isCycleExist;



    public TopologicalSort(int[][] edges, int numberOfVertex) {
        this.edges = edges;
        this.numberOfVertex = numberOfVertex;
        this.visited = new int[numberOfVertex];

    }

    int [] list;
    int index =0;
    public int [] getOrder(){
        list = new int[numberOfVertex];
        for (int i = 0; i < numberOfVertex; i++) {
            recursionDfsReverse(i);
        }
        return list;

    }

    public void recursionDfsReverse(int source){

        if(visited[source] == 1 || isCycleExist){
            isCycleExist = true;
            list = new int[0];
            return;
        }
        if(visited[source] == 2) return ;

        visited[source] = 1;
        List<Integer> listOfNeighbour = getNeighbours(source, edges);
        if (!listOfNeighbour.isEmpty()){
            for (int neighbour : listOfNeighbour){
                recursionDfsReverse(neighbour);
            }
        }
        if(index >= list.length){
            list = new int[0];
            return ;
        }
        list[index] = source;
        index++;
        visited[source] = 2;

    }

    private List<Integer> getNeighbours(int currentNode, int[][] edges) {
        List<Integer> list = new ArrayList<>();
        for (int [] edge : edges){
            if(edge[0] == currentNode){
                list.add(edge[1]);
            }
        }
        return list;
    }
    int numberOfVertex;

}

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        TopologicalSort topologicalSort = new TopologicalSort(prerequisites,numCourses);
        int [] result  = topologicalSort.getOrder();
        return result;
    }
}