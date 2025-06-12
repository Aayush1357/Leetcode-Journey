class Solution {
    public int[][] merge(int[][] intervals) {
        
        List<int[]>  ans = new ArrayList<>();

        int n = intervals.length;

        Arrays.sort(intervals , new Comparator<int[]>(){
            public int compare(int[] a , int[] b){
                return a[0]-b[0];
            }
        });


        for(int i=0;i<n;i++){

            if(ans.isEmpty() || intervals[i][0]  > ans.get(ans.size()-1)[1]){
                ans.add(new int[]{intervals[i][0] , intervals[i][1]});
            }else{
                ans.get(ans.size()-1)[1] = Math.max(ans.get(ans.size()-1)[1] , intervals[i][1]);
            }
        }
        // TC - O(N*logN) + O(2N)
        // SC - O(N)
        // for(int i=0;i<n;i++){

        //     int start = intervals[i][0];
        //     int end = intervals[i][1];


        //     if(!ans.isEmpty() && end <= ans.get(ans.size()-1)[1] ){
        //         continue;
        //     }

        //     for(int j=i+1;j<n;j++){
        //         if(intervals[j][0] <= end){
        //             end  = Math.max(end , intervals[j][1]);
        //         }else{
        //             break;
        //         }
        //     }

        //     ans.add(new int[]{start, end});
        // }


        int[][] a = new int[ans.size()][2];

        for(int i=0;i<ans.size();i++){
            int[] b = ans.get(i);

            a[i] = b;
        }

        return a;
    }
}