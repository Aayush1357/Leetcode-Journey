class Solution {
    public int longestPalindromeSubseq(String s) {

        int n = s.length();
        int[][] dp = new int[n][n];

        for(int[] r : dp){
            Arrays.fill(r, 0);
        }


        for(int i=n-1;i>=0;i--){
            dp[i][i] = 1;
            for(int j=i+1;j<n;j++){
                if(s.charAt(i) == s.charAt(j)){
                    dp[i][j] = 2 + dp[i+1][j-1];
                }else{
                    dp[i][j] = Math.max(dp[i][j-1] , dp[i+1][j]);
                }
            }
        }
        return dp[0][n-1];
    }

    public static int f(int i , int j , String s , int[][] dp){

        if(i > j){
            return 0;
        }
        if(i == j) return 1;

        if(dp[i][j] != -1) return dp[i][j];

        if(s.charAt(i) == s.charAt(j)){
            return dp[i][j] = 2 + f(i+1 , j-1 , s , dp);
        }

        return dp[i][j] = Math.max(f(i , j-1 , s , dp) , f(i+1 , j ,s , dp));
    }
}