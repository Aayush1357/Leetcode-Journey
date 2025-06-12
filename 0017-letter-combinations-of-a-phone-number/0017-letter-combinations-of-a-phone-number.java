class Solution {
    public List<String> letterCombinations(String digits) {

        List<String> l = new ArrayList<>();

        if(digits.length() == 0 && digits != null){

            return l;
        }

        List<String> ans  = lC(0 , digits , l, "");

        return ans;
    }

    public static List<String> lC(int index , String digits , List<String> l , String s){
        if(index == digits.length()){
            l.add(s);
            return l;
        }


        String o = options(digits.charAt(index));


        for(int i=0;i<o.length();i++){
            s += o.charAt(i);
            lC(index+1 , digits , l , s);
            s = s.substring(0 , s.length()-1);
        }

        return l;
    }

    public static String options(char c){
        HashMap<Character , String> h = new HashMap<>();
        h.put('2' , "abc");
        h.put('3' , "def");
        h.put('4' , "ghi");
        h.put('5' , "jkl");
        h.put('6' , "mno");
        h.put('7' , "pqrs");
        h.put('8' , "tuv");
        h.put('9' , "wxyz");

        String s  = h.get(c);

        return s;
    }
}