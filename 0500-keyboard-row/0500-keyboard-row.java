class Solution {
    public String[] findWords(String[] words) {
        String row1 = "qwertyuiop";
        String row2 = "asdfghjkl";
        String row3 = "zxcvbnm";

        List<String> res = new ArrayList<>();

        for(String word: words){
            String lowerB = word.toLowerCase();
            if(sR(lowerB, row1) || sR(lowerB, row2) || sR(lowerB, row3)){
                res.add(word);
            }
        }
        return res.toArray(new String[0]);
    }
    private boolean sR(String word, String row){
        for(char c: word.toCharArray()){
            if(row.indexOf(c) == -1){
                return false;
            }
        }
        return true;
    }
}