class Solution {
    public long maximumImportance(int n, int[][] roads) {


        List<List<Integer>> adj = new ArrayList<>();

        int[][] cnt = new int[n][2];
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
            cnt[i][1] = i;
        }

        for(int i=0;i<roads.length;i++){

            int u = roads[i][0];
            int v = roads[i][1];
            adj.get(u).add(v);
            adj.get(v).add(u);
            cnt[u][0]++;
            cnt[v][0]++;
        }

        Arrays.sort(cnt , (a,b) -> Integer.compare(b[0] , a[0]));

        int[] c = new int[n];
        for(int i=n;i>0;i--) c[cnt[n-i][1]] = i;

        long ans = 0;
        for(int i=0;i<n;i++){    
            ans += dfs(i , adj , c);
        }
        return ans/2;
    }

    public static long dfs(int node  ,  List<List<Integer>> adj , int[] c){

        long a = 0;
        for(int adjNode : adj.get(node)){
            a += c[node] + c[adjNode];
        }

        return a;
    }
}