class Solution {
    public boolean canPartition(int[] nums) {
        
        int n = nums.length;

        int totalsum = 0;
        for(int i=0;i<n;i++){
            totalsum += nums[i];
        }
        if(totalsum % 2 != 0) return false;

        int target = totalsum/2;
        
        return isSubsetSum(nums , target);
    }

    public static boolean isSubsetSum(int arr[], int sum) {
        int n = arr.length;
        
        boolean[][] dp = new boolean[n][sum+1];
        
        for(int i=0;i<n;i++){
            dp[i][0] = true;
        }
        
        if(arr[0] <= sum){
            dp[0][arr[0]] = true;
        }
        
        
        for(int i=1;i<n;i++){
            for(int t = 1 ;t<=sum;t++){
                boolean notake = dp[i - 1][t];
        
                boolean take = false;
                
                if(t >= arr[i]){
                    take = dp[i - 1][t-arr[i]];
                }
                
                dp[i][t] = take || notake;
            
            }
        }
        return dp[n-1][sum];
    }
}