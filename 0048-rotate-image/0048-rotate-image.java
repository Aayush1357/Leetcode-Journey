class Solution {
    public void rotate(int[][] matrix) {
        

        int n = matrix.length;
        int[][] ans = new int[n][n];

        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        for(int i=0;i<n;i++){
            reverse(matrix , i);
        }
        // // TC - O(2* N^2)
        // // SC - O(N^2)
        // for(int i=0;i<n;i++){
        //     for(int j=0;j<n;j++){
        //         ans[j][n-1-i] = matrix[i][j];
        //     }
        // }


        // for(int i=0;i<n;i++){
        //     for(int j=0;j<n;j++){
        //         matrix[i][j] = ans[i][j];
        //     }
        // }
        
    }

    public static void reverse(int[][] matrix , int ind){
        int l = 0;
        int r = matrix.length-1;

        while(l < r){
            int temp = matrix[ind][l];
            matrix[ind][l] = matrix[ind][r];
            matrix[ind][r] = temp;

            l++;
            r--;
        }
    }
}