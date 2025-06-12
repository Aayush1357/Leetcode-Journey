class Solution {
    public int threeSumClosest(int[] nums, int target) {
        
        int n = nums.length;

        Arrays.sort(nums);

        int diff = Integer.MAX_VALUE;
        int ans = 0;

        for(int i=0;i<n;i++){

            int j = i+1;
            int k = n-1;

            while(j<k){
                int sum = nums[i] + nums[j] + nums[k];

                int currentdiff = 0;
                if(sum < 0 && target > 0){
                    currentdiff = Math.abs(sum) + target;
                }else{
                    currentdiff = Math.abs(sum - target);
                }

                if(currentdiff < diff){
                    ans = sum;
                    diff = currentdiff;
                }
                if(sum < target){
                    j++;
                    while(j<k && nums[j] == nums[j-1]) j++;
                }else if(sum > target){
                    k--;
                    while(j<k && nums[k] == nums[k+1]) k--;
                }else{

                    return sum;
                }

            }
        }

        return ans;
    }
}