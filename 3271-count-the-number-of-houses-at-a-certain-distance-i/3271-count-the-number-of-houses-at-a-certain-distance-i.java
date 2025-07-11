class Solution {
    public int[] countOfPairs(int n, int x, int y) {

        int[][] matrix = new int[n+1][n+1];

        int[] ans = new int[n];
        for (int i = 1; i <= n; i++) {
            for (int j = i+1; j <= n; j++) {
                int v = Math.min(
                    Math.abs(i-j),
                    Math.min(
                        Math.abs(i-x) + 1 + Math.abs(y-j),
                        Math.abs(i-y) + 1 + Math.abs(x-j)
                    )
                );

                ans[v-1] += 2;
            }
        }

        return ans;
    }
}