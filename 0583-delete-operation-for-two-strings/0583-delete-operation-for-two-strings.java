class Solution {
    public int minDistance(String w1, String w2) {
        int n = w1.length();
        int m = w2.length();

        int[][] dp = new int[n][m];
        for(int[] r : dp){
            Arrays.fill(r, -1);
        }

        return f(0 , 0 , w1 , w2 , dp);
    }

    public static int f(int i , int j , String w1 , String w2 , int[][] dp){

        if(i >= w1.length() && j >= w2.length()){
            return 0;
        }
        if(i >= w1.length() && j < w2.length()){
            return (w2.length() - j);
        }

        if(i < w1.length() && j >= w2.length()){
            return (w1.length() - i);
        }

        if(dp[i][j] != -1) return dp[i][j];

        if(w1.charAt(i) == w2.charAt(j)){
            return f(i+1 , j+1 , w1 , w2 , dp);
        }

        return dp[i][j] = 1 + Math.min(f(i+1 , j , w1 , w2 , dp) , f(i , j+1 , w1 , w2 , dp));
    }
}