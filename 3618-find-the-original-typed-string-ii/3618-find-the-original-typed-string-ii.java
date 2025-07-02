class Solution {

    private static final int MOD = (int)1e9 + 7;

    public int possibleStringCount(String word, int k) {
        int n = word.length();

        if(word.isEmpty()) return 0;

        List<Integer> gr = new ArrayList<>();
        int c = 1;
        long total = 1;
        for(int i=1;i<n;i++){
            if(word.charAt(i) == word.charAt(i-1)){
                c++;
            }else{
                total = (total * c) % MOD;
                gr.add(c);
                c = 1;
            }
        }
        gr.add(c);
        total = (total * c) % MOD;

        if(k <= gr.size()) return (int)total;

        int[] dp = new int[k];
        dp[0] = 1;
        for(int num : gr){
            long sum = 0;
            int[] nDp = new int[k];
            for(int i=0;i<k;i++){
                if(i > 0) sum = (sum + dp[i-1]) % MOD;
                if(i > num) sum = (sum - dp[i-num-1] + MOD) % MOD;
                nDp[i] = (int)sum;
            }
            dp = nDp;
        }

        long iv =0;
        for(int s = gr.size();s < k;s++){
            iv = (iv + dp[s]) % MOD;
        }

        return (int)((total - iv + MOD) % MOD);
    }
}