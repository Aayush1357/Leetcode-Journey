class Solution {
    public boolean isSubstringPresent(String s) {
        int n =s.length();
        String reverse = palindrome(s,n);
        
        boolean isreverse = false;
        for(int i=0;i<n-1;i++){
            String w = s.substring(i,i+2);
            for(int j=0;j<n-1;j++){
                if(reverse.contains(w)){
                    isreverse = true;
                    break;
                }
            }
        }
        
        if(isreverse){
            return true;
        }
        return isreverse;
    }
    
    
    public static String palindrome(String s , int n){
        String re = "";
        for(int i=n-1;i>=0;i--){
            re += s.charAt(i);
        }
        
        return re;
    }
}