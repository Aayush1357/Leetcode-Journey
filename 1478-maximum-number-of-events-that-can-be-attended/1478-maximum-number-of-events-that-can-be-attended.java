class Solution {
    public int maxEvents(int[][] events) {
        
        int n = events.length;

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        Arrays.sort(events , (a,b) -> a[0] - b[0]);

        int d = 0;
        for(int[] e : events){
            d = Math.max(d , e[1]);
        }

        int ans = 0;
        for(int i=1,j=0;i<=d;i++){

            while(j < n && events[j][0] <= i){
                pq.offer(events[j][1]);
                j++;
            }

            while(!pq.isEmpty() && pq.peek() < i){
                pq.poll();
            }

            if(!pq.isEmpty()){
                ans++;
                pq.poll();
            }
        }

        return ans;
        
    }
}