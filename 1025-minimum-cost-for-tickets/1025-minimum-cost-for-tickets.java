class Solution {
    HashSet<Integer> ist = new HashSet<>();

    public int mincostTickets(int[] days, int[] costs) {

        int n = days.length;
        int ld = days[n-1];
        int[] dp = new int[ld +1];
        Arrays.fill(dp , -1);

        for(int day : days){
            ist.add(day);
        }

        return f(0 , dp , days , costs , ist , ld);   
    }

    public static int f(int i  , int[] dp , int[] days  , int[] costs , HashSet<Integer> ist , int ld){

        if(i > ld){
            return 0;
        }

        if(!ist.contains(i)) return f(i+1 ,dp , days , costs , ist , ld);

        if(dp[i] != -1) return dp[i];

        int oday = costs[0] + f(i+1 , dp , days , costs , ist , ld);
        int sday = costs[1] + f(i+7 , dp , days , costs , ist , ld);
        int tday = costs[2] + f(i+30 , dp , days , costs , ist , ld);

        return dp[i] = Math.min(oday , Math.min(sday , tday));
    }
}