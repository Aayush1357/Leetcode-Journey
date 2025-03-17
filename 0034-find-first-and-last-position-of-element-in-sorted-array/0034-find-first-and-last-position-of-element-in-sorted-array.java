class Solution {
    public int[] searchRange(int[] nums, int target) {

        return new int[]{fp(nums , target , true) , fp(nums , target , false)};

    }

    public static int fp(int[] nums , int target , boolean is){

        int n = nums.length;
        
        int l = 0 , h = n-1;
        int ans = -1;

        while(l <= h){
            int m = (l+h)/2;

            if(nums[m] == target){
                ans = m;

                if(is){
                    h = m - 1;
                }else{
                    l = m+1; 
                }
            }else if(nums[m] > target){
                h = m-1;
            }else{
                l = m+1;
            }
        }

        return ans;
    }
}