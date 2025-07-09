class Solution {
    public int maxFreeTime(int eventTime, int k, int[] startTime, int[] endTime) {

        int n = startTime.length;
        int[] pf = new int[n+1];

        for(int i=0;i<n;i++){
            pf[i+1] = pf[i] + endTime[i] - startTime[i];
        }


        int ans = 0;
        for(int i=k-1;i < n;i++){
            int occ = pf[i+1] - pf[i-k+1];
            int l = (i == k-1) ? 0 : endTime[i-k];
            int r = (i == n-1) ? eventTime : startTime[i+1];

            ans = Math.max(ans , r - l - occ);
        }

        return ans;
    }
}