class Solution {

    private static final int INF = Integer.MAX_VALUE;

    public int largestPathValue(String colors, int[][] edges) {
        
        int n = colors.length();

        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0;i<n;i++) adj.add(new ArrayList<>());
        for(int[] e : edges) adj.get(e[0]).add(e[1]);


        int[] vis = new int[n];
        int[][] cnt = new int[n][26];
        
        int ans = 0;

        for(int i=0;i<n;i++){
            ans = Math.max(ans , dfs(i , colors , adj , cnt , vis));
        }

        return ans == INF ? -1 : ans;
    }

    public static int dfs(int node , String c , List<List<Integer>> adj , int[][] cnt , int[] vis){

        if(vis[node] == 1) return INF;
        if(vis[node] == 2) return cnt[node][c.charAt(node) - 'a'];

        vis[node] = 1;
        for(int next : adj.get(node)){
            int res = dfs(next , c , adj , cnt , vis);

            if(res == INF) return INF;

            for(int i=0;i<26;i++){
                cnt[node][i] = Math.max(cnt[node][i] , cnt[next][i]);
            }
        }

        int col = c.charAt(node) - 'a';
        cnt[node][col]++;

        vis[node] = 2;

        return cnt[node][col];
    }
}