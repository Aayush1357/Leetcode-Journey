class Solution {
    public List<String> validateCoupons(String[] code, String[] businessLine, boolean[] isActive) {
        
        List<String> ans = new ArrayList<>();

        int n  = code.length;

        PriorityQueue<String[]> pq = new PriorityQueue<>((a,b) -> {
            int cmp = a[0].compareTo(b[0]);
            if (cmp == 0) {
                return a[1].compareTo(b[1]);
            }
            return cmp;
        });

        for(int i = 0; i<n;i++){
            if(isActive[i]){
                String c = code[i];


                if(businessLine[i].equals("electronics") || businessLine[i].equals("grocery") || 
                businessLine[i].equals("pharmacy") || businessLine[i].equals("restaurant")){
                    
                    boolean is = false;
                    for(char ch : c.toCharArray()){
                        if(ch >= '0' && ch <= '9' || ch >= 'a' && ch <= 'z' 
                        || ch >= 'A' && ch <= 'Z' || ch == '_'){
                            is = true;
                        }else{
                            is = false;
                            break;
                        }
                    }
                    
                    if(is){
                        pq.offer(new String[]{businessLine[i] , c});
                    }

                }else{
                    continue;
                }
            }else{
                continue;
            }
        }

        while(!pq.isEmpty()){
            String[] s = pq.poll();
            ans.add(s[1]);
        }

        return ans;
    }
}