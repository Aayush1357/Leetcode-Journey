class Solution {
    public int maxRotateFunction(int[] nums) {

        int n = nums.length;

        int iter = 0  , sum = 0;
        for(int i=0;i<n;i++){
            sum += nums[i];
            iter += i * nums[i];
        }

        int max = iter;

        for(int i=1;i<n;i++){

            iter = iter - sum + nums[i-1]*n;
            max = Math.max(iter , max);
        }

        return max;
    }
}