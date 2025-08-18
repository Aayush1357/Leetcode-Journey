class Solution {
    public int change(int amount, int[] coins) {

        int n = coins.length;

        int[][] dp = new int[n][amount+1];
        for(int[] r : dp){
            Arrays.fill(r , -1);
        }

        return f(0 , amount , coins , dp);
    }

    public int f(int i , int t , int[] coins , int[][] dp){

        if(i >= coins.length){
            return 0;
        }

        if(t == 0){
            return 1;
        }else if(t < 0) return 0;

        if(dp[i][t] != -1) return dp[i][t];

        int ta = f(i , t - coins[i] , coins , dp);
        int nt = f(i+1 , t , coins , dp);

        return dp[i][t] = ta+nt;
    }
}