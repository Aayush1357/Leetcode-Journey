class Solution {
    public List<Integer> diffWaysToCompute(String exp) {
        
        List<Integer> ans = new ArrayList<>();

        if(exp.length() == 0){
            return ans;
        }

        if(exp.length() == 1){
            ans.add(Integer.parseInt(exp));
            return ans;
        }

        if(exp.length() == 2 && Character.isDigit(exp.charAt(0))){
            ans.add(Integer.parseInt(exp));
            return ans;
        }

        for(int i=0;i<exp.length();i++){

            char c = exp.charAt(i);
            if(Character.isDigit(c)) continue;

            List<Integer> leftr = diffWaysToCompute(exp.substring(0 , i));
            List<Integer> rightr = diffWaysToCompute(exp.substring(i+1));

            for(int lv : leftr){
                for(int rv: rightr){
                    int cr= 0;

                    switch(c){
                        case '+':
                            cr = lv + rv;
                            break;
                        case '-':
                            cr = lv - rv;
                            break;
                        case '*':
                            cr = lv * rv;
                            break;
                    }


                    ans.add(cr);
                }
            }
        }

        return ans;
    }

}