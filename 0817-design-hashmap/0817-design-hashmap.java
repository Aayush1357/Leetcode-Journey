class MyHashMap {
    public ArrayList<int[]> hashmap;

    public MyHashMap() {
        hashmap = new ArrayList<>();
    }
    
    public void put(int key, int value) {
        if(hashmap.size() == 0) hashmap.add(new int[]{key , value});

        int ind = -1;
        for(int i=0;i<hashmap.size();i++){
            int[] e = hashmap.get(i);
            int k = e[0];
            int v = e[1];

            if(k == key){
                ind = i;
            }
        }

        if(ind == -1){
            hashmap.add(new int[]{key , value});
        }else{
            hashmap.get(ind)[1] = value;
        }
        
    }
    
    public int get(int key) {
        for(int i=0;i<hashmap.size();i++){
            int[] e = hashmap.get(i);
            int k = e[0];
            int v = e[1];

            if(k == key){
                return v;
            }
        }

        return -1;
    }
    
    public void remove(int key) {
        for(int i=0;i<hashmap.size();i++){
            int[] e = hashmap.get(i);
            int k = e[0];
            int v = e[1];

            if(k == key){
                hashmap.remove(i);
            }
        }
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */