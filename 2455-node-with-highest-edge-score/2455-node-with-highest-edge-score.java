class Solution {
    public int edgeScore(int[] edges) {

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        int n = edges.length;

        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }

        for(int i=0;i<n;i++){
            adj.get(edges[i]).add(i);
        }
        

        List<Long> ans = new ArrayList<>();
        for(int i=0;i<n;i++){
            long sum = 0;
            for(int j=0;j<adj.get(i).size();j++){
                sum += adj.get(i).get(j);
            }

            ans.add(sum);
        }

        long max = Collections.max(ans);


        int m = Integer.MIN_VALUE;
        for(int i=n-1;i>=0;i--){
            if(ans.get(i) == max){
                m = i;
            }
        }

        return m;
    }
}