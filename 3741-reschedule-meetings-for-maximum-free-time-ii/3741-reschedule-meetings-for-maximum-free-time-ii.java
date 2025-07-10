class Solution {
    public int maxFreeTime(int eventTime, int[] startTime, int[] endTime) {
        int n = startTime.length;
        if (n == 0) return eventTime;

        int[] g = new int[n + 1];
        g[0] = startTime[0];

        for (int i = 1; i < n; i++) {
            g[i] = startTime[i] - endTime[i - 1];
        }
        g[n] = eventTime - endTime[n - 1];

        int[] lr = new int[n + 1];
        for (int i = n - 1; i >= 0; i--) {
            lr[i] = Math.max(lr[i + 1], g[i + 1]);
        }

        int maxFree = 0, ll = 0;
        for (int i = 1; i <= n; i++) {
            int d = endTime[i - 1] - startTime[i - 1];
            boolean cfl = ll >= d;
            boolean cfr = lr[i] >= d;

            if (cfl || cfr) {
                int merged = g[i - 1] + g[i] + d;
                maxFree = Math.max(maxFree, merged);
            }

            maxFree = Math.max(maxFree, g[i - 1] + g[i]);
            ll = Math.max(ll, g[i - 1]);
        }

        return maxFree;
    }
}