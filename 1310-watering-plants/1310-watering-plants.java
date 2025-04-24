class Solution {
    public int wateringPlants(int[] plants, int capacity) {
        int n = plants.length;
        int count =  1;
        int c = capacity;
        for(int i=0;i<n-1;i++){
            c -= plants[i];
            if(c < plants[i+1]){
                count += ((i+1) * 2) + 1;
                c = capacity;
            }else{
                count++;
            }
        }

        

        return count;
    }
}