class Solution {
    public int maximumDetonation(int[][] bombs) {
        int m = bombs.length;

        List<List<Integer>> adj = new ArrayList<>();

        for(int i=0;i<m;i++){
            adj.add(new ArrayList<>());
        }

        for(int i=0;i<m;i++){
            long x1 = bombs[i][0];
            long y1 = bombs[i][1];
            long v = bombs[i][2];

            for(int j=0;j<m;j++){
                if(i == j) continue;

                long x2 = bombs[j][0];
                long y2 = bombs[j][1];

                long dx = x1-x2;
                long dy = y1-y2;
                long dist = dx*dx + dy*dy;
                long rad = v * v;

                if(dist <= rad){
                    adj.get(i).add(j);
                }
            }
        }

        int max = 0;
        for(int i=0;i<m;i++){
            int[] vis = new int[m];
            int v = f(adj , i , vis);
            max = Math.max(max, v);
        }

        return max;
    }

    public static int f(List<List<Integer>> adj, int i , int[] vis){

        vis[i] = 1;
        int c = 1;
        for(int j : adj.get(i)){
            if(vis[j] == 0){
                c += f(adj , j , vis);
            }
        }

        return c;
    }
}