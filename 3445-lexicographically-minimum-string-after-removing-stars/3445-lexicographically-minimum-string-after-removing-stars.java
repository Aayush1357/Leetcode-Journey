class Solution {
    public String clearStars(String s) {
        
        int n = s.length();


        PriorityQueue<Character> q = new PriorityQueue<>();
        Map<Character , Deque<Integer>> map  = new HashMap<>();
        boolean[] keep = new boolean[n];
        Arrays.fill(keep  ,true);

        for(int i=0;i<n;i++){
            char c =  s.charAt(i);

            if(c != '*'){
                q.offer(c);
                map.putIfAbsent(c, new ArrayDeque<>());
                map.get(c).add(i);
            }else{

                char small = q.poll();
                int index = map.get(small).removeLast();

                keep[index] = false;
                keep[i] = false;
            }
        }
        String ans = "";
        for(int i=0;i<n;i++){
            if(keep[i]) ans += s.charAt(i);
        }

        return ans;
    }
}