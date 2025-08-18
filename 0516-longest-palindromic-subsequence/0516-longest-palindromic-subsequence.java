class Solution {
    public int longestPalindromeSubseq(String s) {

        int n = s.length();
        int[][] dp = new int[n][n];

        for(int[] r : dp){
            Arrays.fill(r, -1);
        }

        return f(0 , n-1 , s , dp);
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