class Solution {
    public String countAndSay(int n) {
        String r = "1";
        for (int i = 1; i < n; i++) {
            r = next(r);
        }
        return r;
    }

    private String next(String s) {
        StringBuilder sb = new StringBuilder();
        int c = 1;
        char ch = s.charAt(0);

        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == ch) {
                c++;
            } else {
                sb.append(c).append(ch);
                ch = s.charAt(i);
                c = 1;
            }
        }

        sb.append(c).append(ch);
        return sb.toString();
    }
}