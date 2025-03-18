class Solution {
    public int longestNiceSubarray(int[] nums) {
        
        int n = nums.length;

        int l = 0, max = 0;
        int ub = 0;
        
        for(int r=0;r<n;r++){

            while((ub & nums[r]) != 0){
                ub ^= nums[l];
                l++;
            }

            ub |= nums[r];
            
            max = Math.max(max,  r-l+1);
        }

        return max;
    }
}