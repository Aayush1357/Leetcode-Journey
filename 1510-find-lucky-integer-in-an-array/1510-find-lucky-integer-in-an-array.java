class Solution {
    public int findLucky(int[] arr) {
        
        int n = arr.length;

        HashMap<Integer , Integer> h = new HashMap<>();
        for(int i=0;i<n;i++){
            h.put(arr[i] , h.getOrDefault(arr[i] , 0) + 1);
        }

        int ans = -1;

        for(int k : h.keySet()){
            int v = h.get(k);

            if(k == v){
                ans = Math.max(ans , k);
            }
        }

        return ans;
    }
}