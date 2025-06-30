class Solution {
    public int findLHS(int[] nums) {

        HashMap<Integer , Integer> h = new HashMap<>();
        int n = nums.length;

        for(int i=0;i<n;i++){
            h.put(nums[i] , h.getOrDefault(nums[i] , 0) + 1);
        }

        int max = 0;
        for(int k : h.keySet()){
            if(h.containsKey(k+1)){
                int vs = h.get(k+1) + h.get(k);
                max = Math.max(max , vs);
            }
        }

        return max;
    }
}