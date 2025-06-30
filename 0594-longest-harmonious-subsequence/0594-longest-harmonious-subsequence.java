class Solution {
    public int findLHS(int[] nums) {

        HashMap<Integer , Integer> h = new HashMap<>();
        int n = nums.length;

        for(int i=0;i<n;i++){
            h.put(nums[i] , h.getOrDefault(nums[i] , 0) + 1);
        }

        int max = 0;
        int mn1=0;
        for(int k : h.keySet()){
            int v1 = h.get(k);

            if(h.containsKey(k+1)){
                int vs = h.get(k+1) + v1;
                if(max < vs){
                    max = vs;
                    mn1 = k;
                }
            }
        }

        return max;
    }
}