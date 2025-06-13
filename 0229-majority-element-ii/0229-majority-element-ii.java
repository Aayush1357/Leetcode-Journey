class Solution {
    public List<Integer> majorityElement(int[] nums) {
        
        List<Integer>  ans = new ArrayList<>();

        int n = nums.length;

        int ele1 = Integer.MIN_VALUE , ele2 = Integer.MIN_VALUE;
        int c1 = 0 , c2 = 0;

        for(int i=0;i<n;i++){
            if(c1 == 0 && ele2 != nums[i]){
                ele1 = nums[i];
                c1 = 1;
            }else if(c2 == 0 && ele1 != nums[i]){
                ele2 = nums[i];
                c2 = 1;
            }else if(ele1 == nums[i]){
                c1++;
            }else if(ele2 == nums[i]){
                c2++;
            }else{
                c1--;
                c2--;
            }
        }

        int cnt1 = 0 , cnt2 = 0;
        for(int i=0;i<n;i++){
            if(nums[i] == ele1) cnt1++;
            if(nums[i] == ele2) cnt2++;
        } 
        

        int m = (int)(n/3) + 1;
        if(cnt1 >= m) ans.add(ele1);
        if(cnt2 >= m) ans.add(ele2);

        return ans;


        // Using Hashing 
        // TC - O(N)
        // SC - O(N)

        // HashMap<Integer , Integer> h = new HashMap<>();
        // int n = nums.length;

        // for(int i=0;i<n;i++){
        //     if(h.containsKey(nums[i])){
        //         h.put(nums[i] , h.get(nums[i]) + 1);
        //     }else{
        //         h.put(nums[i] , 1);
        //     }
        // }

        // int m = n/3;
        // for(int i=0;i<h.size();i++){

        //     System.out.println(nums[i] + " " + h.get(nums[i]));

        //     if(h.get(nums[i]) > m){
        //         ans.add(nums[i]);
        //     }
        // }

        // return ans;
    }
}