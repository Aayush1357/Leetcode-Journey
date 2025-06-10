class Solution {
    public int romanToInt(String s) {
        
        int n = s.length();

        HashMap<Character , Integer> h = new HashMap<>();
        h.put('M',1000);
        h.put('D' , 500);
        h.put('C' , 100);
        h.put('L' , 50);
        h.put('X' , 10);
        h.put('V' , 5);
        h.put('I' , 1);

        int i = 0;
        int ans = 0;
        while(i < n-1){
            char c = s.charAt(i);
            char ci = s.charAt(i+1);

            if(h.get(c) < h.get(ci)){
                ans += Math.abs(h.get(c) - h.get(ci));
                i += 2;
                continue;
            }
            ans += h.get(c);
            i++;

        }

        if(i == n-1) ans += h.get(s.charAt(i));
        return ans;
    }
}