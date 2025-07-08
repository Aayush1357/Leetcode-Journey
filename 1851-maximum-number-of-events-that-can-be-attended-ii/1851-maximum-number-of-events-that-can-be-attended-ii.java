class Solution {
    public int maxValue(int[][] events, int k) {

        Arrays.sort(events , (a,b) -> a[0] - b[0]);

        int n = events.length;

        dp = new int[k+1][n];
        for(int[] r : dp){
            Arrays.fill(r , -1);
        }

        return f(0 , events , k);
    }

    private static int[][] dp;

    public static int f(int i , int[][] events , int k){

        if(k == 0 || i >= events.length){
            return 0;
        }

        if(dp[k][i] != -1){
            return dp[k][i];
        }

        int start = events[i][0] , end = events[i][1] , val = events[i][2];


        int ind = binary(i+1 , end , events);
        int t = val + f(ind , events , k-1);

        int nt = f(i+1 , events , k);

        return dp[k][i] = Math.max(t , nt);  
    }

    public static int binary(int i, int e , int[][] ev){

        int l= i , r = ev.length;

        while(l < r){
            int m = (l + r)/2;
            int s = ev[m][0];

            if(e >= s){
                l = m+1;
            }else{
                r = m;
            }
        }

        return l;
    }
}