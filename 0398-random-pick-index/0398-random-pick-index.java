class Solution {
    HashMap<Integer , ArrayList<Integer>> h;
    public Solution(int[] nums) {
        this.h = new HashMap<>();

        int n = nums.length;

        for(int i = 0; i<n;i++){
            int c = nums[i];
            this.h.putIfAbsent(c , new ArrayList<>());
            this.h.get(c).add(i);
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