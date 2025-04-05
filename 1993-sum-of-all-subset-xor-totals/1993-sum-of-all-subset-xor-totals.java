class Solution {
    public int subsetXORSum(int[] nums) {
        int n = nums.length;
        int sum = 0;
        int subsets = (1 << n);
        for(int i=0;i<subsets;i++){
            List<Integer> l = new ArrayList<>();

            int xr = 0;
            for(int j=0;j<n;j++){
                
                if((i & (1 << j)) != 0){
                    xr ^= nums[j];
                }
            }

            sum += xr;
        }

        return sum;
    }
}