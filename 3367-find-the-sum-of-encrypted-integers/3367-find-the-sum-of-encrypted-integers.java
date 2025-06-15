class Solution {
    public int sumOfEncryptedInt(int[] nums) {
        
        int sum = 0;
        int n = nums.length;
        for(int i=0;i<n;i++){
            int a = nums[i];
            int max = 0;
            int length = 0;
            while(a >0){
                length++;
                if(max < a%10){
                    max = a%10;
                }
                a /= 10;
            }
            
            String s = "";
            for(int j=0;j<length;j++){
                s += max;
            }
            sum += Integer.parseInt(s);
        }
        
        return sum;
    }
}