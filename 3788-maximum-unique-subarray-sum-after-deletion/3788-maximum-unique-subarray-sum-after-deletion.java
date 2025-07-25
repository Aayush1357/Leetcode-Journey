class Solution {
    public int maxSum(int[] nums) {

        Arrays.sort(nums);

        Set<Integer> set = new TreeSet<>(Comparator.reverseOrder());
        int n = nums.length;
        for(int i=n-1;i>=0;i--){
            set.add(nums[i]);
        }
        int sum = 0;
        Iterator<Integer> i = set.iterator();
        int max = Integer.MIN_VALUE;

        while(i.hasNext()){
            sum += i.next();
            max = Math.max(max , sum);
        }

        return max;
    }
}