class Solution {
    static class Pair{
        private int first;
        private int second;
        public Pair(int a, int b) {
            first = a;
            second = b;
        }
	}

    public int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] vis = new int[m][n];
        for(int i=0;i<m;i++){
            Arrays.fill(vis[i] , 0);
        }

        int c = 0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j] == '1' && vis[i][j] == 0){
                    bfs(i,j,vis,grid);
                    c++;
                }
            }
        }

        return c;
    }

    public static void bfs(int i , int j , int[][] vis , char[][] grid){
        
        vis[i][j] = 1;
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(i,j));
        

        int m = grid.length;
        int n = grid[0].length;
        
        while(!queue.isEmpty()){
            int row = queue.peek().first;
            int col = queue.peek().second;
            queue.remove();

            ArrayList<Pair> option = new ArrayList<>();
            option.add(new Pair(row+1,col));
            option.add(new Pair(row,col+1));
            option.add(new Pair(row-1,col));
            option.add(new Pair(row,col-1));

            for(Pair it: option){
                int nrow = it.first;
                int ncol = it.second;

                if(nrow >= 0 && nrow <m && ncol >= 0 && ncol < n &&
                grid[nrow][ncol] == '1' && vis[nrow][ncol] == 0){
                    vis[nrow][ncol]  = 1;
                    queue.add(new Pair(nrow , ncol));
                }
            }
        }

    }
}
