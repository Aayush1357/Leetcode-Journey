class Solution {
    public List<Integer> remainingMethods(int n, int k, int[][] invocations) {
        
        ArrayList<ArrayList<Integer>> a = new ArrayList<>();
        for(int i=0;i<n;i++) a.add(new ArrayList<>());  
        for(int i=0;i<invocations.length;i++) a.get(invocations[i][0]).add(invocations[i][1]);

        int[] vis = new int[n];
        bfs(k , vis , a);


        boolean is = false;
        for(int i=0;i<invocations.length;i++){
            int u = invocations[i][0];
            int v = invocations[i][1];
            if(vis[u] == 0 && vis[v] == 1){
                is = true;
                break;
            }   
        }

        List<Integer> ans = new ArrayList<>();

        if(!is){
            for(int i=0;i<n;i++){
                if(vis[i] == 0){
                    ans.add(i);
                }
            }
            return ans;
        }


        for(int i=0;i<n;i++){
            ans.add(i);
        }        
        return ans;
    }

    public static void bfs(int node , int[] vis , ArrayList<ArrayList<Integer>> a){

        Queue<Integer> q = new LinkedList<>(); 
        vis[node] = 1;
        q.add(node);

        while(!q.isEmpty()){
            int e = q.remove();
            vis[e] = 1;
            for(Integer it: a.get(e)){
                if(vis[it] == 0){
                    q.add(it);
                    vis[it] = 1;
                }
            }
        }
    }
}