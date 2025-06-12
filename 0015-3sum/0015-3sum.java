class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        
        int n = nums.length;

        List<List<Integer>> st = new ArrayList<>();
        Arrays.sort(nums);

        for(int i=0;i<n;i++){

            if(i != 0 && nums[i] == nums[i-1]) continue;
            
            
            int j = i+1 , k = n-1;
            
            while(j< k){

                int sum = nums[i] + nums[j] + nums[k];
                if(sum < 0){
                    j++;
                }else if(sum > 0){
                    k--;
                }else{
                    List<Integer> temp = Arrays.asList(nums[i], nums[j] , nums[k]);
                    st.add(temp);

                    j++;
                    k--;

                    while(j<k && nums[j] == nums[j-1]) j++;
                    while(j<k && nums[k] == nums[k+1]) k--;
                }
            }

        }

        return st;
        /* Better Approach
        TC - O(N^2)
        SC - O(2 * no of unique element)


        Set<List<Integer>> st = new HashSet<>();
        for(int i=0;i<n;i++){
            
            Set<Integer> hs = new HashSet<>();

            for(int j=i+1;j<n;j++){

                int third = -(nums[i] + nums[j]);

                if(hs.contains(third)){
                    List<Integer> temp = Arrays.asList(nums[i], nums[j],third);
                    temp.sort(null);
                    st.add(temp);
                }    
                hs.add(nums[j]);                
            }
        }

        List<List<Integer>> ans = new ArrayList<>(st);
        return ans;
        */

        /*

        TC - O(N^3)
        Sc - O(2 * size of set unique values)

        Set<List<Integer>> st = new HashSet<>();
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                for(int k = j+1;k<n;k++){
                    if(nums[i]+ nums[j] + nums[k] == 0){
                        List<Integer> temp = Arrays.asList(nums[i], nums[j],nums[k]);
                        temp.sort(null);
                        st.add(temp);
                    }                    
                }
            }
        }

        List<List<Integer>> ans = new ArrayList<>(st);
        return ans;

        */
        

        
    }
}