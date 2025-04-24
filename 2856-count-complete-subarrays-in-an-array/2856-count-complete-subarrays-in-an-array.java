class Solution {
    public int countCompleteSubarrays(int[] nums) {
        HashMap<Integer, Integer> h = new HashMap<>();

        int n = nums.length;

        for(int i=0;i<n;i++){
            if(h.containsKey(nums[i])){
                h.put(nums[i] , h.get(nums[i]) + 1);
            }else{
                h.put(nums[i] , 1);
            }
        }

        int c = 0;
        for(int i=0;i<n;i++){
            HashMap<Integer , Integer> nh = new HashMap<>();
            for(int j=i;j<n;j++){

                int num = nums[j];
                if(nh.containsKey(num)){
                    nh.put(num , nh.get(num) + 1);
                }else{
                    nh.put(num , 1);
                }

                if(nh.size() == h.size()) c++;
            }
            
        }


        return c;
    }
}