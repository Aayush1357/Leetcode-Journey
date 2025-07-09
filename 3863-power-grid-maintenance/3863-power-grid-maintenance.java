class DSU {
    int[] parent;

    public DSU(int n) {
        parent = new int[n + 1];
        for (int i = 0; i <= n; i++)
            parent[i] = i;
    }

    public int find(int x) {
        if (parent[x] != x)
            parent[x] = find(parent[x]);
        return parent[x];
    }

    public boolean union(int x, int y) {
        int px = find(x), py = find(y);
        if (px == py)
            return false;
        parent[py] = px;
        return true;
    }
}

class Solution {
    public int[] processQueries(int c, int[][] con, int[][] queries) {

        DSU dsu = new DSU(c);
        boolean[] on = new boolean[c+1];
        Arrays.fill(on , true);

        for(int[] co : con){
            dsu.union(co[0] , co[1]);
        }

        Map<Integer ,PriorityQueue<Integer>> comHeap = new HashMap<>();

        for(int s = 1;s <= c;s++){
            int root = dsu.find(s);
            comHeap.putIfAbsent(root , new PriorityQueue<>());
            comHeap.get(root).offer(s);
        }

        List<Integer> res = new ArrayList<>();

        for(int i=0;i<queries.length;i++){
            int type = queries[i][0];
            int x = queries[i][1];

            if(type == 1){
                if(on[x]){
                    res.add(x);
                }else{
                    int root = dsu.find(x);
                    PriorityQueue<Integer> heap = comHeap.get(root);
                    while(heap != null && !heap.isEmpty() && !on[heap.peek()]){
                        heap.poll();
                    }

                    res.add((heap == null || heap.isEmpty()) ? -1 : heap.peek());
                }
            }else{
                on[x] = false;
            }
        }

        int[] ans = new int[res.size()];
        for(int i=0;i<res.size();i++){
            ans[i] = res.get(i);
        }

        return ans;
    }
}