class Solution {
    public int[] countOfPairs(int n, int x, int y) {

        int[][] matrix = new int[n+1][n+1];

        for (int i = 1; i <= n; i++) {
            Arrays.fill(matrix[i] , (int)1e9);
            matrix[i][i] = 0;
            if(i < n) matrix[i][i+1] = 1;
            if(i > 1) matrix[i][i-1] = 1;
        }
        matrix[x][y] = 1;
        matrix[y][x] = 1;

        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++) {
                for (int j =1 ; j <= n; j++) {
                    if(matrix[i][k] != (int)1e9 && matrix[k][j] != (int)1e9){
                        matrix[i][j] = Math.min(matrix[i][j], matrix[i][k] + matrix[k][j]);
                    }
                }
                    
            }
        }

        int[] ans = new int[n];

        for (int i = 1; i <= n; i++) {
            for (int j = i+1; j <= n; j++) {
                if (matrix[i][j] == (int)(1e9)) {
                    matrix[i][j] = 0;
                }else{
                    int v = matrix[i][j];
                    ans[v-1] += 2;
                }
            }
        }

        return ans;
    }
}