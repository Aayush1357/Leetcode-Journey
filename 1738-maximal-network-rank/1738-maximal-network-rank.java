class Solution {
    public int maximalNetworkRank(int n, int[][] roads) {

        int[] degree = new int[n];

        boolean[][] adj = new boolean[n][n];

        for(int i=0;i<roads.length;i++){
            int u = roads[i][0];
            int v = roads[i][1];

            adj[u][v] = true;
            adj[v][u] = true;
            degree[u]++;
            degree[v]++;

        }

        int max = 0;
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){

                int v = degree[i] + degree[j];
                
                if(adj[i][j]){
                    v--;
                }

                max = Math.max(max , v);
            }
        }

        return max;
    }
}