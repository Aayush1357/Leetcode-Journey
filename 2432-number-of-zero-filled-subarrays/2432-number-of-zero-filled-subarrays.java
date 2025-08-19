class Solution {
    public long zeroFilledSubarray(int[] nums) {

        int n = nums.length;

        long ans = 0;
        long c = 0;
        for(int i=0;i<n;i++){
            if(nums[i] == 0){
                c++;
                ans += c;
            }else{
                c = 0;
            }
        }

        return ans;
    }
}