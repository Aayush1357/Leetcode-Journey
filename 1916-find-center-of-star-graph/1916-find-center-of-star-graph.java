class Solution {
    public int findCenter(int[][] edges) {

        int n = edges.length + 1;
        int[] graph = new int[n+1];

        for(int i=0;i<n-1;i++){
            int from  = edges[i][0];
            int to = edges[i][1];

            graph[from]++;
            graph[to]++;
        }

        int ans = 0;
        for(int i=0;i<=n;i++){
            if(graph[i] == edges.length) ans = i;
        }

        return ans;
    }
}