  public int characterReplacement(String s, int k) {
        int n = s.length();
        int maxLen = 0;
        int l=0,r=0;
        int[] freq = new int[26];
        int curr=0;
        while(r<n){
            freq[s.charAt(r)-'A']++;
            curr = Math.max(curr,freq[s.charAt(r)-'A']);

            if(r-l+1-curr>k){
                freq[s.charAt(l)-'A']--;
                l++;
            }

            maxLen = Math.max(maxLen,r-l+1);
            r++;
        }     
        return maxLen;
    }
