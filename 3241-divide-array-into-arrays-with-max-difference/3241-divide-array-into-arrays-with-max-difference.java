class Solution {
    public int[][] divideArray(int[] nums, int k) {
        
        Arrays.sort(nums);

        int n = nums.length;

        int[][] ans = new int[(int) n/3][3];

        int i = 0;
        int in = 0;
        boolean is = true;
        while(i <= n-3){
            int f = nums[i];
            int s = nums[i+1];
            int t = nums[i+2];

            if(s-f <= k && t-s <= k && t-f <= k){
                ans[in][0] = f;
                ans[in][1] = s;
                ans[in][2] = t;
                in++;
            }else{
                is = false;
                break;
            }
            i += 3;
        }

        if(!is) return new int[][]{};
        return ans;
    }
}