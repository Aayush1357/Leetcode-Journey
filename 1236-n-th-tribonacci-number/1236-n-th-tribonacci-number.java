class Solution {
    public int tribonacci(int n) {

        if(n == 0) return 0;
        if(n == 1 || n == 2) return 1;
        int[] dp = new int[n+1];
        Arrays.fill(dp , -1);

        return f(n , dp);

    }

    
    public static int f(int n , int[] dp){


        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 1;

        if(dp[n] != -1){
            return dp[n];
        }

        return dp[n] = f(n-1 , dp) + f(n-2 , dp) + f(n-3  , dp);
    }
}