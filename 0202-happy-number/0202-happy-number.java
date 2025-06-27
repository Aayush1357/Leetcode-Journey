class Solution {
    public boolean isHappy(int n) {
        Set<Integer> v = new HashSet<>();

        while(!v.contains(n)){
            v.add(n);
            n = get(n);
            if(n == 1){
                return true;
            }
        }

        return false;
    }

    public static int get(int n){

        int out = 0;

        while(n > 0){
            int d = n % 10;
            out += d*d;
            n /= 10;
        }

        return out;
    }
}