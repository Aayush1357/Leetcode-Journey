class Solution {
    public String convertToTitle(int cn) {

        StringBuilder ans = new StringBuilder();
        while(cn > 0){
            cn--;

            ans.append((char)((cn % 26) + 'A'));
            cn = cn/26;
        }

        return ans.reverse().toString();
    }
}