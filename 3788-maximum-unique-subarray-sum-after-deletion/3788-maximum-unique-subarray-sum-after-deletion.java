class Solution {
    public int maxSum(int[] nums) {

        Set<Integer> set = new TreeSet<>(Comparator.reverseOrder());
        int n = nums.length;
        for(int i=n-1;i>=0;i--){
            set.add(nums[i]);
        }
        int sum = 0;
        int max = Integer.MIN_VALUE;

        for(int e : set){
            sum += e;
            max = Math.max(max , sum);
        }

        return max;
    }
}