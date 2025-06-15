class Solution {
    public int maxDiff(int num) {

        String s = Integer.toString(num);

        String t = s;
        int i=0;
        while(i < s.length()){
            if(s.charAt(i) != '9'){
                break;
            }
            i++;
        }

        if(i < s.length()){
            s = s.replace(s.charAt(i) ,'9' );
        }


        if(t.charAt(0) == '1'){
            int j = 0;
            while(j < t.length()){
                if(t.charAt(j) != '1' && t.charAt(j) != '0'){
                    break; 
                }

                j++;
            }
            if(j < t.length()){
                t = t.replace(t.charAt(j) , '0');
            }
        }else{
            t= t.replace(t.charAt(0) , '1');
        }
        
        
        return Integer.parseInt(s) - Integer.parseInt(t);
    }
}