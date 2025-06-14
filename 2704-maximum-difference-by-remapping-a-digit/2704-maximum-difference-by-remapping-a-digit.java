class Solution {
    public int minMaxDifference(int num) {

        String s = Integer.toString(num);

        String t = s;
        int i =0;
        while(i < s.length() && s.charAt(i) == '9'){
            i++;
        }

        if(i < s.length()){
            s = s.replace(s.charAt(i) , '9');
        }

        t = t.replace(t.charAt(0) ,  '0');
        
        return Integer.parseInt(s) - Integer.parseInt(t);

    }
}