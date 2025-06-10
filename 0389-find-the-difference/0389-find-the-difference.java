class Solution {
    public char findTheDifference(String s, String t) {

        int n  = s.length();

        HashMap<Character , Integer> h = new HashMap<>();


        for(char c : t.toCharArray()){
            h.put(c, h.getOrDefault(c, 0) + 1);
        }

        char ans = 'a';
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            
            h.put(c, h.get(c) - 1);
            if (h.get(c) == 0) {
                h.remove(c);
            }
        }
        return (char) h.keySet().toArray()[0];
    }
}