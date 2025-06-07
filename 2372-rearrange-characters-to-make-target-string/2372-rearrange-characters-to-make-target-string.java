class Solution {
    public int rearrangeCharacters(String s, String target) {

        int n = target.length();

        int[] h = new int[26];
        int[] h2 = new int[26];

        for(char ch : s.toCharArray()){
            h[ch - 'a']++;
        }

        for(char ch : target.toCharArray()){
            h2[ch - 'a']++;
        }

        int min = Integer.MAX_VALUE;
        for(char ch : target.toCharArray()){
            min = Math.min(min , h[ch-'a']/h2[ch-'a']);
        }

        return min;
    }
}