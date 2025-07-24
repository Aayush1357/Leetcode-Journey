class Solution {
    public int numDistinct(String s, String t) {

        int[][] dp = new int[s.length()+1][t.length()+1];
        for(int[] row : dp){
            Arrays.fill(row , -1);
        }
        return f(s.length()-1 , t.length()-1 , s , t  , dp);
    }

    public static int  f(int i ,int j ,  String s , String t , int[][] dp){
        if(j < 0) return 1;
        if(i < 0) return 0;


        if(dp[i][j] != -1) return dp[i][j];

        int take = 0;
        if(s.charAt(i) == t.charAt(j)) take = f(i-1 ,j-1 , s , t , dp);
        int ntake = f(i-1 , j, s , t , dp);

        return dp[i][j] = take + ntake;
    }
}