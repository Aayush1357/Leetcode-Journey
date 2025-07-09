class Solution {
    public int coinChange(int[] coins, int amount) {

        int[][] dp = new int[coins.length][amount+1];

        for(int[] row : dp){
            Arrays.fill(row , -1);
        }

        int ans = f(coins , amount,  coins.length-1 , dp);
        if(ans == Integer.MAX_VALUE-1){
            return -1;
        }

        return ans;
    }

    public static int f(int[] coins , int t ,  int n , int[][] dp){

        if (t == 0)
            return 0;
        if (n < 0 || t < 0)
            return Integer.MAX_VALUE - 1;

        if (dp[n][t] != -1) {
            return dp[n][t];
        }

        int inc = f(coins, t - coins[n], n, dp) + 1;

        int exc = f(coins, t, n - 1, dp);

        return dp[n][t] = Math.min(inc, exc);
    }
}