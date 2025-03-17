class Solution {
    public boolean divideArray(int[] nums) {
        
        int n = nums.length;

        Set<Integer> u = new HashSet<>();

        for(int num: nums){
            if(u.contains(num)){
                u.remove(num);
            }else{
                u.add(num);
            }
        }

        return u.isEmpty();
    }
}