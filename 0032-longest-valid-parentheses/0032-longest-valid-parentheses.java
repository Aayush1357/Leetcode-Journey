class Solution {
    public int longestValidParentheses(String s) {
        Stack<Integer> st = new Stack<>();
        int n = s.length();

        st.push(-1);
        int c = 0;

        for(int i=0;i<n;i++){
            char ch = s.charAt(i);

            if(ch == '('){
                st.push(i);
            }else{
                st.pop();
                if(!st.isEmpty()){
                    c = Math.max(c , i-st.peek());
                }else{
                    st.push(i);
                }
                
            }
        }

        
        
        return c;
    }
}