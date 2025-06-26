class Solution {
    public int longestSubsequence(String s, int k) {

        int n = s.length();

        int sm = 0;
        int b = (int) (Math.log(k)/Math.log(2)) +1;
        int cnt = 0;

        for(int i=0;i<n;i++){
            char ch = s.charAt(n-1-i);

            if(ch == '1'){
                if( i < b && sm + (1 << i) <= k){
                    sm += 1 << i;
                    cnt++;
                }
            }else{
                cnt++;
            }
        }

        return cnt;
        
    }
}