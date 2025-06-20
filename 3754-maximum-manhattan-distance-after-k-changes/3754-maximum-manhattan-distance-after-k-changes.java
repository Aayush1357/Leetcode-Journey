class Solution {
    public int maxDistance(String s, int k) {

        int ans = 0;

        int no = 0,so = 0,ea = 0 ,we = 0;
        for(char it : s.toCharArray()){
            if(it == 'N'){
                no++;
            }else if(it == 'S'){
                so++;
            }else if(it == 'E'){
                ea++;
            }else if(it == 'W'){
                we++;
            }

            int t1 = Math.min(Math.min(no , so) , k);

            int t2 = Math.min(Math.min(ea , we) , k - t1);

            ans  = Math.max(ans , 
                            count(no , so , t1) + count(ea , we , t2));
        }

        return ans;

    }

    public static int count(int d1 , int d2 , int t){
        return Math.abs(d1 - d2) + t * 2;
    }
}