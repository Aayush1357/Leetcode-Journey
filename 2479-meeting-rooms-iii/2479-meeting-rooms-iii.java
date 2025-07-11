import java.util.*;

class Solution {
    public int mostBooked(int n, int[][] meetings) {
        Arrays.sort(meetings, Comparator.comparingInt(a -> a[0]));

        PriorityQueue<Integer> f = new PriorityQueue<>();
        for (int i = 0; i < n; ++i) f.offer(i);

        PriorityQueue<long[]> pq =
            new PriorityQueue<>((a, b) -> a[0] == b[0] ? Long.compare(a[1], b[1])
                                                        : Long.compare(a[0], b[0]));

        int[] cnt = new int[n];

        for (int[] m : meetings) {
            long start = m[0], end = m[1];

            while (!pq.isEmpty() && pq.peek()[0] <= start)
                f.offer((int) pq.poll()[1]);

            int room;
            long newEnd;
            if (!f.isEmpty()) {
                room = f.poll();
                newEnd = end;
            } else {
                long[] e = pq.poll();
                room = (int) e[1];
                newEnd = e[0] + (end - start);
            }
            pq.offer(new long[] {newEnd, room});
            cnt[room]++;
        }

        int ans = 0;
        for (int i = 1; i < n; ++i)
            if (cnt[i] > cnt[ans]) ans = i;
        return ans;
    }
}