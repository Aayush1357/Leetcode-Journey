class Solution {
    public boolean isPalindrome(int x) {
        
        if(x == 0) return true;
        int n = x;

        String s = "";
        while(n > 0){
            if(n%10 == '-') return false;
            s += (n%10);
            n = n/10;
        }

        if(s.equals(Integer.toString(x))) return true;

        return false;
    }
}