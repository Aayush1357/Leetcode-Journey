class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {


        ArrayList<ArrayList<int[]>> adj = new ArrayList<>();
        for(int i=0;i<=n;i++) adj.add(new ArrayList<int[]>());

        for(int i=0;i<times.length;i++){
            adj.get(times[i][0]).add(new int[]{times[i][1] , times[i][2]});
        }
                
        int[] dist = new int[n+1];
        for(int i=1;i<=n;i++){
            dist[i] = (int)1e9;
        }

        Queue<int[]> pq = new LinkedList<>();
        pq.add(new int[]{0,k});
        dist[k] = 0;
        dist[0] = 0;
         
        while(!pq.isEmpty()){
            int[] data = pq.remove();
            int distance = data[0];
            int node = data[1];


            for (int[] p: adj.get(node)){

                int adjNode = p[0];
                int d = p[1];

                if(d + distance < dist[adjNode] ){
                    dist[adjNode] = d + distance;
                    pq.add(new int[]{dist[adjNode] ,adjNode});
                }
            }
        }

        int ans = Integer.MIN_VALUE;
        for(int i=1;i<=n;i++){
            if(dist[i] == (int)1e9) return -1;
            ans = Math.max(ans , dist[i]);
        }
        return ans;
    }
}