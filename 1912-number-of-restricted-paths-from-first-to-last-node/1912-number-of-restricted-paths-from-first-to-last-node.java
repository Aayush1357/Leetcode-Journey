class Solution {
    private Map<Integer , List<int[]>> adj = new HashMap<>();
    private int mod = 1_000_000_007;

    public int countRestrictedPaths(int n, int[][] edges) {
        
        for(int[] e : edges){
            adj.computeIfAbsent(e[0] , x -> new ArrayList<>()).add(new int[]{e[1] , e[2]});
            adj.computeIfAbsent(e[1] , x -> new ArrayList<>()).add(new int[]{e[0] , e[2]});
        }

        int[] dist = djisktra(adj , n);
        
        Integer[] dp = new Integer[n+1];
        return dfs(1 , n , dist , dp);

    }

    public int dfs(int node , int end , int[] dist , Integer[] dp){
        if(node == end) return 1;

        if(dp[node] != null) return dp[node];

        long res = 0;
        for(int[] neighbor : adj.get(node)){
            int adjNode = neighbor[0];

            if(dist[node] > dist[adjNode]){
                res = res + (dfs(adjNode , end , dist , dp) % mod);
            }
        }

        res = res % mod;
        return dp[node] = (int)res;

    }

    public int[] djisktra(Map<Integer , List<int[]>> adj , int n){

        int[] dist = new int[n+1];
        Arrays.fill(dist , Integer.MAX_VALUE);

        dist[n] = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[1] - b[1]);
        dist[0] = 0;
        pq.offer(new int[]{n , 0});

        while(!pq.isEmpty()){
            int[] e = pq.poll();

            int node = e[0];
            int wt = e[1];

            for(int[] neighbor : adj.get(node)){
                int adjNode = neighbor[0];
                int adjwt = wt + neighbor[1];

                if(adjwt < dist[adjNode]){
                    dist[adjNode] = adjwt;
                    pq.offer(new int[]{adjNode , adjwt});
                }
            }
        }


        return dist;
    }
}