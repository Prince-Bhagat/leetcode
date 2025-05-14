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

    public List<Integer> getOrder(){
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < numberOfVertex; i++) {
            boolean nocycle = recursionDfsReverse(i,list);
            if( !nocycle )break;
        }
        return list;

    }

    public boolean recursionDfsReverse(int source, List<Integer> result){

        if(visited[source] == 1 ){
            isCycleExist= true;
            return false;
        }
        if(visited[source] == 2) return true;

        visited[source] = 1;
        List<Integer> listOfNeighbour = getNeighbours(source, edges);
        if (!listOfNeighbour.isEmpty()){
            for (int neighbour : listOfNeighbour){
                recursionDfsReverse(neighbour, result);
            }
        }
        result.add(source);
        visited[source] = 2;
        return true;

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

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        TopologicalSort topologicalSort = new TopologicalSort(prerequisites,numCourses);
        topologicalSort.getOrder();
        return !topologicalSort.isCycleExist;
    }
}