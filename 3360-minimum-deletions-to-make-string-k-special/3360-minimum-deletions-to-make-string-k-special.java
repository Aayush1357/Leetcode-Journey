class Solution {
		public int minimumDeletions(String word, int k) {
			int n = word.length();
			int[] f = new int[26];
			for(int i = 0;i < n;i++){
				f[word.charAt(i) - 'a']++;
			}
			int ans = n;
			for(int b = 1;b <= n;b++){
				int o = 0;
				for(int i = 0;i < 26;i++){
					if(f[i] >= b && f[i] <= b+k){
					}else if(f[i] > b+k) {
						o += f[i] - b - k;
					}else{
						o += f[i];
					}
				}
				ans = Math.min(ans, o);
			}
			return ans;
		}
	}