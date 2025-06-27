class Solution {
    public String longestSubsequenceRepeatedK(String s, int k) {
        

        String ans = "";
        Queue<String> q = new LinkedList<>();
        q.add("");

        while(!q.isEmpty()){

            String c = q.poll();
            for(char ch = 'a';ch <= 'z';ch++){
                String next = c + ch;

                if(f(next , s , k)){
                    ans = next;
                    q.add(next);
                }
            }
        }

        return ans;
    }

    public static boolean f(String seq , String s , int k){

        int i = 0 , c = 0;

        for(char ch :  s.toCharArray()){

            if(ch == seq.charAt(i)){
                i++;

                if(i == seq.length()){
                    i = 0;
                    c++;
                    if(c == k) return true;
                }
            }
        }

        return false;
    }
}