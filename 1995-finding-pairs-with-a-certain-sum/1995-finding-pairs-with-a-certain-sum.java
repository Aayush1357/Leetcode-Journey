class FindSumPairs {
    int[] arr1;
    int[] arr2;

    HashMap<Integer , Integer> c = new HashMap<>();

    public FindSumPairs(int[] nums1, int[] nums2) {
        arr1 = nums1;
        arr2 = nums2;

        int n = arr1.length;
        int m = arr2.length;


        for(int x : arr2){
            c.put(x , c.getOrDefault(x , 0) + 1);
        }
    }
    
    public void add(int index, int val) {

        c.put(arr2[index] , c.get(arr2[index]) - 1);
        arr2[index] += val;
        c.put(arr2[index] , c.getOrDefault(arr2[index] , 0) + 1);

    }
    
    public int count(int tot) {

        int v = 0;
        for(int x : arr1){
            v += c.getOrDefault(tot - x, 0);
        }
        return v;
    }
}

/**
 * Your FindSumPairs object will be instantiated and called as such:
 * FindSumPairs obj = new FindSumPairs(nums1, nums2);
 * obj.add(index,val);
 * int param_2 = obj.count(tot);
 */