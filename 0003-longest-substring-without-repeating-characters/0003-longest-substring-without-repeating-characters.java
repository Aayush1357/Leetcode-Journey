class Solution {
    public int lengthOfLongestSubstring(String s) {


        int l = 0 , r=0, maxlen = 0;
        HashMap<Character ,  Integer> h = new HashMap<Character , Integer>();

        int n = s.length();
        while(r < n){

            if(h.containsKey(s.charAt(r))){
                l = Math.max(h.get(s.charAt(r)) + 1 , l);
            }

            h.put(s.charAt(r) , r);
            maxlen = Math.max(maxlen , r-l+1);
            r++;
        }
        
        return maxlen;
    }
}