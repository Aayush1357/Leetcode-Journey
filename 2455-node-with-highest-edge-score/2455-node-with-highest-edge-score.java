class Solution {
    public int edgeScore(int[] edges) {

        
        int n = edges.length;
        long[] arr = new long[n];

        for(int i=0;i<n;i++){
            arr[edges[i]] += i;
        }


        long res = -1;
        int ans = -1;
        for(int i=0;i<n;i++){
            if(arr[i] > res){
                res = arr[i];
                ans = i;
            }
        }

        return ans;
    }
}