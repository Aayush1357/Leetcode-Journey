class Solution {
    HashMap<Integer , ArrayList<Integer>> h = new HashMap<>();
    public Solution(int[] nums) {
        int n = nums.length;

        for(int i = 0; i<n;i++){
            int c = nums[i];
            h.putIfAbsent(c , new ArrayList<>());

            ArrayList<Integer> a = h.get(c);
            a.add(i);
            h.put(c ,a );
        }
    }
    
    public int pick(int target) {
        ArrayList<Integer> a = h.get(target);

        int i = (int)(Math.random() * a.size());
        return a.get(i);
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int param_1 = obj.pick(target);
 */