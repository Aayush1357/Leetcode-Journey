class Solution {
    public int partitionArray(int[] nums, int k) {

        Arrays.sort(nums);

        int i = 0 , n = nums.length;

        int min = 0;

        int ans = 0;

        while(i < n){

            if(nums[i] - nums[min] <= k){

            }else{
                min = i;
                ans++;
            }
            i++;
        }

        return ++ans;
    }
}