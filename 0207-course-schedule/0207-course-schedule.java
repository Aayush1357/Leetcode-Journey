class Solution {
    public boolean canFinish(int V, int[][] prerequisites) {

        int n = prerequisites.length;

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i=0;i<V;i++) adj.add(new ArrayList<>());

        for(int i=0;i<n;i++){
            int u = prerequisites[i][1];
            int v = prerequisites[i][0];
            adj.get(u).add(v);
        }

        int[] indegree = new int[V];
        for (int i = 0; i < V; i++) {
            for (Integer it: adj.get(i)){
                indegree[it]++;
            }
        }
        
        
        Queue<Integer> q = new LinkedList<>();
        
        for (int i = 0; i <V ; i++) {
            if(indegree[i] == 0){
                q.add(i);
            }
        }
        
        int c = 0;
        while(!q.isEmpty()){
            
            int e = q.remove();
            c++;
            
            for(Integer it:adj.get(e)){
                indegree[it]--;
                if(indegree[it] == 0) q.add(it);
            }
        }
        
        
        if(c == V){
            return true;
        }
        
        return false;

    }
}