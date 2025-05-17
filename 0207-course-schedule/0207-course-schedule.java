class Solution {
    int [] nodeArray;
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        nodeArray = new int[numCourses]; // 0 : Not Visited, 1: Visted and in progresses, 2 Visited and completed
        for (int i = 0; i < numCourses; i++) {
            boolean isSuccessDFS = dfs(prerequisites,i);
            if (!isSuccessDFS) return isSuccessDFS;

        }
        return true;
    }

    private boolean dfs(int[][] prerequisites, int i) {
        if(nodeArray[i]== 2) return true;
        if(nodeArray[i] == 1) return false;

        nodeArray[i] = 1;
        for (int [] edge : prerequisites){
            int start = edge[1];
            int end = edge[0];
            if(start== i){
                boolean isSuccessfull = dfs(prerequisites,end);
                if(!isSuccessfull) return false;
            }
        }
        nodeArray[i] = 2;
        return true;
    }
}