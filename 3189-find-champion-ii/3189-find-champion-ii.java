class Solution {
    public int findChampion(int n, int[][] edges) {

        int[] in = new int[n];

        for(int i=0;i<edges.length;i++){
            int u = edges[i][0];
            int v = edges[i][1];

            in[v]++;
        }

        int ans = -1;
        for(int i=0;i<n;i++){
            if(in[i] > 0) continue;
            if(in[i] == 0 && ans == -1){
                ans = i;
            }else{
                return -1;
            }
        }

        return ans;
    }
}