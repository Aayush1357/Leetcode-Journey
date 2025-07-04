class Solution {
    public char kthCharacter(long k, int[] operations) {

        long sh = 0;
        List<Long> len = new ArrayList<>();

        long l = 1;
        for(int op: operations){
            l *= 2;
            len.add(l);
            if(l >= k) break;

        }


        for(int i=len.size()-1;i>=0;i--){
            long h = len.get(i) / 2;
            int op = operations[i];

            if(k > h){
                k -= h;
                if(op == 1) sh++;
            }
        }
        return (char)((('a' - 'a' + sh) % 26 ) + 'a');

    }


}