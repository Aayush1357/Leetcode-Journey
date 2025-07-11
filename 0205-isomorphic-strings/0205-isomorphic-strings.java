class Solution {
    public boolean isIsomorphic(String s, String t) {
        
        if (s.length() != t.length())
            return false;

        HashMap<Character, Character> map = new HashMap<>();
        HashMap<Character, Boolean> mapped = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char charS = s.charAt(i);
            char charT = t.charAt(i);

            if (map.containsKey(charS)) {
                if (map.get(charS) != charT)
                    return false;
            } else {
                if (mapped.containsKey(charT))
                    return false;
                map.put(charS, charT);
                mapped.put(charT, true);
            }
        }
        return true;
    }
}