class Solution {

    int MOD = 1000000007;
    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {

        int[][][] dp  = new int[m][n][maxMove+1];
        for (int[][] l : dp){
            for (int[] sl : l){
                Arrays.fill(sl, -1);
            }
        }
        return f(startRow , startColumn,maxMove , m , n , dp);
    }

    public int f(int i , int j ,int N ,  int m , int n , int[][][] dp){


        if(i < 0 || i >= m || j<0 ||j >= n){
            return 1;
        }        
        if(N == 0) return 0;
        
        if(dp[i][j][N] != -1) return dp[i][j][N];

        int u = (f(i-1 , j , N-1, m , n , dp) + f(i+1 , j ,N-1,  m , n , dp)) % MOD;
        int l = (f(i , j-1 ,N-1,  m, n , dp) + f(i , j+1 ,N-1 , m,n , dp)) % MOD;

        return dp[i][j][N] = (u+l) % MOD;
    }
}