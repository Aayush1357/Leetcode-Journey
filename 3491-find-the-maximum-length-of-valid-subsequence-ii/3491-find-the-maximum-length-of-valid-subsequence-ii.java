class Solution {

    public int maximumLength(int[] nums, int k) {
        int[][] dp = new int[k][k];
        int ans = 0;
        for (int num : nums) {
            num %= k;
            for (int prev = 0; prev < k; prev++) {
                dp[prev][num] = dp[num][prev] + 1;
                ans = Math.max(ans, dp[prev][num]);
            }
        }
        return ans;
    }
}