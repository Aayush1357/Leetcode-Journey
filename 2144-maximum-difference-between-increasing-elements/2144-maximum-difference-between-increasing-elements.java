class Solution {
    public int maximumDifference(int[] nums) {

        int n = nums.length;

        int pre = nums[0];
        int ans = -1;

        for(int i = 1;i < n; i++){
            if(nums[i] > pre){
                ans = Math.max(ans , nums[i] - pre);
            }else{
                pre = nums[i];
            }
        }

        return ans;
    }
}