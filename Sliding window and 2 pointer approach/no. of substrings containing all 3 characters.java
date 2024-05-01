//TC: O(n*n)

 public int numberOfSubstrings(String s) {
        int n = s.length();
        int cnt=0;
        int[] freq = new int[3];
        for(int i=0;i<n;i++){
            freq = new int[3];
            for(int j=i;j<n;j++){
                freq[s.charAt(j)-'a']=1;
                if(freq[0]+freq[1]+freq[2]==3){
                    cnt++;
                }
            }
        }
        return cnt;
    }


//slight optimization still TC is same
 public int numberOfSubstrings(String s) {
        int n = s.length();
        int cnt=0;
        int l=0,r=n-1;
        int[] freq = new int[3];
        for(int i=0;i<n;i++){
            freq = new int[3];
            for(int j=i;j<n;j++){
                freq[s.charAt(j)-'a']=1;
                if(freq[0]+freq[1]+freq[2]==3){
                    cnt+=n-1-j;
                    cnt++;
                    break;
                }
            }
        }
        return cnt;
    }


//most optimized
// TC : O(n)

   public int numberOfSubstrings(String s) {
        int n = s.length();
        int cnt=0;
        int[] lastseen = new int[3];
        Arrays.fill(lastseen,-1);
        for(int i=0;i<n;i++){
            lastseen[s.charAt(i)-'a']=i;
            if(lastseen[0]!=-1 && lastseen[1]!=-1 && lastseen[2]!=-1){
                cnt+=Math.min(lastseen[0],Math.min(lastseen[1],lastseen[2]))+1;
            }
        }
        return cnt;
    }
