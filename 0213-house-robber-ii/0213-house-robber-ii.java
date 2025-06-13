class Solution {
    public int rob(int[] nums) {

        int n = nums.length;

        if(n == 1) return nums[0];


        int[] arr1 = new int[n-1];
        int[] arr2 = new int[n-1];

        for(int i=0;i<n;i++){
            if(i != 0) arr1[i-1] =  nums[i];
            if(i != n-1) arr2[i] = nums[i];
        }

        int ans1 = adjacentNotElement(arr1);
        int ans2 = adjacentNotElement(arr2); 


        return Math.max(ans1 , ans2);

    }

    public static int adjacentNotElement(int[] arr){

        int n = arr.length;
        int[] dp = new int[n];

        dp[0] = arr[0];

        for(int i=1;i<n;i++){
            int take = arr[i];

            if(i > 1){
                take += dp[i-2];
            }

            int notake = dp[i-1];

            dp[i] = Math.max(take , notake);

        }

        return dp[n-1];
    }
}