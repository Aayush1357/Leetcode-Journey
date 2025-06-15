class Solution {
    public long countSubstrings(String s, char c) {
    
        int n = s.length();
        long count = 0;
        long answer = 0;
        for(int i=0;i<n;i++){
            if(s.charAt(i) == c){
                count++;
            }
        }
        
    
        answer = (long) count * (count + 1) / 2;
    
        
        return answer;
    }
}