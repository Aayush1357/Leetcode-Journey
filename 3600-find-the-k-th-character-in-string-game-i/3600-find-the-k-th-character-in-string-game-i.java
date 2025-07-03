class Solution {
    public char kthCharacter(int k) {
        StringBuilder s = new StringBuilder("a");

        while(s.length() < k){
            String ns = "";
            for(int i=0;i<=s.length()-1;i++){
                char c = s.charAt(i);
                if(c == 'z'){
                    ns += Character.toString('a');
                }else{
                    ns += Character.toString(c+1);
                }
            }

            s.append(ns);
        }
        
        return s.toString().charAt(k-1);
    }
}