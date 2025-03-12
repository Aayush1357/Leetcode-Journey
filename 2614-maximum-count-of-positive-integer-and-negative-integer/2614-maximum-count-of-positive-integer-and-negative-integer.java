class Solution {
    public int maximumCount(int[] nums) {
        
        int n = nums.length;

        int max = 0;
        int min = 0;

        for(int i=0;i<n;i++){
            if(nums[i] > 0) max++;
            else if(nums[i] < 0) min++;
        }

        return Math.max(min , max);
    }
}