//TC :O(n*n)
public int longestkSubstr(String s, int k) {
        // code here
        int n = s.length();
        int maxLen=-1;
        HashMap<Character,Integer> map = new HashMap<>();
        for(int i=0;i<n;i++){
            map = new HashMap<>();
            for(int j=i;j<n;j++){
                if(map.size()>k)
                    break;
                map.put(s.charAt(j),j);
                if(map.size()==k)
                    maxLen=Math.max(j-i+1,maxLen);
            }
        }
        return maxLen;
    }


//TC :O(n)
 public int longestkSubstr(String s, int k) {
        int n = s.length();
        int maxLen=-1;
        HashMap<Character,Integer> map = new HashMap<>();
        int l=0,r=0;
        while(r<n){
            map.put(s.charAt(r),map.getOrDefault(s.charAt(r),0)+1);
            if(map.size()>k){
              while(map.size()>k){
                  map.put(s.charAt(l),map.get(s.charAt(l))-1);
                  if(map.get(s.charAt(l))==0)
                    map.remove(s.charAt(l));
                  l++;
              }
            }
            if(map.size()==k)
                    maxLen=Math.max(r-l+1,maxLen);
            r++;
        }
        return maxLen;
    }
