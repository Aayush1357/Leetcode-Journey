class Solution {
    public long maximumTripletValue(int[] nums) {

        int n = nums.length;

        int[] pm = new int[n];
        int[] sm = new int[n];

        pm[0] = nums[0];
        for(int i=1;i<n;i++){
            pm[i] = Math.max(nums[i] , pm[i-1]);
        }
        sm[n-1] = nums[n-1];
        for(int i=n-2;i>=0;i--){
            sm[i] = Math.max(nums[i] , sm[i+1]); 
        }

        long ans = 0;
        for(int i= 1;i<n-1;i++){
            long v = (long)(pm[i-1] - nums[i]) * sm[i+1];
            ans = Math.max(ans , v);
        }

        return ans;
    }
}