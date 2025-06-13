class Solution {
    public int minimizeMax(int[] nums, int p) {

        int n = nums.length;
        Arrays.sort(nums);

        int l = 0;
        int r = nums[n-1] - nums[0];

        while(l < r){
            int m = l + (r-l)/2;

            if(validPairs(m , nums) >= p){
                r = m;
            }else{
                l = m+1;
            }
        }

        return l;
    }
    public static int validPairs(int t , int[] nums){
        int c = 0;
        int n = nums.length;
        int i = 0;
        while(i < n-1){

            if(nums[i+1] - nums[i] <= t){
                c++;
                i++;
            }

            i++;
        }

        return c;
    }
}