class Solution {
    public int maxDifference(String s) {


        int[] h = new int[26];

        for(char c : s.toCharArray()){
            h[c - 'a']++;
        }

        int a1 = Integer.MIN_VALUE;
        int a2 = Integer.MAX_VALUE;

        for(int i=0;i<26;i++){
            if(h[i] == 0) continue;

            if(h[i] % 2 == 0){
                a2 = Math.min(a2 , h[i]);
            }else{
                a1 = Math.max(a1 , h[i]);
            }
        }

        return a1 - a2;
    }
}