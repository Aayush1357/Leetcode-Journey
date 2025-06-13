class Solution {
    public boolean isPowerOfTwo(int n) {

        if(n <= 0){
            return false;
        }
        int xr = n-1 & n;
        if(xr == 0){
            return true;
        }

        return false;
    }
}