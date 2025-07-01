class Solution {

    public static int[][] dirs = {{0,1},{1,0},{0,-1},{-1,0}};

    public int longestIncreasingPath(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int[][] dp = new int[n][m];
        for(int i=0;i<n;i++){
            Arrays.fill(dp[i] , -1);
        }

        int ans = 0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                ans = Math.max(ans , dfs(matrix , dp , i , j));
            }
        }

        return ans;
    }

    public static int dfs(int[][] matrix , int[][] dp , int r , int c){
        if(dp[r][c] != -1) return dp[r][c];


        int n = matrix.length;
        int m = matrix[0].length;
        int max = 1;

        for(int[] d : dirs){
            int x = r + d[0] , y = c + d[1];

            if(x >= 0 && x <n && y >=0 && y < m && matrix[r][c] < matrix[x][y]){
                max = Math.max(max , 1 + dfs(matrix ,dp , x , y));           
            }
        }

        return dp[r][c] = max;
    }
}