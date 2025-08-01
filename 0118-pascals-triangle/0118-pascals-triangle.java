class Solution {

    public static List<Integer> generateRow(int n){
        List<Integer> ans = new ArrayList<>();
        
        int res = 1;
        ans.add(res);
                
        for(int i=1;i<n; i++){
            res = res * (n-i);
            res = res / (i);
            ans.add(res);
        }

        return ans;

    }
    public List<List<Integer>> generate(int numRows) {

        List<List<Integer>> ans = new ArrayList<>();


        for(int i=1; i<=numRows; i++){
            ans.add(generateRow(i));
        }

        return ans;

        /* To print the given row of pascal triangle
        TC - O(N)
        SC - O(N)

                int n = 5;
        
                List<Long> ans = new ArrayList<>();
                
                long res = 1;
                ans.add(res);
                
                for(int i=1;i<n; i++){
                    res = res * (n-i);
                    res = res / (i);
                    
                    ans.add(res);
                    
                }

        */


        /* To find the element if row and col is given
        TC -  O(c)
        SC - O(1)

                int r = 5;
                int c = 3;
                
                int res = 1;
                for(int i=0;i<c-1;i++){
                    res = res * (r-1-i);
                    res = res / (i+1);
                }
        */
        // List<List<Integer>> dp = new ArrayList<>();
        // if(numRows-1 == 0){
        //     List<Integer> il = new ArrayList<>();
        //     il.add(1);
        //     dp.add(il);
        //     return dp;
        // }

        // dp.add(new ArrayList<>());
        // dp.get(0).add(1);

        // for(int i=1;i<numRows;i++){
        //     List<Integer> il = new ArrayList<>();
        //     for(int j=0;j<=i;j++ ){
        //         if(j== 0 || j == i){
        //             il.add(1);
        //         }else{
        //             List<Integer> f = dp.get(i-1);
        //             il.add(f.get(j-1) + f.get(j));
        //         }
        //     }

        //     dp.add(il);
        // }
        // return dp;
    }
}