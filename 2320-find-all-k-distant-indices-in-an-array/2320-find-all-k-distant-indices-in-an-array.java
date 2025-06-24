class Solution {
    public List<Integer> findKDistantIndices(int[] nums, int key, int k) {

        int n = nums.length;

        List<Integer> ind = new ArrayList<>();

        for(int i=0;i<n;i++){
            if(nums[i] == key){
                ind.add(i);
            }
        }

        List<Integer> ans = new ArrayList<>();

        for(int i=0;i<n;i++){
            boolean is = false;
            for(int j=0;j<ind.size();j++){
                int jind = ind.get(j);
                if(Math.abs(i - jind) <= k){
                    is=  true;
                    break;
                }
            }
            if(is){
                ans.add(i);
            }
        }

        return ans;
    }
}