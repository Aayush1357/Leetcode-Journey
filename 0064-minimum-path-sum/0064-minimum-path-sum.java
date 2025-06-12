class Solution {
    public int minPathSum(int[][] grid) {

        int m = grid.length;
        int n = grid[0].length;
        
        int[][] dp = new int[m][n];

        for(int[] row:dp){
            Arrays.fill(row , -1);
        }

        return f(m-1 , n-1  ,grid , dp);

    }

    public static int f(int i , int j , int[][] grid , int[][]dp){

        if(i == 0 && j == 0){
            return grid[0][0];
        }


        if(i < 0 || j <0) return Integer.MAX_VALUE;

        if(dp[i][j] != -1) return dp[i][j];


        int up = f(i-1, j, grid , dp);
        int left = f(i,j-1,grid , dp);

        return dp[i][j] = grid[i][j] + Math.min(up , left);
    }

    // public static int tabulation(int[][] grid){

    //     int m = grid.length;
    //     int n = grid[0].length;
        
    //     int[][] dp = new int[m][n];

    //     for(int i=0;i<m;i++){
    //         for(int j=0;j<n;j++){

    //             if(i == 0 && j ==0){
    //                 dp[0][0] = grid[i][j];
    //                 continue;
    //             }

    //             int up = Integer.MAX_VALUE , left = Integer.MAX_VALUE;

    //             if(i > 0) up = dp[i-1][j];
    //             if(j > 0) left = dp[i][j-1];

    //             dp[i][j] = grid[i][j] + Math.min(up , left);
    //         }
    //     }

    //     return dp[m-1][n-1];
    // }
}