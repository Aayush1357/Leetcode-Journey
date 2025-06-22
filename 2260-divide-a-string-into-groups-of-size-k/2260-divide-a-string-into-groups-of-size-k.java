class Solution {
    public String[] divideString(String s, int k, char fill) {
        
        int n = s.length();

        List<String> ans = new ArrayList<>();

        int i = 0;

        int ind = 0;
        while(i < n){

            ans.add(s.substring(i , Math.min(n , i+k)));
            i += k;
        }

        String l = ans.get(ans.size()-1);
        int nl = l.length();
        while(nl < k){
            l += fill + "";
            nl++;
        }

        ans.set(ans.size()-1 , l);
        return ans.toArray(new String[0]);
    }
}