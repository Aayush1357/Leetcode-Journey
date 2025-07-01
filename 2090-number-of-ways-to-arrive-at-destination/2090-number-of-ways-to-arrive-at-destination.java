class Solution {
    public int countPaths(int n, int[][] roads){
        ArrayList<ArrayList<long[]>> adj = new ArrayList<>();

        for (int i = 0; i < n; i++) adj.add(new ArrayList<>());
        for (int i = 0; i < roads.length; i++) {
            int from = roads[i][0];
            int to = roads[i][1];
            long wt = roads[i][2]; 
            adj.get(from).add(new long[]{to, wt});
            adj.get(to).add(new long[]{from, wt});
        }

        long mod = (long) 1e9 + 7;

        long[] dist = new long[n];
        long[] ways = new long[n];
        for (int i = 0; i < n; i++) {
            dist[i] = Long.MAX_VALUE;
            ways[i] = 0;
        }

        PriorityQueue<long[]> pq = new PriorityQueue<>((x, y) -> Long.compare(x[0], y[0]));

        pq.add(new long[]{0, 0});
        dist[0] = 0;
        ways[0] = 1;

        while (!pq.isEmpty()) {
            long[] data = pq.remove();
            long node = data[1];
            long distance = data[0];

            for (long[] e : adj.get((int) node)) {
                long adjNode = e[0];
                long wt = e[1];

                long updatedDistance = wt + distance;

                if (updatedDistance < dist[(int) adjNode]) {
                    dist[(int) adjNode] = updatedDistance;
                    pq.add(new long[]{updatedDistance, adjNode});
                    ways[(int) adjNode] = ways[(int) node];
                } else if (updatedDistance == dist[(int) adjNode]) {
                    ways[(int) adjNode] = (ways[(int) adjNode] + ways[(int) node]) % mod;
                }
            }
        }

        return (int) (ways[n - 1] % mod);

    }
}