class Solution {
    public int equalPairs(int[][] grid) {
        HashMap<String ,Integer> h = new HashMap<>();


        int result = 0;

        for(int i=0;i<grid.length ;i++){
            String s = "";
            for(int j=0;j<grid[0].length;j++){
                s += grid[i][j];
                s += "*";
            }

            if (h.containsKey(s)) {
                h.put(s, h.get(s) + 1);
            }else{
                h.put(s , 1);
            }
        }

        for(int i=0;i<grid[0].length ;i++){
            String s = "";
            for(int j=0;j<grid.length;j++){
                s += grid[j][i];
                s += "*";
            }

            if (h.containsKey(s)) {
                result += h.get(s);
            }
            
        }


        return result;

    }
}