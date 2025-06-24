class Solution {
    public boolean checkPrimeFrequency(int[] nums) {
        int n = nums.length;

        HashMap<Integer , Integer> h = new HashMap<>();

        for(int e : nums){
            h.put(e , h.getOrDefault(e , 0) + 1);
        }

        for(int v : h.values()){
            if(isPrime(v)){
                return true;
            }
        }

        return false;
    }

    public static boolean isPrime(int v){

        if(v <= 1){
            return false;
        }

        for(int i=2;i<v;i++){
            if(v % i == 0) return false;
        }

        return true;
    }
}