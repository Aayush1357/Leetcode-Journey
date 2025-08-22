class Solution {
    public int minimumArea(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        int x1 = Integer.MAX_VALUE;
        int x2 = Integer.MIN_VALUE;
        int y1 = Integer.MAX_VALUE;
        int y2 = Integer.MIN_VALUE;

        for(int i=0;i<n;i++){
            for(int j = 0;j < m;j++){
                if(grid[i][j] == 1){
                    x1 = Math.min(x1 , i);
                    x2 = Math.max(x2 , i);
                    y1 = Math.min(y1 , j);
                    y2 = Math.max(y2 , j);
                }
            }
        }

        return ((y2 - y1+1) * (x2 - x1+1));
    }
}