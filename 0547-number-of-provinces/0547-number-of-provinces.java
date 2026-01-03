class Solution {
    public int findCircleNum(int[][] isConnected) {
        
        int V = isConnected.length;
        return noOfProvinces(V, isConnected);
    }

    public static void dfs(int node , int[] vis,int[][] isConnected){

        vis[node] = 1;
        for(int i=0;i<isConnected.length;i++){
            if(isConnected[node][i] == 1 && vis[i] == 0){
                dfs(i , vis, isConnected);
            }
        }
    }

    public int noOfProvinces(int V , int[][] matrix){

        // ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();
        // for(int i=0;i<=V;i++){
        //     adjList.add(new ArrayList<>());
        // }

        // for(int i=0;i<V;i++){
        //     for(int j=0;j<V;j++){
        //         if(matrix[i][j] == 1 && i !=j){
        //             adjList.get(i+1).add(j+1);
        //             adjList.get(j+1).add(i+1);
        //         }
        //     }
        // }


        int[] vis = new int[V+1];
        Arrays.fill(vis , 0);
        int c = 0;
        for(int i=0;i<V;i++){
            if(vis[i] == 0){
                c++;
                dfs(i , vis, matrix);
            }
        }

        return c;
    }
}