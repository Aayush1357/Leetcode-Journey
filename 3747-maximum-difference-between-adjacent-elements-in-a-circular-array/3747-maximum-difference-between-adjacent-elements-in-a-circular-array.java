class Solution {
    public int maxAdjacentDistance(int[] nums) {
        int max = Integer.MIN_VALUE;
        int n = nums.length;

        for(int i=0;i<n-1;i++){
            int x = Math.abs(nums[i]-nums[i+1]);
            max = Math.max(x , max);
        }

        max = Math.max(Math.abs(nums[0]-nums[n-1]) , max);
        return max;
    }
}