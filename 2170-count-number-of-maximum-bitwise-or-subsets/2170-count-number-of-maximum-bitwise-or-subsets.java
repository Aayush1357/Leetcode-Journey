class Solution {
    public int countMaxOrSubsets(int[] nums) {
        int n = nums.length;

        int maxor = 0;
        for(int i=0;i<n;i++){
            maxor |= nums[i];
        }

        return f(0 , nums , maxor , 0);
    }


    public static int f(int i , int[] nums , int maxor , int x){

        
        if(i >= nums.length){
            if(maxor == x){
                return 1;
            }else{
                return 0;
            }
        }

        
        int t = f(i+1 , nums , maxor, x | nums[i]);

        int nt = f(i+1 , nums , maxor ,x);

        return t + nt;
    }
}