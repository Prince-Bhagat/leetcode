class Solution {

public class UnionFind {
    int [] parents;
    int [] ranks;
    void initParents(int size){
        this.parents = new int[size];
        this.ranks = new int[size];
        for (int i = 0; i < size; i++) {
            this.parents[i] = i;
        }
    }
    private void union(int src, int destination){
        int rootOfSrc = find(src);
        int rootOfDestination = find(destination);
        if(ranks[rootOfSrc] < ranks[rootOfDestination] ){
            parents[rootOfSrc] = rootOfDestination;

        }else if(ranks[rootOfSrc] > ranks[rootOfDestination]){
            parents[rootOfDestination] = rootOfSrc;
        }else{
            parents[rootOfDestination] = rootOfSrc;
            ranks[rootOfSrc]++;
        }
        
    }
    private int find(int node){
        if(node == parents[node]){
            return node;
        }
        return find(parents[node]);
    }
    public boolean checkPathForGraph(int [][] edges, int vertexNumber, int src, int dest){
        this.initParents(vertexNumber);
        for (int i = 0; i < edges.length; i++) {
            union(edges[i][0], edges[i][1]);
        }
        return checkForPathAfterUnion(src,dest);

    }
    private boolean checkForPathAfterUnion(int src, int dest){
        if(parents[src] ==  parents[dest]) return true;
        int srcParent = parents[src];
        int destParent = parents[dest];
        
        while((srcParent != parents[srcParent]) || (destParent != parents[destParent])){
            srcParent = parents[srcParent];
            destParent = parents[destParent];
            if(srcParent ==  destParent) return true;
        }
        return false;
    }
}

    public boolean validPath(int n, int[][] edges, int source, int destination) {
        UnionFind unionFind = new UnionFind();
        return unionFind.checkPathForGraph(edges, n, source, destination);
    }
}