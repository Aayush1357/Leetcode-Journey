class Solution {
    public int numDecodings(String s) {

        int n = s.length();
        int[] dp = new int[n+1];
        // Arrays.fill(dp , -1);
        dp[n] = 1;

        for(int i=n-1;i>=0;i--){
            if(s.charAt(i) != '0'){
                dp[i] = dp[i+1];
                if(i < n-1 && (s.charAt(i) == '1' || s.charAt(i) == '2' && s.charAt(i+1) < '7')){
                    dp[i] += dp[i+2];

                } 
            }
        }
        return dp[0];
        // return f(0 , s , dp);
    }

    public static int f(int i  , String s , int[] dp){


        if(i >= s.length()) return 1;

        if(s.charAt(i) == '0') return 0;

        if(dp[i] != -1) return dp[i];

        int ways = f(i+1 , s , dp);

        if(i+1 < s.length()){
            String two = s.substring(i,i+2);
            int it = Integer.parseInt(two);
            if(it > 0 && it <= 26){
                ways += f(i+2, s , dp);
            }
        }

        return dp[i] = ways;
    }
}