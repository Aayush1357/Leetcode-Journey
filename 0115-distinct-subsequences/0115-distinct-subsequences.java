class Solution {
    public int numDistinct(String s, String t) {

        int[][] dp = new int[s.length()+1][t.length()+1];
        // for(int[] row : dp){
        //     Arrays.fill(row , -1);
        // }
        // return f(s.length()-1 , t.length()-1 , s , t  , dp);


        for(int i=0;i<=s.length();i++){
            dp[i][0] = 1;
        }

        for(int i=1; i<=s.length();i++){
            for(int j=1;j<=t.length();j++){
                int take = 0;
                if(s.charAt(i-1) == t.charAt(j-1)){
                    take  = dp[i-1][j-1];
                }

                int ntake = dp[i-1][j];
                dp[i][j] = take + ntake;
            }
        }

        return dp[s.length()][t.length()];
    }

    public static int  f(int i ,int j ,  String s , String t , int[][] dp){
        if(j < 0) return 1;
        if(i < 0) return 0;


        if(dp[i][j] != -1) return dp[i][j];

        int take = 0;
        if(s.charAt(i) == t.charAt(j)) take = f(i-1 ,j-1 , s , t , dp);
        int ntake = f(i-1 , j, s , t , dp);

        return dp[i][j] = take + ntake;
    }
}