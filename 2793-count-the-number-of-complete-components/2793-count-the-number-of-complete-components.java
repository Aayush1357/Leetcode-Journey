class Solution {
    public int countCompleteComponents(int n, int[][] edges) {

        int[] vis = new int[n];
        int c = 0;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for(int i=0;i<n;i++) adj.add(new ArrayList<>());
        for(int i=0;i<edges.length;i++){
            int u = edges[i][0];
            int v = edges[i][1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }


        for(int i=0;i<n;i++){
            if(vis[i] == 0){
                int[] cc = new int[2];
                dfs(i , vis , adj , cc);

                if(cc[0]* (cc[0] -1) == cc[1]) c++;
            }
        }

        return c;
    }

    public static void dfs(int node , int[] vis , ArrayList<ArrayList<Integer>> adj , int[] cc){

        vis[node] = 1;
        cc[0]++;
        cc[1] += adj.get(node).size();

        for(int adjNode : adj.get(node)){
            
            if(vis[adjNode] == 0){
                dfs(adjNode , vis , adj , cc);
            }
        }

    }
}