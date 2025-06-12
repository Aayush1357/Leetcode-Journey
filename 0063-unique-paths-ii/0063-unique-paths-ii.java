class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;

        int[][] dp = new int[m][n];
        for(int[] row : dp){
            Arrays.fill(row , -1);
        }

        return f( obstacleGrid );

    }

    public static int f(int[][] obstacleGrid){

        int n = obstacleGrid.length;
        int m = obstacleGrid[0].length;
        int [][] dp = new int [n][m];
        
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){

                if(i>=0 && j>=0 && obstacleGrid[i][j]==1){
                    dp[i][j] =0;
                    continue;
                }
                if(i==0 && j ==0){
                    dp[i][j] =1;
                    continue;
                }

                if(i<0 || j<0) return 0;
                int le =0;
                int up =0;
                if(i>0) le = dp[i-1][j];
                if(j>0) up = dp[i][j-1];

                dp[i][j]=le+up;
            }
        }
        return dp[n-1][m-1];

    }
}