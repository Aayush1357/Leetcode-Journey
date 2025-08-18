class Solution {
    public int longestCommonSubsequence(String text1, String text2) {

        int n = text1.length();
        int m = text2.length();

        int[][] dp = new int[n+1][m+1];
        for(int[] r : dp){
            Arrays.fill(r , -1);
        }

        for(int i=0;i<=n;i++){
            dp[i][0] = 0; 
        }

        for(int i=0;i<=m;i++){
            dp[0][i] = 0;
        }

        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                if(text1.charAt(i-1) == text2.charAt(j-1)){
                    dp[i][j] = 1 + dp[i-1][j-1];
                }else{
                    dp[i][j] = Math.max(dp[i][j-1] , dp[i-1][j]);
                }

            }
        }


        return dp[n][m];
        // return f(n , m, text1 , text2 , dp);

    }

    public static int f(int i ,int j, String t1 , String t2 , int[][] dp){

        if(i == 0 || j == 0) return 0;

        if(dp[i-1][j-1] != -1) return dp[i-1][j-1];

        if(t1.charAt(i-1) == t2.charAt(j-1)){
            return 1 + f(i-1 , j-1 , t1 ,t2 , dp);
        }

        return dp[i-1][j-1]  = Math.max(f(i-1 , j , t1 , t2 , dp) , f(i , j-1 , t1, t2 , dp));
    }

}