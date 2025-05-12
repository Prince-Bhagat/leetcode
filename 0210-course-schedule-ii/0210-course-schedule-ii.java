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
            recursionDfsReverse(i,list);
        }
        return list;

    }

    public void recursionDfsReverse(int source, List<Integer> result){

        if(visited[source] == 1 || isCycleExist){
            isCycleExist = true;
            result.clear();
            return;
        }
        if(visited[source] == 2) return ;

        visited[source] = 1;
        List<Integer> listOfNeighbour = getNeighbours(source, edges);
        if (!listOfNeighbour.isEmpty()){
            for (int neighbour : listOfNeighbour){
                recursionDfsReverse(neighbour, result);
            }
        }
        result.add(source);
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
        List<Integer> result  = topologicalSort.getOrder();
        int [] finalRes = new int[result.size()];
        for(int i=0; i< result.size();i++){
            finalRes[i] = result.get(i);
        }
        return finalRes;
    }
}