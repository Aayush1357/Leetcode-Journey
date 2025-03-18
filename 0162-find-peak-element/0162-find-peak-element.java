class Solution {
    public int findPeakElement(int[] nums) {
        
        int n = nums.length;
        
        int l =0 , h = n-1;

        while(l < h){
            int m = l + (h-l)/2;

            if(nums[m] > nums[m+1]){
                h = m;
            }else{
                l = m + 1;
            }
        }

        return h;
    }
}