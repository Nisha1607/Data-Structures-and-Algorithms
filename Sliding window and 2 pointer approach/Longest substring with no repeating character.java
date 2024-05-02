//TC : O(n*n)
//SC : O(256)

  public int lengthOfLongestSubstring(String s) {
        int[] hash = new int[256];
        Arrays.fill(hash,-1);
        int maxLen =  0;
        for(int i=0;i<s.length();i++){
            hash = new int[256];
             Arrays.fill(hash,-1);
            for(int j=i;j<s.length();j++){
                if(hash[s.charAt(j)]!=-1){
                    break;
                }
                hash[s.charAt(j)]++;
               maxLen=Math.max(maxLen,j-i+1);
            }
        }
        return maxLen;
    }

//TC : O(2n)
//SC : O(256)

 public int lengthOfLongestSubstring(String s) {
        int[] hash = new int[256];
        Arrays.fill(hash,-1);
        int maxLen =  0;
        int l=0,r=0;
        while(r<s.length()){
            if(hash[s.charAt(r)] >= l){
                while(l<r && hash[s.charAt(r)] >= l){
                    hash[s.charAt(l)]=l;
                    l++;
                }
            }
            
            hash[s.charAt(r)]=r;
            maxLen=Math.max(maxLen,r-l+1);
            r++;
        }
        return maxLen;
    }


//TC : O(n)
//SC : O(256)

 int longestUniqueSubsttr(String S){
        int l=0,r=0;
        int maxLen=0;
        int[] freq=new int[26];
        Arrays.fill(freq,-1);
        while(r<S.length()){
            if(freq[S.charAt(r)-'a']!=-1)
            {
                if(freq[S.charAt(r)-'a']>=l)
                {
                    l=freq[S.charAt(r)-'a']+1;
                }
            }
            maxLen=Math.max(maxLen,r-l+1);
             freq[S.charAt(r)-'a']=r;
            r++;
        }
        return maxLen;
    }
