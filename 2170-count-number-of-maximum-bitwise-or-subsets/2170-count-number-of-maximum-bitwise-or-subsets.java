class Solution {
    public int countMaxOrSubsets(int[] nums) {
        int n = nums.length;

        int maxor = 0;
        for(int i=0;i<n;i++){
            maxor |= nums[i];
        }

        int[] dp = new int[n];
        Arrays.fill(dp , -1);
        return f(0 , nums , maxor , 0 , dp);
    }


    public static int f(int i , int[] nums , int maxor , int x , int[] dp){

        
        if(i >= nums.length){
            if(maxor == x){
                return 1;
            }else{
                return 0;
            }
        }

        if(dp[i] != -1) return dp[i];

        int t = f(i+1 , nums , maxor, x | nums[i] , dp);

        int nt = f(i+1 , nums , maxor ,x ,dp);

        return t + nt;
    }
}