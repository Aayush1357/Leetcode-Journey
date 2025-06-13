class Solution {
    public int[] findOrder(int V, int[][] prerequisites) {
        int n = prerequisites.length;
        
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < V; i++) adj.add(new ArrayList<>());

        for(int[] prereq : prerequisites) {
            adj.get(prereq[1]).add(prereq[0]);
        }

        int[] indegree = new int[V];
        for (int i = 0; i < V; i++) {
            for (Integer it: adj.get(i)){
                indegree[it]++;
            }
        }
        
        
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i<V ; i++) {
            if(indegree[i] == 0){
                q.add(i);
            }
        }
        
        // topo sort
        int c = 0;
        int[] ans = new int[V];
        int index = 0;
        while(!q.isEmpty()){
            
            int e = q.remove();
            ans[index++] = e;
            c++;

            for(Integer it:adj.get(e)){
                indegree[it]--;
                if(indegree[it] == 0) q.add(it);
            }
        }
        
        if(c == V){
            return ans;
        }
        
        ArrayList<Integer> al = new ArrayList<>();
        return al.stream().mapToInt(i -> i).toArray();

    }
}